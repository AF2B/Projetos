import { TableHTMLAttributes, useEffect, useState } from "react";
import Button from "../components/Button";
import Form from "../components/Form";
import Layout from "../components/Layout";
import Table from "../components/Table";
import Client from "../core/Client";
import ClientRepository from "../core/ClientRepository";
import CollectionClient from "../firebase/db/CollectionClient";

export default function Home() {

    const repo: ClientRepository = new CollectionClient()

    const [visible, setVisible] = useState<"table" | "form">("table")
    const [clients, setClients] = useState<Client[]>([])
    const [client, setClient] = useState<Client>(Client.clientNull())

    useEffect(getAll, [])

    function getAll() {
        repo.readAll().then(clients => {
            setClients(clients)
            setVisible("table")
        })
    }

    function selectedClient(client: Client) {
        setClient(client)
        setVisible("form")
    }

    function newClient() {
        setClient(Client.clientNull())
        setVisible("form")
    }

    async function deleteClient(client: Client) {
        await repo.delete(client)
        getAll()
    }

    async function saveClient(client: Client) {
        await repo.save(client)
        getAll()
    }

    return (
        <div className="flex 
        justify-center 
        items-center 
        h-screen 
        bg-gradient-to-r
        from-black to bg-gray-500">

            <Layout title="Cadastro">
                {visible === "table" ? (
                    <>
                        <div className="flex justify-end">
                            <Button onClick={newClient}
                                className="mb-4">Novo Cliente</Button>
                        </div>
                        <Table client={clients}
                            selectedClient={selectedClient}
                            deleteClient={deleteClient} />
                    </>
                ) : (
                    <Form client={client}
                        cancel={() => setVisible("table")}
                        clientChange={saveClient} />
                )}
            </Layout>
        </div>
    )
}