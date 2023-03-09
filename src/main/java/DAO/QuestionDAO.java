package DAO;
import Model.Question;
import java.sql.*;
import Util.ConnectionSingleton;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    public List<Question> getAllQuestions(){

        Connection conn = ConnectionSingleton.getConnection();
        List<Question> questions = new ArrayList<>();

        try{
            String sql = "SELECT * FROM question";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Question question = new Question(
                        rs.getInt("question_id"),
                        rs.getString("question_text"),
                        rs.getInt("answer_id")
                );
                questions.add(question);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return questions;
    }
}
