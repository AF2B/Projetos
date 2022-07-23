import { Component } from "react";

class ButtonAltera extends Component{
    constructor(props){
        super(props);

        this.state = {
            Modelo: "Azera",
            Marca: "Hyundai",
            Ano: 2013, 
            Cor: "Prata",
        };
    };

    mudaCor = () => {
        this.setState({
            Cor: "Vermelho"
        });
        if(this.state.Cor === "Vermelho"){
            this.setState({
                Cor: "Azul"
            });
        }
    }

    render() {
        const { Modelo, Marca, Cor, Ano } = this.state
        const { name } = this.props
        return(
            <div>
                <h1>As especificações do meu carro é...</h1>
                <p>Meu nome é: {name}</p>
                <p>Modelo: {Modelo}</p>
                <p>Marca: {Marca}</p>
                <p>Cor: {Cor}</p>
                <p>Ano: {Ano}</p>
                <br></br>
                <button type="button" onClick={this.mudaCor.bind(this)}>Mudar-cor-Carro</button>
                <br></br>
            </div>
        )
    }
}

export default ButtonAltera;