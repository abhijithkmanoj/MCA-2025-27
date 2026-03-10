CREATE OR REPLACE PROCEDURE get_min (
    val1 IN NUMBER,
    val2 IN NUMBER,
    min  OUT NUMBER
) IS
BEGIN
    IF val1 < val2 THEN
        min := val1;
    ELSE
        min := val2;
    END IF;
END;
/

DECLARE
    num1 NUMBER := &first_value;
    num2 NUMBER := &second_value;
    result NUMBER;
BEGIN
    get_min(num1, num2, result);
    DBMS_OUTPUT.PUT_LINE('The minimum value is: ' || result);
END;
/