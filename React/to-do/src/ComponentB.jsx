import React from "react";

function ComponentB(props){
    return(
        <div>
            <h2>Eu sou o componente B!!!! {props.children}</h2>
        </div>
    )
}


export default ComponentB;