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
                        rs.getBoolean("correct_answer")
                );
                answers.add(answer);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return answers;
    }
    public List<Answer> getAnswersByID(int answers){
        Connection connection = ConnectionSingleton.getConnection();

        try{
            String sql = "SELECT * FROM answer WHERE answer_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, answers);

            ResultSet rs = ps.executeQuery();

            List<Answer> allAnswers = new ArrayList<>();
            while(rs.next()){
                Answer answersByID = new Answer(
                        rs.getInt("answer_id"),
                        rs.getString("choice_list"),
                        rs.getBoolean("correct_answer")
                );
                allAnswers.add(answersByID);
            }
            return allAnswers;

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
