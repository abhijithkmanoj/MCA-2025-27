CREATE TABLE employee2 (
    empid   NUMBER(10) PRIMARY KEY,
    empname VARCHAR2(20),
    deptid  NUMBER(38),
    CONSTRAINT emp2_dept_fk
        FOREIGN KEY (deptid)
        REFERENCES department (deptid)
);

CREATE TABLE employee2 (
    empid   NUMBER(10) PRIMARY KEY,
    empname VARCHAR(20),
    DEPID NUMBER(5),
    SALARY NUMBER(7,2) 
    DEPT FOREIGN KEY (deptid) REFERENCES department (deptid)

 FOREIGN KEY (deptid)
        REFERENCES department (deptid) );


        CREATE TABLE department (
    depId NUMBER PRIMARY KEY,
    dept_name VARCHAR(50) UNIQUE NOT NULL,
    hod VARCHAR(50)
);


CREATE TABLE employee2 (
    empId NUMBER PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    depTId NUMBER,
    salary NUMBER CHECK (salary > 0),
    FOREIGN KEY (depTId) REFERENCES department(depTId)
);

CREATE TABLE EMPLOYEE1 (
    EMP_ID INT PRIMARY KEY,
    EMP_NAME VARCHAR(40),
    DOB VARCHAR(30),
    DEPT VARCHAR(30),
    DESIGNATION VARCHAR(30),
    SALARY INT);

CREATE TABLE PRODUCTS (
    PRODUCTID   NUMBER(5) PRIMARY KEY,
    PRODUCTNAME VARCHAR2(20),
    CATEGORYID  NUMBER(5),
    PRICE       NUMBER(7,2),
    FOREIGN KEY (CATEGORYID) REFERENCES CATEGORIES(CATEGORYID)
);


CREATE TABLE Sailors (
    Sid INT PRIMARY KEY,
    Sname VARCHAR(30),
    Rating INT,
    Age INT
);


CREATE TABLE Boats (
    Bid INT PRIMARY KEY,
    Bname VARCHAR(30),
    Color VARCHAR(15)
);

CREATE TABLE Reserves (
    Sid INT,
    Bid INT,
    Day DATE,
    PRIMARY KEY (Sid, Bid, Day),
    FOREIGN KEY (Sid) REFERENCES Sailors(Sid),
    FOREIGN KEY (Bid) REFERENCES Boats(Bid)
);



