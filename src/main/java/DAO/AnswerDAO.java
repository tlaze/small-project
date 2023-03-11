package DAO;
import Model.Answer;
import java.sql.*;

import Model.Question;
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
                        rs.getString("correct_answer")
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
                        rs.getString("correct_answer")
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
    public Answer updateAnswerByID(int answerID, Answer answer){
        Connection connection = ConnectionSingleton.getConnection();

        try{
            String sql = "UPDATE answer SET choice_list = ? WHERE answer_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, answer.getChoice_list());
            ps.setInt(2, answerID);
            ps.executeUpdate();

            return getUpdatedAnswerByID(answerID);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Answer getUpdatedAnswerByID(int answers){
        Connection connection = ConnectionSingleton.getConnection();

        try{
            String sql = "SELECT * FROM answer WHERE answer_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, answers);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Answer answerByID = new Answer(
                        rs.getInt("answer_id"),
                        rs.getString("choice_list"),
                        rs.getString("correct_answer")
                );
                return answerByID;
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Answer createAnswer(Answer answer){
        Connection connection = ConnectionSingleton.getConnection();
        try{
            String sql = "Insert INTO answer (answer_id, choice_list, correct_answer) VALUES (?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, answer.getAnswer_id());
            ps.setString(2, answer.getChoice_list());
            ps.setString(3, answer.getCorrect_answer());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int answerID = rs.getInt(1);
                return new Answer(answerID, answer.getChoice_list(), answer.getCorrect_answer());
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
