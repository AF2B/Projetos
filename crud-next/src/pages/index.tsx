import Layout from "../components/Layout";
import Table from "../components/Table";
import Client from "../core/Client";

export default function Home() {
    const client = [
        new Client('Ana', 22, '1'),
        new Client('Alícia', 23, '2'),
        new Client('Eduarda', 21, '3')
    ]

    function selectedClient(client: Client) {

    }

    function deleteClient(client: Client) {

    }

    return (
        <div className="flex 
        justify-center 
        items-center 
        h-screen 
        bg-gradient-to-r
        from-black to bg-gray-500">

            <Layout title="Cadastro">
                <Table client={client} selectedClient={selectedClient} deleteClient={deleteClient}/>
            </Layout>
        </div>
    )
}