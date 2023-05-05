DROP TABLE IF EXISTS student;
CREATE TABLE student
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    age INT,
    email VARCHAR(50)
);