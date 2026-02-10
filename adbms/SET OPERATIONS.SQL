SELECT r.sid
FROM reserves r, boats b
WHERE r.bid = b.bid
AND b.color = 'red'
UNION
SELECT r.sid
FROM reserves r, boats b
WHERE r.bid = b.bid
AND b.color = 'green';


SELECT s.sname
FROM sailors s, reserves r
WHERE s.sid = r.sid
AND r.bid = 102;


SELECT sname, age
FROM sailors
WHERE age = (SELECT MIN(age) FROM sailors);


SELECT s.sname
FROM sailors s
WHERE NOT EXISTS (
    (SELECT bid FROM boats)
    MINUS
    (SELECT bid FROM reserves WHERE sid = s.sid)
);
