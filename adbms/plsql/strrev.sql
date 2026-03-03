SET SERVEROUTPUT ON;
SET VERIFY OFF;

DECLARE
    str      VARCHAR(100);
    rev_str  VARCHAR(100) := '';
    i        NUMBER;
BEGIN
    str := '&str';

    -- Loop from last character to first
    FOR i IN REVERSE 1..LENGTH(str) LOOP
        rev_str := rev_str || SUBSTR(str, i, 1);
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Original String : ' || str);
    DBMS_OUTPUT.PUT_LINE('Reversed String : ' || rev_str);
END;
/