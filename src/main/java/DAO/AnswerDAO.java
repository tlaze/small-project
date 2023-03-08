package DAO;
import Model.Answer;
import Util.ConnectionUtil;
import java.sql.*;

public class AnswerDAO {

    public Answer getAnswer_id(int answer_id){
        Connection con = ConnectionUtil.getConnection();

        try{
            String sql = "";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, answer_id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Answer getAnswer_id = new Answer(
                        rs.getInt("answer_id")
                );
                return getAnswer_id;
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
