create database hrms_ajax;
use hrms_ajax;

CREATE TABLE manager (
    mid INT PRIMARY KEY AUTO_INCREMENT,
    mname VARCHAR(100) NOT NULL
);

CREATE TABLE emps (
    eid INT PRIMARY KEY AUTO_INCREMENT,
    ename VARCHAR(100) NOT NULL,
    esalary DOUBLE NOT NULL,
    mid INT,
    CONSTRAINT fk_employee_manager
        FOREIGN KEY (mid)
        REFERENCES manager(mid)
);

INSERT INTO manager (mname) VALUES
('Rajesh Sharma'),
('Amit Patil'),
('Priya Deshmukh'),
('Neha Kulkarni');

INSERT INTO emps (ename, esalary, mid) VALUES
('Rahul Verma', 45000, 1),
('Sneha Joshi', 52000, 2),
('Vikas Singh', 48000, 1),
('Anjali Mehta', 60000, 3);

Select  * from emps;