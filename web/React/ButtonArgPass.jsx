import React from 'react'
import ButtonArgGet from './ButtonArgGet'

function ButtonArgPass() {
  return (
    <div style={{display:'flex',gap:'10px'}}>
        <ButtonArgGet color="red" bg="#fff" con="submit"/>
        <ButtonArgGet color="green" bg="black" con="send"/>
        <ButtonArgGet color="black" bg="yellow" con="click me"/>
    </div>
  )
}

export default ButtonArgPass