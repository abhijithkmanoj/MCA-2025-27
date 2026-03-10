CREATE OR REPLACE FUNCTION reverse_string (
    str VARCHAR2
) RETURN VARCHAR2
IS
    rev VARCHAR2(100) := '';
    len NUMBER;
BEGIN
    len := LENGTH(str);

    FOR i IN REVERSE 1..len LOOP
        rev := rev || SUBSTR(str, i, 1);
    END LOOP;

    RETURN rev;
END;
/

DECLARE
    original VARCHAR2(50) := '&string';
    reversed VARCHAR2(50);
BEGIN
    reversed := reverse_string(original);
    DBMS_OUTPUT.PUT_LINE('Reversed String: ' || reversed);
END;
/