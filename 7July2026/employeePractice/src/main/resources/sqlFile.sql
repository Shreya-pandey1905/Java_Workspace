create database em;
use em;

CREATE TABLE Manager (
    ManagerId INT PRIMARY KEY AUTO_INCREMENT,
    ManagerName VARCHAR(100) NOT NULL
);

CREATE TABLE Employee (
    eId INT PRIMARY KEY AUTO_INCREMENT,
    Ename VARCHAR(100) NOT NULL,
    esal decimal(10,2),
    mid INT,
    FOREIGN KEY (mid) REFERENCES Manager(ManagerId)
);

INSERT INTO Manager (ManagerName)
VALUES
('John Smith'),
('Rahul Sharma'),
('Priya Patel');

Select * from Employee;