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
}
