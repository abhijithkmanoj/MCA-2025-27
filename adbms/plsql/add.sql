SET SERVEROUTPUT ON;

DECLARE
    num1    NUMBER := 15;
    num2    NUMBER := 25;
    result  NUMBER;
BEGIN

    result := num1 + num2;

    dbms_output.put_line('The sum of ' || num1 || ' and ' || num2 || ' is: ' || result);
END;
/