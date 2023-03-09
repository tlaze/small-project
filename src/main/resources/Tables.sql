--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
DROP TABLE if EXISTS question;
DROP TABLE if EXISTS answer;

--table to store our questions
CREATE TABLE question (
    question_id int PRIMARY KEY,
    question_text varchar(255) NOT NULL,
    answer_id int
--.    FOREIGN KEY(answer_id) REFERENCES answer(answer_id)
    );

 table to store our choices from our questions pool
CREATE TABLE answer (
    answer_id int PRIMARY KEY,
    choice_list VARCHAR (255),
    is_correct BIT,
    FOREIGN KEY (question_id) REFERENCES questions(question_id)
    );


INSERT INTO question(question_id, question_text, answer_id) VALUES (1, 'hello', 2);
INSERT INTO answer(answer_id, choice_list, isCorrect) Values (2, 'sadfas', true);

-- get all questions
--  delete all questions if  answered
-- update certain questions

    -- add questions with choices and answers for those questions

-- do we need test cases?
