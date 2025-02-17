CREATE TABLE students
(
    id           BIGINT PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    birthdate    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    zip_code     VARCHAR(9) NOT NULL,
    state        VARCHAR(80) NOT NULL,
    city         VARCHAR(50) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    street       VARCHAR(100),
    number       VARCHAR(20)
);

CREATE TABLE subjects
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE teachers
(
    id           BIGINT PRIMARY KEY,
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

CREATE TABLE enrollments
(
    student_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    CONSTRAINT pk_enr PRIMARY KEY (student_id, subject_id),
    CONSTRAINT fk_enr_on_student FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_enr_on_subject FOREIGN KEY (subject_id) REFERENCES subjects (id)
);