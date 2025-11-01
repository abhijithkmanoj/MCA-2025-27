const con = require('./connect.js');

// SQL query to update the name of rollno 3
const sql = "UPDATE T_db.students SET name = 'Raghavan' WHERE rollno = 3";

con.query(sql, (err, result) => {
  if (err) throw err;

  if (result.affectedRows === 0) {
    console.log('No student found with roll number 3.');
  } else {
    console.log('Name updated successfully!');
  }

  con.end(); // close the connection
});
