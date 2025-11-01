const con = require('./connect.js');
const sql = 'DELETE FROM T_db.students WHERE rollno = 3';
con.query(sql,(err, result) => {
      if (err) throw err;
      console.log('Thats it!');
      //con.end(); // close the connection
  });