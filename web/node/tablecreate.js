const con = require('./connect.js');
 
const cr_Tb = `
CREATE TABLE IF NOT EXISTS T_db.students (
    rollno INT PRIMARY KEY,
    name VARCHAR(15),
    course VARCHAR(25),
    age INT
);
`;

 
// Run the query
con.query(cr_Tb, (err) => {
    if (err) throw err;
    console.log('Table students created');
});