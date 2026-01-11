import React, { useState, useEffect } from 'react';

function App() {
  const [title, setTitle] = useState("");   // For the input field
  const [wishlist, setWishlist] = useState([]); // For the display list

  // 1. Function to FETCH the wishlist from Node
  const fetchWishlist = () => {
    fetch('http://localhost:5000/get-wishlist')
      .then(res => res.json())
      .then(data => setWishlist(data));
  };

  // Run fetchWishlist once when the page loads
  useEffect(() => {
    fetchWishlist();
  }, []);

  // 2. Function to SEND a new book to Node
  const addToWishlist = () => {
    fetch('http://localhost:5000/add-book', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ title: title })
    })
    .then(() => {
      fetchWishlist(); // Refresh the list after adding
      setTitle("");    // Clear the input box
    });
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Library Wishlist</h1>
      
      {/* Input Section */}
      <input 
        type="text" 
        placeholder="Enter Book Title" 
        value={title}
        onChange={(e) => setTitle(e.target.value)} 
      />
      <button onClick={addToWishlist}>Add to Wishlist</button>

      <hr />

      {/* Display Section */}
      <h2>My Wishlist</h2>
      <ul>
        {wishlist.map((book) => (
          <li key={book.id}>{book.title}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
