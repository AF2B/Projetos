import React from "react";

function ComponentA(props){

    return(
        <div>
            <h1>Componente A =) <br /> {props.children}</h1>
        </div>
    )
}

export default ComponentA;