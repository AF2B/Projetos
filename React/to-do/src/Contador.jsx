import { Component } from "react";

class Contador extends Component{
    constructor(props){
        super(props)

        this.state = {
            contador: 0,
        }
    }

    componentDidMount(){
        setTimeout(() => {
            this.setState({
                contador: 1
            })
        }, 1000)
    }

    incrementar = () => {
        this.setState({
            contador: this.state.contador + 1
        })
    }

    decrementar = () => {
        this.setState({
            contador: this.state.contador - 1
        })
    }

    render(){
        return(
            <div>
                <h1>{this.state.contador}</h1>
                <button onClick={this.incrementar}>+</button>
                <button onClick={this.decrementar}>-</button>
            </div>
        )
    }
}

export default Contador;