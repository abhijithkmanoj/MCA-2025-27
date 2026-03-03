SET SERVEROUTPUT ON;
SET VERIFY OFF;

DECLARE
    num NUMBER := &num;      -- User input
    fact NUMBER := 1;        -- Initialize factorial
    i   NUMBER;
BEGIN
    IF num < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Factorial not defined for negative numbers.');
    ELSIF num = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Factorial of 0 is 1');
    ELSE
        FOR i IN 1..num LOOP
            fact := fact * i;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('Factorial of ' || num || ' is: ' || fact);
    END IF;
END;
/