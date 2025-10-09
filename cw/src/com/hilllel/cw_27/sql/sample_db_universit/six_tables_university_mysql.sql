
-- ===============================================================
-- Six-Table University Demo (MySQL 8.0)
-- Tables: departments, instructors, courses, students, enrollments, payments
-- Purpose: JOINs, Aggregations, UNION/UNION ALL
-- ===============================================================

DROP DATABASE IF EXISTS uni6;
CREATE DATABASE uni6 CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE uni6;

SET FOREIGN_KEY_CHECKS=0;

-- 1) departments
CREATE TABLE departments (
  dept_id   BIGINT PRIMARY KEY AUTO_INCREMENT,
  code      VARCHAR(10) NOT NULL UNIQUE,
  name      VARCHAR(120) NOT NULL
) ENGINE=InnoDB;

-- 2) instructors
CREATE TABLE instructors (
  instructor_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  dept_id       BIGINT NOT NULL,
  first_name    VARCHAR(60) NOT NULL,
  last_name     VARCHAR(60) NOT NULL,
  email         VARCHAR(120) NOT NULL UNIQUE,
  hire_date     DATE NOT NULL,
  CONSTRAINT fk_instr_dept FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
) ENGINE=InnoDB;

-- 3) courses
CREATE TABLE courses (
  course_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  dept_id   BIGINT NOT NULL,
  code      VARCHAR(20) NOT NULL UNIQUE,
  title     VARCHAR(160) NOT NULL,
  credits   DECIMAL(3,1) NOT NULL,
  level     INT NOT NULL,
  instructor_id BIGINT NOT NULL,
  CONSTRAINT fk_courses_dept FOREIGN KEY (dept_id) REFERENCES departments(dept_id),
  CONSTRAINT fk_courses_instr FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
) ENGINE=InnoDB;

-- 4) students
CREATE TABLE students (
  student_id  BIGINT PRIMARY KEY AUTO_INCREMENT,
  dept_id     BIGINT NOT NULL,
  first_name  VARCHAR(60) NOT NULL,
  last_name   VARCHAR(60) NOT NULL,
  email       VARCHAR(120) NOT NULL UNIQUE,
  enrollment_year INT NOT NULL,
  status      ENUM('Active','OnLeave','Graduated') NOT NULL,
  CONSTRAINT fk_students_dept FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
) ENGINE=InnoDB;

-- 5) enrollments
CREATE TABLE enrollments (
  enrollment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  student_id    BIGINT NOT NULL,
  course_id     BIGINT NOT NULL,
  term          VARCHAR(12) NOT NULL,
  status        ENUM('Enrolled','Dropped','Completed') NOT NULL,
  final_grade   DECIMAL(5,2) NULL,
  UNIQUE KEY uniq_enr (student_id, course_id, term),
  CONSTRAINT fk_enr_student FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
  CONSTRAINT fk_enr_course  FOREIGN KEY (course_id)  REFERENCES courses(course_id)
) ENGINE=InnoDB;

-- 6) payments
CREATE TABLE payments (
  payment_id  BIGINT PRIMARY KEY AUTO_INCREMENT,
  student_id  BIGINT NOT NULL,
  paid_at     DATE NOT NULL,
  amount      DECIMAL(10,2) NOT NULL,
  method      ENUM('Card','Cash','Transfer') NOT NULL,
  CONSTRAINT fk_pay_student FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Indexes
CREATE INDEX idx_instr_dept   ON instructors(dept_id);
CREATE INDEX idx_course_dept  ON courses(dept_id);
CREATE INDEX idx_course_instr ON courses(instructor_id);
CREATE INDEX idx_stu_dept     ON students(dept_id);
CREATE INDEX idx_enr_student  ON enrollments(student_id);
CREATE INDEX idx_enr_course   ON enrollments(course_id);
CREATE INDEX idx_pay_student  ON payments(student_id);

-- Seed data
INSERT INTO departments (code,name) VALUES
('CS','Computer Science'),
('MATH','Mathematics'),
('BUS','Business');

-- Cache dept ids
SET @d_cs := (SELECT dept_id FROM departments WHERE code='CS');
SET @d_math := (SELECT dept_id FROM departments WHERE code='MATH');
SET @d_bus := (SELECT dept_id FROM departments WHERE code='BUS');

INSERT INTO instructors (dept_id, first_name, last_name, email, hire_date) VALUES
(@d_cs,'Ada','Lovelace','ada@u.demo','2016-09-01'),
(@d_cs,'Alan','Turing','alan@u.demo','2018-03-15'),
(@d_math,'Emmy','Noether','emmy@u.demo','2015-01-10'),
(@d_bus,'Peter','Drucker','peter@u.demo','2017-07-20');

SET @i_lovelace := (SELECT instructor_id FROM instructors WHERE last_name='Lovelace');
SET @i_turing   := (SELECT instructor_id FROM instructors WHERE last_name='Turing');
SET @i_noether  := (SELECT instructor_id FROM instructors WHERE last_name='Noether');
SET @i_drucker  := (SELECT instructor_id FROM instructors WHERE last_name='Drucker');

INSERT INTO courses (dept_id, code, title, credits, level, instructor_id) VALUES
(@d_cs,'CS101','Intro to Programming',3.0,100,@i_lovelace),
(@d_cs,'CS201','Data Structures',4.0,200,@i_turing),
(@d_cs,'CS301','Databases',4.0,300,@i_lovelace),
(@d_math,'MATH101','Calculus I',5.0,100,@i_noether),
(@d_bus,'BUS101','Microeconomics',3.0,100,@i_drucker),
(@d_bus,'BUS201','Accounting',3.0,200,@i_drucker);

INSERT INTO students (dept_id, first_name, last_name, email, enrollment_year, status) VALUES
(@d_cs,'Ivan','Petrov','ivan@demo.com',2021,'Active'),
(@d_cs,'Olga','Sokolova','olga@demo.com',2020,'Active'),
(@d_cs,'Max','Kuznetsov','max@demo.com',2022,'Active'),
(@d_math,'Oksana','Melnyk','oksana@demo.com',2022,'Active'),
(@d_math,'Taras','Hryn','taras@demo.com',2020,'OnLeave'),
(@d_bus,'Maria','Ivanova','maria@demo.com',2019,'Graduated'),
(@d_bus,'Pavlo','Orlov','pavlo@demo.com',2019,'Active'),
(@d_bus,'Roman','Savchenko','roman@demo.com',2019,'Active'),
(@d_cs,'Nina','Koval','nina@demo.com',2021,'Active'),
(@d_math,'Lesia','Petryk','lesia@demo.com',2020,'Active'),
(@d_cs,'Andrii','Marchenko','andrii@demo.com',2021,'OnLeave'),
(@d_cs,'Kateryna','Bondar','kat@demo.com',2021,'Active');

-- Enrollments Fall 2024
INSERT INTO enrollments (student_id, course_id, term, status, final_grade)
SELECT s.student_id, c.course_id, '2024FALL', 'Completed', ROUND(60 + RAND()*40,2)
FROM students s
JOIN courses c ON c.code IN ('CS101','MATH101','BUS101')
WHERE (s.dept_id=@d_cs AND c.code='CS101')
   OR (s.dept_id=@d_math AND c.code='MATH101')
   OR (s.dept_id=@d_bus AND c.code='BUS101');

-- Enrollments Spring 2025
INSERT INTO enrollments (student_id, course_id, term, status, final_grade)
SELECT s.student_id, c.course_id, '2025SPR', 'Enrolled', NULL
FROM students s
JOIN courses c ON c.code IN ('CS201','CS301','BUS201')
WHERE (s.dept_id=@d_cs AND c.code IN ('CS201','CS301'))
   OR (s.dept_id=@d_bus AND c.code='BUS201');

-- Payments
INSERT INTO payments (student_id, paid_at, amount, method) VALUES
((SELECT student_id FROM students WHERE email='ivan@demo.com'),'2024-09-15',1500.00,'Card'),
((SELECT student_id FROM students WHERE email='ivan@demo.com'),'2024-10-15',1500.00,'Transfer'),
((SELECT student_id FROM students WHERE email='olga@demo.com'),'2024-09-20',2000.00,'Cash'),
((SELECT student_id FROM students WHERE email='pavlo@demo.com'),'2024-09-25',1200.00,'Card'),
((SELECT student_id FROM students WHERE email='roman@demo.com'),'2024-10-05',1750.00,'Transfer'),
((SELECT student_id FROM students WHERE email='nina@demo.com'),'2024-10-12',1650.00,'Card');

SET FOREIGN_KEY_CHECKS=1;

-- =====================
-- Demo queries (JOIN/Aggregation/UNION)
-- =====================
-- 1) SELECT CONCAT(s.first_name,' ',s.last_name) AS student, d.code AS dept FROM students s JOIN departments d ON d.dept_id=s.dept_id;
-- 2) SELECT CONCAT(s.first_name,' ',s.last_name) AS student, c.code, c.title, CONCAT(i.first_name,' ',i.last_name) AS instructor
--    FROM enrollments e JOIN students s ON s.student_id=e.student_id JOIN courses c ON c.course_id=e.course_id JOIN instructors i ON i.instructor_id=c.instructor_id WHERE e.term='2024FALL';
-- 3) SELECT c.code, ROUND(AVG(e.final_grade),2) AS avg_grade FROM enrollments e JOIN courses c ON c.course_id=e.course_id WHERE e.term='2024FALL' AND e.status='Completed' GROUP BY c.code;
-- 4) SELECT status, COUNT(*) FROM students GROUP BY status;
-- 5) (UNION) SELECT CONCAT(first_name,' ',last_name) FROM students WHERE status='Active' UNION SELECT CONCAT(first_name,' ',last_name) FROM students WHERE status='OnLeave' ORDER BY 1;
-- 6) (UNION ALL) SELECT student_id, paid_at, amount, method FROM payments WHERE amount>1700 UNION ALL SELECT student_id, paid_at, amount, method FROM payments WHERE method='Card' ORDER BY paid_at;
-- 7) SELECT CONCAT(s.first_name,' ',s.last_name) AS student, p.paid_at, p.amount FROM students s LEFT JOIN payments p ON p.student_id=s.student_id ORDER BY student, p.paid_at;
-- 8) SELECT c.code, ROUND(AVG(e.final_grade),2) AS avg_grade FROM enrollments e JOIN courses c ON c.course_id=e.course_id WHERE e.term='2024FALL' AND e.status='Completed' GROUP BY c.code HAVING AVG(e.final_grade)>=80;
-- 9) SELECT CONCAT(i.first_name,' ',i.last_name) AS instructor, COUNT(DISTINCT e.student_id) AS unique_students FROM enrollments e JOIN courses c ON c.course_id=e.course_id JOIN instructors i ON i.instructor_id=c.instructor_id WHERE e.term='2024FALL' GROUP BY instructor ORDER BY unique_students DESC;
-- 10) SELECT c.code, ROUND(AVG(CASE WHEN e.final_grade>=60 THEN 1 ELSE 0 END),3) AS pass_rate FROM enrollments e JOIN courses c ON c.course_id=e.course_id WHERE e.term='2024FALL' AND e.status='Completed' GROUP BY c.code ORDER BY pass_rate DESC;
-- 11) (UNION) SELECT CONCAT(s.first_name,' ',s.last_name) AS name, 'SPR25 Enrolled' AS bucket FROM enrollments e JOIN students s ON s.student_id=e.student_id WHERE e.term='2025SPR' AND e.status='Enrolled' UNION SELECT CONCAT(s.first_name,' ',s.last_name), 'FALL24 Completed' FROM enrollments e JOIN students s ON s.student_id=e.student_id WHERE e.term='2024FALL' AND e.status='Completed' ORDER BY name, bucket;
-- 12) (Window-like alt) SELECT c.code, ROUND(AVG(e.final_grade),2) AS avg_grade FROM enrollments e JOIN courses c ON c.course_id=e.course_id WHERE e.term='2024FALL' AND e.status='Completed' GROUP BY c.code ORDER BY avg_grade DESC;
