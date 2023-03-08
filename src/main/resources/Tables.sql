--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
DROP TABLE if EXISTS questions;
DROP TABLE if EXISTS choices;

--table to store our questions
CREATE TABLE questions (question_id int PRIMARY KEY,
    question_text VARCHAR(255),
    choice_id int,
    FOREIGN KEY(choice_id) REFERENCES choices(choice_id),
    );

-- table to store our choices from our questions pool
CREATE TABLE choices (choice_id int PRIMARY KEY ,
    choice_list VARCHAR (255),
    is_correct BIT,
    answer_text VARCHAR(255),
    question_id

    --possible to add the answers table to the
    FOREIGN KEY(question_id) REFERENCES questions(question_id)
    );

-- get all questions
--  delete all questions if  answered
-- update certain questions

    -- add questions with choices and answers for those questions

-- do we need test cases?
