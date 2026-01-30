SELECT *
FROM Sailors
WHERE Sid IN (
    SELECT Sid
    FROM Reserves
    WHERE Bid = 101 OR Bid = 103
);


SELECT Sname
FROM Sailors
WHERE Sid IN (
    SELECT DISTINCT Sid
    FROM Reserves
);

SELECT Sname
FROM Sailors
WHERE Sid IN (
    SELECT R.Sid
    FROM Reserves R
    WHERE R.Bid IN (
        SELECT B.Bid
        FROM Boats B
        WHERE B.Color = 'Red'
    )
)
ORDER BY Age;


SELECT Sid, Sname
FROM Sailors
WHERE Sid IN (
    SELECT R1.Sid
    FROM Reserves R1, Reserves R2
    WHERE R1.Sid = R2.Sid
      AND R1.Day = R2.Day
      AND R1.Bid <> R2.Bid
);


SELECT Sname, Age
FROM Sailors
WHERE Age = (
    SELECT MIN(Age)
    FROM Sailors
);


SELECT SNAME
FROM Sailors S
WHERE NOT EXISTS (
    SELECT *
    FROM Boats B
    WHERE NOT EXISTS (
        SELECT *
        FROM Reserves R
        WHERE R.Sid = S.Sid
          AND R.Bid = B.Bid
    )
);




