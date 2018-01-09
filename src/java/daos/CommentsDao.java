/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.AllAds;
import models.Comments;

/**
 *
 * @author pc
 */
public class CommentsDao extends ConnectionDao {
    
    public void insertComment(String userName, Comments comment, int id) throws Exception{
        
        
        Connection connection = getConnection();
        
        
        String sql = "INSERT INTO COMMENTS (USERNAME,"
                + " COMMENT_TEXT,"
                + " AD_ID)"
                + " VALUES (?,?,?)";
        
        PreparedStatement ps;
        ps = connection.prepareStatement(sql);
        ps.setString(1, userName);      
        ps.setString(2, comment.getCommentText());
        ps.setInt(3, id);
        
        ps.executeUpdate();
        
        ps.close();
    }
    
    public ArrayList<Comments> selectComments(int id) throws SQLException, Exception
    {
        ArrayList<Comments> comments = new ArrayList<Comments>();
        Connection connection = getConnection();
        
        String sql = "SELECT * FROM COMMENTS WHERE AD_ID = ?";
        PreparedStatement ps;
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs;
        rs = ps.executeQuery();
        
        while(rs.next())
        {
            comments.add(populateComments(rs));
        }
        
        return comments;
        
    }
    
    public Comments populateComments(ResultSet rs) throws SQLException
    {
        Comments comment = new Comments();
        comment.setCommentText(rs.getString("COMMENT_TEXT"));
        comment.setCommenterName(rs.getString("USERNAME"));
        
        return comment;
    }
    
    
}
