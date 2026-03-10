CREATE OR REPLACE FUNCTION get_circle_area (
    radius NUMBER
) RETURN NUMBER
IS
    area NUMBER;
    pi CONSTANT NUMBER := 3.14;
BEGIN
    area := pi * POWER(radius, 2);
    RETURN area;
END;
/

DECLARE
    r NUMBER := &radius;
    area NUMBER;
BEGIN
    area := get_circle_area(r);
    DBMS_OUTPUT.PUT_LINE('Area of the circle: ' || area);
END;
/