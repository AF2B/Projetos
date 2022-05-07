import React, { Component } from "react";

import Main from '../templates/Main'

const headerProps = {
    icon: 'users',
    title: 'Usuários',
    subtitle: 'Cadastro de usuário: Adicionar, Listar, Modificar, Excluir'
}

export default class User extends Component {
    render() {
        return (
            <Main {...headerProps}>
                Cadastro...
            </Main>
        )
    }
}