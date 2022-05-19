import Button from "../components/Button";
import Form from "../components/Form";
import Layout from "../components/Layout";
import Table from "../components/Table";
import useClients from "../hooks/useClients";

export default function Home() {

    const { newClient, selectedClient, saveClient, deleteClient, client, clients, visibleTable, viewTable } = useClients()

    return (
        <div className="flex 
        justify-center 
        items-center 
        h-screen 
        bg-gradient-to-r
        from-black to bg-gray-500">

            <Layout title="Cadastro">
                {visibleTable ? (
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
                        cancel={viewTable}
                        clientChange={saveClient} />
                )}
            </Layout>
        </div>
    )
}