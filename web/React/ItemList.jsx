import React from "react";

import Item from "./item.jsx";



function Itemlist() {

  const items = ["Laptop", "Keyboard", "Monitor", "Headphones"];

  return (

    <ul style={{ listStyle: "none", padding: 0 }}>

      {items.map((i, index) => (

        <Item key={index} name={i} />

      ))}

    </ul>

  );

}



export default Itemlist;
