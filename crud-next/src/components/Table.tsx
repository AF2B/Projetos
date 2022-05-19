import Client from "../core/Client"
import { IconEdit, IconTrash } from "./Icons"

interface TableProps {
    client: Client[]
    selectedClient?: (client: Client) => void
    deleteClient?: (client: Client) => void
}

export default function Table(props) {

    const viewActions = props.selectedClient || props.deleteClient

    function renderTableColumn() {
        return (
            <tr>
                <th className="text-left p-4">ID</th>
                <th className="text-left p-4">Nome</th>
                <th className="text-left p-4">Idade</th>
                {viewActions ? (<th className="p-4">Ações</th>) : false}
            </tr>
        )
    }

    function renderData() {
        return props.client?.map((client, i) => {
            return (
                <tr key={client.Id} className={`${i % 2 === 0 ? "bg-gray-200" : "bg-gray-100"}`}>
                    <td className="text-left p-4">{client.Id}</td>
                    <td className="text-left p-4">{client.Name}</td>
                    <td className="text-left p-4">{client.Age}</td>
                    {viewActions ? renderActions(client) : false}
                </tr>
            )
        })
    }

    function renderActions(client: Client) {
        return (
            <td className="flex justify-center">
                {props.selectedClient ? (
                    <button onClick={() => props.selectedClient?.(client)} className="flex 
                    justify-center 
                    items-center text-green-500 rounded-full hover:bg-green-600 p-2 m-1">{IconEdit}
                    </button>
                ) : false}

                {props.deleteClient ? (
                    <button onClick={() => props.deleteClient?.(client)} className="flex 
                    justify-center 
                    items-center text-red-500 rounded-full 
                    hover:bg-red-600 p-2 m-1">{IconTrash}</button>
                ) : false}
            </td>
        )
    }

    return (
        <table className="w-full rounded-xl overflow-hidden">
            <thead className="bg-gradient-to-r from-black to-gray-600 text-gray-200">
                {renderTableColumn()}
            </thead>
            <tbody>
                {renderData()}
            </tbody>
        </table>
    )
}