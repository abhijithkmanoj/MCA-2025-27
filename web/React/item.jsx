import React from "react";

function Item({name}){

    return(

        <li

        style={{
            align:"center",

            background:"purple",

            margin:"8px auto",

            padding:"10px 20px",

            width:"200px",

            borderRadius:"10px",

        }}

        >

            {name}

        </li>

    );

}

export default Item;
