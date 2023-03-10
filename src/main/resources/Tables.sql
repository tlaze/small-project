--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
DROP TABLE if EXISTS question cascade;
DROP TABLE if EXISTS answer;

--table to store our questions
CREATE TABLE question (
    question_id int NOT NULL,
    question_text varchar(255) NOT NULL,
    answer_id int,
    PRIMARY KEY (question_id)
    );

CREATE TABLE answer (
   answer_id int NOT NULL,
   choice_list varchar(255) NOT NULL,
   correct_answer int
    );


INSERT INTO question(question_id, question_text, answer_id) VALUES (1, 'question1', 1);
INSERT INTO question(question_id, question_text, answer_id) VALUES (2, 'question2', 1);

INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'answer1', 0);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'answer2', 0);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'answer3', 0);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'answer4', 1);

INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'answer1', 0);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'answer2', 1);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'answer3', 0);
INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'answer4', 0);

-- get all questions
--  delete all questions if  answered
-- update certain questions

    -- add questions with choices and answers for those questions

-- do we need test cases?
