CREATE TABLE students
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    birthdate    DATE NOT NULL,
    email        VARCHAR(100) UNIQUE,
    zip_code     VARCHAR(9) NOT NULL,
    state        VARCHAR(80) NOT NULL,
    city         VARCHAR(50) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    street       VARCHAR(100),
    number       VARCHAR(20)
);

CREATE TABLE subjects
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE teachers
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    cpf          VARCHAR(11) NOT NULL UNIQUE,
    subject_id   BIGINT NOT NULL,
    zip_code     VARCHAR(9) NOT NULL,
    state        VARCHAR(80) NOT NULL,
    city         VARCHAR(50) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    street       VARCHAR(100),
    number       VARCHAR(20),
    CONSTRAINT fk_teachers_on_subject FOREIGN KEY (subject_id) REFERENCES subjects (id)
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE students_subjects
(
    student_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    CONSTRAINT pk_enr PRIMARY KEY (student_id, subject_id),
    CONSTRAINT fk_enr_on_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_enr_on_subject FOREIGN KEY (subject_id) REFERENCES subjects (id)
);