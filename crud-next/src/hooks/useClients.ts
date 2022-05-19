import { useEffect, useState } from "react";
import Client from "../core/Client";
import ClientRepository from "../core/ClientRepository";
import CollectionClient from "../firebase/db/CollectionClient";
import useTableOrForm from "./useTableOrForm";

export default function useClients() {
    const repo: ClientRepository = new CollectionClient()

    const { viewTable, viewForm, visibleForm, visibleTable } = useTableOrForm()

    //const [visible, setVisible] = useState<"table" | "form">("table")
    const [clients, setClients] = useState<Client[]>([])
    const [client, setClient] = useState<Client>(Client.clientNull())

    useEffect(getAll, [])

    function getAll() {
        repo.readAll().then(clients => {
            setClients(clients)
            viewTable()
        })
    }

    function selectedClient(client: Client) {
        setClient(client)
        viewForm()
    }

    function newClient() {
        setClient(Client.clientNull())
        viewForm()
    }

    async function deleteClient(client: Client) {
        await repo.delete(client)
        getAll()
    }

    async function saveClient(client: Client) {
        await repo.save(client)
        getAll()
    }

    return {
        saveClient,
        deleteClient,
        selectedClient,
        getAll,
        newClient,
        client,
        clients,
        visibleTable,
        viewTable
    }
}