--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
DROP TABLE if EXISTS question;
DROP TABLE if EXISTS answer;

--table to store our questions
CREATE TABLE question (
    question_id int NOT NULL,
    question_text varchar(255) NOT NULL,
    answer_id int,
    PRIMARY KEY (question_id),
    FOREIGN KEY (question_id) REFERENCES answer(answer_id)
    );

CREATE TABLE answer (
   answer_id int NOT NULL,
   choice_list varchar(255) NOT NULL,
   correct_answer int,
   PRIMARY KEY (answer_id),
   FOREIGN KEY (correct_answer) REFERENCES question(answer_id)
    );


INSERT INTO question(question_id, question_text, answer_id) VALUES (1, 'hello', 2);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'sadfas', 0);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'gdagd', 0);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'svcvc', 0);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (4, 'sa343', 1);

-- get all questions
--  delete all questions if  answered
-- update certain questions

    -- add questions with choices and answers for those questions

-- do we need test cases?
