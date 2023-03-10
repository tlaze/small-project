package Service;
import java.util.List;
import DAO.QuestionDAO;
import Model.Question;

public class QuestionService {
    public QuestionDAO questionDAO;
    public QuestionService(){
        questionDAO = new QuestionDAO();
    }
    public QuestionService(QuestionDAO questionDAO){
        this.questionDAO = questionDAO;
    }
    public List<Question> getAllQuestions(){
        return questionDAO.getAllQuestions();
    }
    public Question getQuestionByID (int question_id) {
        return questionDAO.getQuestionByID(question_id);
    }
    public Question deleteQuestionID(int question_id) {
        Question deleteQuestion_ID = questionDAO.getQuestionByID(question_id);
        questionDAO.deleteQuestionByID(question_id);

        if (deleteQuestion_ID != null) {
            return deleteQuestion_ID;
        } else {
            return questionDAO.deleteQuestionByID(question_id);
        }
    }

    public Question updateQuestionByID(int question_id, Question question){
        if(question.question_text != "" && question.question_text.length() <= 255){

            return questionDAO.updateQuestionByID(question_id, question);
        }
        else{
            return null;
        }
    }

    //if we can get it to work.
//    public Question addQuestion(Question question){
//
//            if (question.question_text.isBlank()) {
//                System.out.println("The Question cannot be blank");
//                return null;
//
//            } else if (question.question_text.length() >= 255) {
//                System.out.println("question cannot be over 255 characters");
//                return null;
//
//            } else if (question.answer_id <= 1) {
//                System.out.println("must assign it to an answer ID");
//            }
//
//        return questionDAO.createQuestion(question);
//    }

//    //if we can get it to work.
//    public Question addQuestion(Question question){
//
//            if (question.question_text.isBlank()) {
//                System.out.println("The Question cannot be blank");
//                return null;
//
//            } else if (question.question_text.length() >= 255) {
//                System.out.println("question cannot be over 255 characters");
//                return null;
//
//            } else if (question.answer_id <= 1) {
//                System.out.println("must assign it to an answer ID");
//            }
//
//        return questionDAO.createQuestion(question);
//
//
//    }

}
