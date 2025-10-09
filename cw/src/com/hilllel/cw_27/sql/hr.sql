CREATE TABLE Employee (
    id INT PRIMARY KEY,
    full_name VARCHAR(50),
    dep_id INT,
    salary DECIMAL(10, 2)
);

CREATE TABLE Department (
    id INT PRIMARY KEY,
    dep_name VARCHAR(100)
);

INSERT INTO Department (id, dep_name) VALUES
(1, 'IT'),
(2, 'HR'),
(3, 'Sales');
