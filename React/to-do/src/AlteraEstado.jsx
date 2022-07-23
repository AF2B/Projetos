import React from "react";

function AlteraEstado(props){
    return(
        <div>
            <h1>Quem vive na minha garagem? {props.children}</h1>
        </div>
    )
}

export default AlteraEstado;