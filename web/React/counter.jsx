import React, { useState, useEffect } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  useEffect(() => {
       document.querySelector('h2').textContent = `Count: ${count}`;
  }, [count]);

  return (
    <div>
      <h1>Counter</h1>
      <div>
        <button onClick={() => setCount(count + 1)}>Increment</button>
        <button onClick={() => setCount(count - 1)}>Decrement</button>
      </div>
    </div>
  );
}

export default Counter;
