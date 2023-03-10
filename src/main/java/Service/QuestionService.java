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
}
