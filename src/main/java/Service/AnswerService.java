package Service;
import java.util.List;
import DAO.AnswerDAO;
import Model.Answer;
public class AnswerService {
    public AnswerDAO answerDAO;
    public AnswerService(){
        answerDAO = new AnswerDAO();
    }
    public AnswerService(AnswerDAO answerDAO){
        this.answerDAO = answerDAO;
    }
    public List<Answer> getAllAnswers(){
        return answerDAO.getAllAnswers();
    }
    public List<Answer> getAnswersByID(int answers){
        return answerDAO.getAnswersByID(answers);
    }
    public Answer updateAnswerByID(int answerID, Answer answer){
        if(answer.choice_list != "" && answer.choice_list.length() <= 255 && answer.correct_answer != "" && answer.correct_answer.length() <= 255){

            return answerDAO.updateAnswerByID(answerID, answer);
        }
        else{
            return null;
        }
    }
    public Answer addAnswer(Answer answer){

        if(answer.choice_list.isBlank() || answer.correct_answer.isBlank()){
            System.out.println("Text can't be blank");
            return null;
        }
        else if(answer.choice_list.length() >= 255 || answer.correct_answer.length() >= 255){
            System.out.println("Text can't be over 255 characters");
        }
        return answerDAO.createAnswer(answer);
    }
}
