import { useState } from 'react'
import Client from '../core/Client'
import Button from './Button'
import Input from './Input'

interface FormProps {
    client: Client
    cancel?: () => void
    clientChange?: (client: Client) => void
}

export default function Form(props: FormProps) {
    const id = props.client?.Id ?? null
    const [name, setName] = useState(props.client?.Name ?? '')
    const [age, setAge] = useState(props.client?.Age ?? 0)

    return (
        <div>
            {id ? (
                <Input text="ID: " value={id} justRead className="mb-4 ml-7" />
            ) : false}

            <Input text="Nome: " value={name} valueChange={setName} className="mb-4" />
            <Input text="Idade: " value={age} type="number" valueChange={setAge} className="ml-1"/>
            <div className="flex justify-end mt-3">
                <Button onClick={() => props.clientChange?.(new Client(name, age, id))} className="mr-2">{id ? "Alterar" : "Salvar"}</Button>
                <Button onClick={props.cancel} className="">Cancelar</Button>
            </div>
        </div>
    )
}