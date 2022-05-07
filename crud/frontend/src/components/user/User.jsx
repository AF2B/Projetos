import React, { Component } from "react";
import axios from 'axios'

import Main from '../templates/Main'

const headerProps = {
    icon: 'users',
    title: 'Usuários',
    subtitle: 'Cadastro de usuário: Adicionar, Listar, Modificar, Excluir'
}

const baseUrl = "http://localhost:3001/users"
const initialState = {
    user: { name: "", email: "" },
    list: []
}

export default class User extends Component {
    state = { ...initialState }

    clear() {
        this.setState({
            user: initialState.user
        })
    }

    getUpdatedList(user) {
        const list = this.state.list.filter(usr => usr.id !== user.id)
        list.unshift(user)
        return list
    }

    save() {
        const user = this.state.user
        const method = user.id ? "put" : "post"
        const url = user.id ? `${baseUrl}/${user.id}` : baseUrl
        axios[method](url, user)
            .then(response => {
                const list = this.getUpdatedList(response.data)
                this.setState({
                    user: initialState,
                    list
                })
            })
    }

    render() {
        return (
            <Main {...headerProps}>
                Cadastro...
            </Main>
        )
    }
}