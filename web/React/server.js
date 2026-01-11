const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');

const app = express();
app.use(cors()); // Allows React to talk to Node
app.use(express.json()); // Allows Node to read JSON from React

// MySQL Connection
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',      // Your MySQL username
    password: 'password', // Your MySQL password
    database: 'library_db'
});

// 1. POST: Save a book to the wishlist
app.post('/add-book', (req, res) => {
    const bookTitle = req.body.title;
    const sql = "INSERT INTO wishlist (title) VALUES (?)";
    db.query(sql, [bookTitle], (err, result) => {
        if (err) return res.status(500).json(err);
        res.json({ message: "Book added!" });
    });
});

// 2. GET: Retrieve all books for the wishlist
app.get('/get-wishlist', (req, res) => {
    const sql = "SELECT * FROM wishlist";
    db.query(sql, (err, results) => {
        if (err) return res.status(500).json(err);
        res.json(results);
    });
});

app.listen(5000, () => console.log("Server running on port 5000"));
