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

    constructor(props) {
        super(props)
        this.clear = this.clear.bind(this)
        this.getUpdatedList = this.getUpdatedList.bind(this)
        this.updateField = this.updateField.bind(this)
        this.renderForm = this.renderForm.bind(this)
        this.save = this.save.bind(this)
    }

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

    updateField(event) {
        const user = { ...this.state.user }
        user[event.target.name] = event.target.value
        this.setState({ user })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Nome</label>
                            <input type="text" className="form-control"
                                name="name" value={this.state.user.name}
                                onChange={this.updateField}
                                placeholder="nome" />
                        </div>
                    </div>
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>E-mail</label>
                            <input type="text" className="form-control"
                                name="email" value={this.state.user.email}
                                onChange={this.updateField}
                                placeholder="e-mail" />
                        </div>
                    </div>
                </div>
                <hr />
                <div className="row">
                    <div className="col-12 d-flex justify-content-end">
                        <button className="btn btn-primary" onClick={this.save}>
                            Salvar
                        </button>
                        <button className="btn btn-secondary ml-2" onClick={this.clear}>
                            Cancelar
                        </button>
                    </div>
                </div>
            </div>
        )
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
                {this.renderForm()}
            </Main>
        )
    }
}