SET SERVEROUTPUT ON;
SET VERIFY OFF;

DECLARE
    num NUMBER;
BEGIN
    num := &num;

    IF MOD(num, 2) = 0 THEN
        DBMS_OUTPUT.PUT_LINE(num || ' is Even');
    ELSE
        DBMS_OUTPUT.PUT_LINE(num || ' is Odd');
    END IF;
END;
/