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
import models.NewAds;

/**
 *
 * @author pc
 */
public class NewAdDao extends ConnectionDao {
    
    public void insertNewAd(NewAds newAd, String userName) throws Exception
    {
        int user_id = 0;
        Connection conn = getConnection();
        boolean c = true;
        
        String sql = "SELECT USER_ID FROM CREDENTIALS WHERE USERNAME = ?";
            PreparedStatement ps;
            
        
        

        try {
            
            conn.setAutoCommit(false);
            
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user_id = rs.getInt("USER_ID");
            }
            
            
            sql = "INSERT INTO ADS (AD_ID,USER_ID, ACTION_ID,"
                + "CITY_ID,"
                + "PROPERTY_NUMBER,"
                + "AREA,"
                + "NUMBER_OF_ROOMS,"
                + "BUILDING_YEAR,"
                + "HEATING_SYSTEM_ID,"
                + "DISCRIPTION,"
                + "PHONE_NUMBER,"
                + "EMAIL,"
                + "TYPE_ID,"
                + "PRICE)"
                + "VALUES ((SELECT MAX(AD_ID) FROM ADS)+1,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            
            
            
            
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setInt(2, newAd.getAction_id());
            ps.setInt(3, newAd.getCity_id());
            ps.setString(4, newAd.getHouseNumber());
            ps.setString(5, newAd.getArea());
            ps.setString(6, newAd.getRooms());
            ps.setString(7, newAd.getBuildingYear());
            ps.setInt(8, newAd.getHeatingSystem_id());
            ps.setString(9, newAd.getDesc());
            ps.setString(10, newAd.getPhoneNumber());
            ps.setString(11, newAd.getEmail());
            ps.setInt(12, newAd.getType_id());
            ps.setString(13, newAd.getPrice());
            
            ps.executeUpdate();
            ps.close();
            conn.commit();
            
        } catch (SQLException ex){
            c = false;
        }finally{
            if(!c){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.setAutoCommit(true);
            }
        } 
    }
    
     public void updateAd(NewAds newAd, String userName) throws Exception
    {
        
    }
}
