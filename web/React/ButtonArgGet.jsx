import React from 'react'

function ButtonArgGet(props) {
  return (
    <div>
        <button style={{width:"70px",height:"40px",color:props.color,background:props.bg}}>{props.con}</button>
    </div>
  )
}

export default ButtonArgGet