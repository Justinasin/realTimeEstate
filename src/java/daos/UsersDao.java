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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Message;
import models.Users;
import beans.RegistrationBean;
import java.util.ArrayList;
import models.Credentials;

/**
 *
 * @author pc
 */
public class UsersDao extends ConnectionDao {

    public int user_id;

    public void insertUser(Users user) throws SQLException, Exception {
        Connection connection = getConnection();
        boolean c = true;
        String sql = "INSERT INTO USERS ( USER_ID, FIRSTNAME,"
                + " LASTNAME,"
                + " EMAIL,"
                + " GENDER_ID)"
                + " VALUES ((SELECT MAX(USER_ID)+1 FROM USERS),?,?,?,?)";
        try {

            connection.setAutoCommit(false);
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getGender_id());
            ps.executeUpdate();

            sql = null;

            sql = "INSERT INTO CREDENTIALS (USER_ID, USERNAME,"
                    + " PASSWORD)"
                    + " VALUES ((SELECT MAX(USER_ID) FROM USERS),?,?)";

            ps = connection.prepareStatement(sql);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();

            sql = null;

            sql = "INSERT INTO PHONE_NUMBER (USER_ID,"
                    + "PHONE_NUMBER,"
                    + "PHONE_ID)"
                    + "VALUES ((SELECT MAX(USER_ID) FROM USERS),?,1)";

            ps = connection.prepareStatement(sql);

            ps.setString(1, user.getPhoneNumber1());
            ps.executeUpdate();

            sql = null;

            sql = "INSERT INTO PHONE_NUMBER (USER_ID,"
                    + "PHONE_NUMBER,"
                    + "PHONE_ID)"
                    + "VALUES ((SELECT MAX(USER_ID) FROM USERS),?,2)";

            ps = connection.prepareStatement(sql);

            ps.setString(1, user.getPhoneNumber2());
            ps.executeUpdate();

            sql = null;

            sql = "INSERT INTO ADDRESSES (USER_ID,"
                    + "ADDRESS,"
                    + "ADDRESS_ID)"
                    + "VALUES ((SELECT MAX(USER_ID) FROM USERS),?,1)";

            ps = connection.prepareStatement(sql);

            ps.setString(1, user.getAddress1());
            ps.executeUpdate();

            sql = null;

            sql = "INSERT INTO ADDRESSES (USER_ID,"
                    + "ADDRESS,"
                    + "ADDRESS_ID)"
                    + "VALUES ((SELECT MAX(USER_ID) FROM USERS),?,2)";

            ps = connection.prepareStatement(sql);

            ps.setString(1, user.getAddress2());
            ps.executeUpdate();

            ps.close();
            connection.commit();

        } catch (SQLException ex) {
            c = false;

        } finally {
            if (!c) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            connection.setAutoCommit(true);
        }
    }

    public Users getUser(String userName) throws SQLException, Exception {
        Users user = new Users();
        try {

            Connection connection = getConnection();
            String sql = "SELECT USER_ID FROM CREDENTIALS WHERE USERNAME = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user_id = rs.getInt("USER_ID");
            }

            rs = null;
            sql = null;
            sql = "SELECT * FROM USERS WHERE USER_ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setLastName(rs.getString("LASTNAME"));
                user.setEmail(rs.getString("EMAIL"));
            }

            //int genderID = rs.getInt("GENDER_ID");
            sql = null;
            rs = null;
            sql = "SELECT PHONE_NUMBER FROM PHONE_NUMBER WHERE USER_ID = ? AND PHONE_ID = 1";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);

            rs = ps.executeQuery();
            while (rs.next()) {
               user.setPhoneNumber1(rs.getString("PHONE_NUMBER"));
            }
            

            sql = null;
            rs = null;
            sql = "SELECT PHONE_NUMBER FROM PHONE_NUMBER WHERE USER_ID = ? AND PHONE_ID = 2";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);

            rs = ps.executeQuery();
            
            while (rs.next()) {
               user.setPhoneNumber2(rs.getString("PHONE_NUMBER"));
            }

            sql = null;
            rs = null;
            sql = "SELECT ADDRESS FROM ADDRESSES WHERE USER_ID = ? AND ADDRESS_ID = 1";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);

            rs = ps.executeQuery();
            while (rs.next()) {
               user.setAddress1(rs.getString("ADDRESS"));
            }
            

            sql = null;
            rs = null;
            sql = "SELECT ADDRESS FROM ADDRESSES WHERE USER_ID = ? AND ADDRESS_ID = 2";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);

            rs = ps.executeQuery();
            while (rs.next()) {
               user.setAddress2(rs.getString("ADDRESS"));
            }
            

            ps.close();

        } catch (SQLException ex) {

        }
        return user;
    }

    public void updateUser(Users user) throws Exception {
        boolean c = true;
        Connection connection = getConnection();
        try {

            connection.setAutoCommit(false);
            String sql = "UPDATE USERS SET FIRSTNAME = ?,"
                    + " LASTNAME = ?,"
                    + " EMAIL = ?"
                    + " WHERE USER_ID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user_id);

            ps.executeUpdate();

            sql = null;
            sql = "UPDATE PHONE_NUMBER SET PHONE_NUMBER = ? WHERE USER_ID = ? AND PHONE_ID = 1";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getPhoneNumber1());
            ps.setInt(2, user_id);

            ps.executeUpdate();

            sql = null;
            sql = "UPDATE PHONE_NUMBER SET PHONE_NUMBER = ? WHERE USER_ID = ? AND PHONE_ID = 2";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getPhoneNumber2());
            ps.setInt(2, user_id);

            ps.executeUpdate();

            sql = null;
            sql = "UPDATE ADDRESSES SET ADDRESS = ? WHERE USER_ID = ? AND ADDRESS_ID = 1";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getAddress1());
            ps.setInt(2, user_id);

            ps.executeUpdate();

            sql = null;
            sql = "UPDATE ADDRESSES SET ADDRESS = ? WHERE USER_ID = ? AND ADDRESS_ID = 2";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getAddress2());
            ps.setInt(2, user_id);

            ps.executeUpdate();

            ps.close();

            connection.commit();

        } catch (SQLException ex) {
            c = false;
        } finally {
            if (!c) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            connection.setAutoCommit(true);
        }
    }

//    public boolean validateUser(String username, String password) throws Exception {
//       
//        try {
//            Connection connection = getConnection();
//            String sql = "SELECT USERNAME, PASSWORD FROM CREDENTIALS WHERE USERNAME = ? AND PASSWORD =?";
//            PreparedStatement ps;
//            ps = connection.prepareStatement(sql);
//            ps.setString(1, username);
//            ps.setString(2, password);
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Login error -->" + ex.getMessage());
//            return false;
//        }
//        return false;
//    }
    
    
    public String fetchUser(int advert_id) throws Exception
    {
        String ownersName = null;
        int owners_id = 0;
        Connection connection = getConnection();
        String sql = "SELECT USER_ID FROM ADS WHERE AD_ID = ?";
        
        PreparedStatement ps;
        ps = connection.prepareStatement(sql);
        ps.setInt(1, advert_id);
        
        ResultSet rs;
        
        rs = ps.executeQuery();
        
        while(rs.next())
        {
            owners_id = rs.getInt("USER_ID");
        }
        
        sql = null;
        ps = null;
        rs = null;
        sql = "SELECT USERNAME FROM CREDENTIALS WHERE USER_ID = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, owners_id);
        
        rs = ps.executeQuery();
        
        while (rs.next())
        {
            ownersName = rs.getString("USERNAME");
        }
        return ownersName;
    }
    
    public ArrayList<Credentials> validateUser(String userName, String password) throws Exception
    {
        ArrayList<Credentials> credentialsList = new ArrayList<Credentials>();
        Connection connection = getConnection();
        String sql = "SELECT * FROM CREDENTIALS WHERE USERNAME = ? AND PASSWORD = ?";
        PreparedStatement ps;
        ps = connection.prepareStatement(sql);
        
        ps.setString(1, userName);
        ps.setString(2, password);
        
        ResultSet rs;
        rs = ps.executeQuery();
        
        while(rs.next())
        {
            credentialsList.add(populateCredentials(rs));
        }
        return credentialsList;
    }
    
    public Credentials populateCredentials(ResultSet rs) throws SQLException
    {
        Credentials credentials = new Credentials();
        credentials.setUserName(rs.getString("USERNAME"));
        credentials.setPassword(rs.getString("PASSWORD"));
        
        return credentials;
        
    }
}
