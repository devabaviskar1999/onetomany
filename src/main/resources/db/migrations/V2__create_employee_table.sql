CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    department_id BIGINT,
    CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department(id)
);