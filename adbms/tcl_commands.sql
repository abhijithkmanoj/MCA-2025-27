INSERT INTO stu VALUES (1, 'Abhijith');
INSERT INTO stu VALUES (2, 'Abhinav');
INSERT INTO stu VALUES (3, 'Abhirami');

COMMIT;

SELECT * FROM stu;


SAVEPOINT sp1;

INSERT INTO stu VALUES (4, 'Adish');
INSERT INTO stu VALUES (5, 'Adithya');

SELECT * FROM stu;



ROLLBACK;

SELECT * FROM stu;



INSERT INTO stu VALUES (6, 'Adon');
INSERT INTO stu VALUES (7, 'Ajay');
INSERT INTO stu VALUES (8, 'Aleena');

COMMIT;

SELECT * FROM stu;



SAVEPOINT sp2;

INSERT INTO stu VALUES (9, 'Alen');
INSERT INTO stu VALUES (10, 'Alviya');
INSERT INTO stu VALUES (11, 'Amana');
INSERT INTO stu VALUES (12, 'Ambadi');

ROLLBACK TO sp2;

SELECT * FROM stu;
