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
                        rs.getString("question_text")
                );
                questions.add(question);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return questions;
    }
    public Question getQuestionByID(int question){
        Connection connection = ConnectionSingleton.getConnection();

        try{
            String sql = "SELECT * FROM question WHERE question_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, question);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Question questionByID = new Question(
                        rs.getInt("question_id"),
                        rs.getString("question_text")
                );
                return questionByID;
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Question updateQuestionByID(int questionID, Question question){
        Connection connection = ConnectionSingleton.getConnection();

        try{
            String sql = "UPDATE question SET question_text = ? WHERE question_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, question.getQuestion_text());
            ps.setInt(2, questionID);
            ps.executeUpdate();

            return getQuestionByID(questionID);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Question deleteQuestionByID(int question_id){

        Connection connection = ConnectionSingleton.getConnection();
        try{
            String sql = "DELETE FROM question WHERE question_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,question_id);
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
