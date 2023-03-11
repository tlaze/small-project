--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
DROP TABLE if EXISTS question cascade;
DROP TABLE if EXISTS answer;

--table to store our questions
CREATE TABLE question (
    question_id int,
    question_text varchar(255),
    PRIMARY KEY (question_id)
    );

 --table to store our choices from our questions pool
CREATE TABLE answer (
   answer_id int,
   choice_list varchar(255),
   correct_answer varchar(255),
   FOREIGN KEY (answer_id) REFERENCES question(question_id) ON DELETE CASCADE
    );

--INSERT INTO question(question_id, question_text) VALUES (1, 'question1');
--INSERT INTO question(question_id, question_text) VALUES (2, 'question2');
--INSERT INTO question(question_id, question_text) VALUES (3, 'question3');
--
--
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'q1answer1', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'q1answer2', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'q1answer3', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (1, 'q1answer4', true);
--
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'q2answer1', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'q2answer2', true);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'q2answer3', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (2, 'q2answer4', false);
--
--
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'answer1', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'answer2', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'answer3', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'answer4', true);
--
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'q3answer1', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'q3answer2', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'q3answer3', false);
--INSERT INTO answer(answer_id, choice_list, correct_answer) VALUES (3, 'q3answer4', true);
