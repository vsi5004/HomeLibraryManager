CREATE TABLE APP_USER
(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
username VARCHAR(50),
password VARCHAR(50),
security_question VARCHAR(50),
security_answer VARCHAR(50),
user_type VARCHAR(50),
CONSTRAINT user_pk PRIMARY KEY (id)
);

INSERT INTO APP_USER (username, password, security_question, security_answer, user_type) VALUES ('test', 'test', 'What is your favorite color?','blue','administrator');