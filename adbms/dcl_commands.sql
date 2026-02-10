-- Create User
CREATE USER Abhijith IDENTIFIED BY password123;

-- List Users (Requires access to all_users or dba_users)
-- SELECT Abhijith FROM all_users;


-- Granting SELECT and INSERT on your 'stu' table to the new user
GRANT CREATE SESSION TO Abhijith;;


SELECT username FROM dba_users;

-- (Switch to user Abhijith to perform operations)
-- CONN Abhijith/password123;
-- SELECT * FROM sys.stu;



CREATE TABLE student_tb (
    sid NUMBER,
    sname VARCHAR2(20)
);

GRANT SELECT, INSERT, UPDATE ON student_tb TO Abhijith;



CONNECT Abhijith/password123;

INSERT INTO sys.student_tb VALUES (1, 'Abhi');

SELECT * FROM sys.student_tb;

UPDATE sys.student_tb SET sname='Jith' WHERE sid=1;
-- error check below
DELETE FROM sys.student_tb WHERE sid=1;




CONNECT sys/password;

GRANT DBA TO Abhijith;




CONNECT Abhijith/password123;

CREATE USER Abhi2 IDENTIFIED BY password123;
GRANT CREATE SESSION TO Abhi2;



-- for all object priveleges
GRANT ALL ON sys.student_tb TO Abhi2;

GRANT SELECT ON sys.student_tb TO Abhi2;

--invalid condition
drop table sys.student_tb;




CONNECT Abhi2/password123;

SELECT * FROM sys.student_tb;
-- error check below
INSERT INTO sys.student_tb VALUES (2, 'Abhijith');


--for revoek all
REVOKE ALL ON sys.student_tb FROM Abhi2;

REVOKE SELECT ON sys.student_tb FROM Abhi2;
-- error check below
SELECT * FROM sys.student_tb;



REVOKE DBA FROM Abhijith;
-- error check below
SELECT * FROM dba_users;



DROP USER Abhi2 CASCADE;
