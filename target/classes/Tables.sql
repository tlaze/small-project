--When drop question table uses cascade route due to constraint violation on deletion
DROP TABLE if EXISTS question cascade;
DROP TABLE if EXISTS answer;

--table to store our question database
CREATE TABLE question (
    question_id int,
    question_text varchar(255),
    PRIMARY KEY (question_id)
    );

 --table to store our choices from our answer database
CREATE TABLE answer (
   answer_id int,
   choice_list varchar(255),
   correct_answer varchar(255),
   FOREIGN KEY (answer_id) REFERENCES question(question_id) ON DELETE CASCADE
    );

