const con = require('./connect.js');
 
// SQL query to insert one record
const sql = "INSERT INTO T_db.students (rollno, name, course, age) VALUES (1, 'Ram','B.Sc CS',21),(2, 'Ujwal','B.Sc CS',30),(3, 'Hernandes','BCA',48),(4, 'Mario','BCA',93),(5, 'Suneesh','B.Sc CS',18)";
 
con.query(sql, (err, result) => {
  if (err) throw err;
  console.log('Record inserted successfully!');
  //con.end(); // close the connection
});