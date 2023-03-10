package DAO;
import Model.Answer;
import java.sql.*;
import Util.ConnectionSingleton;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO {

    public List<Answer> getAllAnswers(){
        Connection conn = ConnectionSingleton.getConnection();
        List<Answer> answers = new ArrayList<>();

        try{
            String sql = "SELECT * FROM answer";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Answer answer = new Answer(
                        rs.getInt("answer_id"),
                        rs.getString("choice_list"),
                        rs.getInt("correct_answer")
                );
                answers.add(answer);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return answers;
    }

}
