
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.AllAds;
import models.AllAdsIDs;
import models.SearchClass;

/**
 *
 * @author pc
 */
public class AdsDao extends ConnectionDao {
    private ArrayList<AllAds> allAdsList = new ArrayList<AllAds>();
    private ArrayList<AllAds> usersAds = new ArrayList<AllAds>();
    
    public ArrayList<AllAds> getAllAds() throws Exception
    {
        AllAds allAds = new AllAds();
        Connection connection = getConnection();
        String sql = "SELECT * FROM ADS";                        
            PreparedStatement ps = connection.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                allAds = prepareAdsObject(rs);
                allAdsList.add(allAds);
            }
            
            rs.close();
            ps.close();
            
            return allAdsList;  
        
    }
    
    public AllAds prepareAdsObject(ResultSet rs) throws Exception
    {
        
        AllAdsIDs allAdsIDs = new AllAdsIDs();
        AllAds allAds = new AllAds();
        
        allAdsIDs.setAdv_id(rs.getInt("AD_ID"));
        allAdsIDs.setAction_id(rs.getInt("ACTION_ID"));
        allAdsIDs.setType_id(rs.getInt("TYPE_ID"));
        allAdsIDs.setCity_id(rs.getInt("CITY_ID"));
        allAdsIDs.setHeatingSystem_id(rs.getInt("HEATING_SYSTEM_ID"));
        allAdsIDs.setArea(rs.getString("AREA"));
        allAdsIDs.setBuildingYear(rs.getString("BUILDING_YEAR"));
        allAdsIDs.setDesc(rs.getString("DISCRIPTION"));
        allAdsIDs.setEmail(rs.getString("EMAIL"));
        
        allAdsIDs.setHouseNumber(rs.getString("PROPERTY_NUMBER"));
        allAdsIDs.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        allAdsIDs.setPrice(rs.getString("PRICE"));
        allAdsIDs.setRooms(rs.getString("NUMBER_OF_ROOMS"));
        
        Connection connection = getConnection();
        
        
        rs = null;
        String sql = "SELECT ACTION_TYPE FROM ACTION WHERE ACTION_ID =?";
        
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, allAdsIDs.getAction_id());
        
        rs = ps.executeQuery();
        while (rs.next()) {
                allAds.setAction(rs.getString("ACTION_TYPE"));
            }
        
        
        
        rs = null;
        sql = null;
        ps = null;
        sql = "SELECT ACTION_TYPE FROM TYPE WHERE TYPE_ID =?";
        ps = connection.prepareStatement(sql);
       
        ps.setInt(1, allAdsIDs.getType_id());
        
        rs = ps.executeQuery();
        while (rs.next()) {
                allAds.setType(rs.getString("ACTION_TYPE"));
            }
        
        
        rs = null;
        sql = null;
        ps = null;
        sql = "SELECT CITY_NAME FROM CITY WHERE CITY_ID = ?";
        
        ps = connection.prepareStatement(sql);
       
        ps.setInt(1, allAdsIDs.getCity_id());
        
        rs = ps.executeQuery();
        while (rs.next()) {
                allAds.setCity(rs.getString("CITY_NAME"));
            }
        
        
        
        rs = null;
        sql = null;
        ps = null;
        sql = "SELECT (HEATING_SYSTEM_TYPE) FROM (HEATING_SYSTEM) WHERE (HEATING_SYSTEM_ID) =?";
        ps = connection.prepareStatement(sql);
       
        ps.setInt(1, allAdsIDs.getHeatingSystem_id());
        
        rs = ps.executeQuery();
        while(rs.next())
        {
            allAds.setHeatingSystem(rs.getString("HEATING_SYSTEM_TYPE"));
        }

        allAds.setAdv_id(allAdsIDs.getAdv_id());
        allAds.setBuildingYear(allAdsIDs.getBuildingYear());
        allAds.setDesc(allAdsIDs.getDesc());
        allAds.setEmail(allAdsIDs.getEmail());
        allAds.setHouseNumber(allAdsIDs.getHouseNumber());
        allAds.setPhoneNumber(allAdsIDs.getPhoneNumber());
        allAds.setPrice(allAdsIDs.getPrice());
        allAds.setRooms(allAdsIDs.getRooms());
        allAds.setArea(allAdsIDs.getArea());
        

        return allAds;
        
    }
    
    
    
    public ArrayList<AllAds> fetchUsersAds(String userName) throws Exception
    {
        AllAds usersAd = new AllAds();
        int user_id = 0;
        Connection connection = getConnection();
            String sql = "SELECT USER_ID FROM CREDENTIALS WHERE USERNAME = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user_id = rs.getInt("USER_ID");
            }
        
            sql = null;
            rs = null;
            ps = null;
        sql = "SELECT * FROM ADS WHERE USER_ID =?";                        
            ps = connection.prepareStatement(sql);   
            ps.setInt(1, user_id);

            rs = ps.executeQuery();           

            while (rs.next()) {
                
                usersAd = prepareAdsObject(rs);
                usersAds.add(usersAd);
            }
            
            rs.close();
            ps.close();
            
            
            return usersAds;
  
    }
    
    
    public ArrayList<AllAds> searchDao(SearchClass searchClass) throws Exception
    {
        ArrayList<AllAds> allAds = new ArrayList<AllAds>();
        
        Connection connection = getConnection();
        
        if (searchClass.getAction_id() != 0 && searchClass.getCity_id() != 0 && searchClass.getType_id() != 0) {
            String sql = "SELECT * FROM ADS WHERE ACTION_ID = ? AND CITY_ID = ? AND TYPE_ID = ?";
        
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, searchClass.getAction_id());
            ps.setInt(2, searchClass.getCity_id());
            ps.setInt(3, searchClass.getType_id());

            ResultSet rs ;
            rs = ps.executeQuery();

            while(rs.next())
            {
                allAds.add(prepareAdsObject(rs));
            }
        }
        else if(searchClass.getAction_id() == 0 && searchClass.getCity_id() != 0 && searchClass.getType_id() != 0){
                String sql = "SELECT * FROM ADS WHERE CITY_ID = ? AND TYPE_ID = ?";
        
                PreparedStatement ps;
                ps = connection.prepareStatement(sql);
                ps.setInt(1, searchClass.getCity_id());
                ps.setInt(2, searchClass.getType_id());

                ResultSet rs ;
                rs = ps.executeQuery();

                while(rs.next())
                {
                    allAds.add(prepareAdsObject(rs));
                }
            
        }
        else if (searchClass.getAction_id() != 0 && searchClass.getCity_id() == 0 && searchClass.getType_id() != 0) {
             String sql = "SELECT * FROM ADS WHERE ACTION_ID = ? AND TYPE_ID = ?";
        
                PreparedStatement ps;
                ps = connection.prepareStatement(sql);
                ps.setInt(1, searchClass.getAction_id());
                ps.setInt(2, searchClass.getType_id());

                ResultSet rs ;
                rs = ps.executeQuery();

                while(rs.next())
                {
                    allAds.add(prepareAdsObject(rs));
                }
        }
        else if(searchClass.getAction_id() != 0 && searchClass.getCity_id() != 0 && searchClass.getType_id() == 0){
            String sql = "SELECT * FROM ADS WHERE ACTION_ID = ? AND CITY_ID = ?";
        
                PreparedStatement ps;
                ps = connection.prepareStatement(sql);
                ps.setInt(1, searchClass.getAction_id());
                ps.setInt(2, searchClass.getCity_id());

                ResultSet rs ;
                rs = ps.executeQuery();

                while(rs.next())
                {
                    allAds.add(prepareAdsObject(rs));
                }
        }
        else if(searchClass.getAction_id() == 0 && searchClass.getCity_id() == 0 && searchClass.getType_id() != 0){
            String sql = "SELECT * FROM ADS WHERE TYPE_ID = ?";
        
                PreparedStatement ps;
                ps = connection.prepareStatement(sql);
                ps.setInt(1, searchClass.getType_id());

                ResultSet rs ;
                rs = ps.executeQuery();

                while(rs.next())
                {
                    allAds.add(prepareAdsObject(rs));
                }
        }
        else if(searchClass.getAction_id() == 0 && searchClass.getCity_id() != 0 && searchClass.getType_id() == 0){
            String sql = "SELECT * FROM ADS WHERE CITY_ID = ?";
        
                PreparedStatement ps;
                ps = connection.prepareStatement(sql);
                ps.setInt(1, searchClass.getCity_id());

                ResultSet rs ;
                rs = ps.executeQuery();

                while(rs.next())
                {
                    allAds.add(prepareAdsObject(rs));
                }
        }
        else if(searchClass.getAction_id() != 0 && searchClass.getCity_id() == 0 && searchClass.getType_id() == 0){
            String sql = "SELECT * FROM ADS WHERE ACTION_ID = ?";
        
                PreparedStatement ps;
                ps = connection.prepareStatement(sql);
                ps.setInt(1, searchClass.getAction_id());

                ResultSet rs ;
                rs = ps.executeQuery();

                while(rs.next())
                {
                    allAds.add(prepareAdsObject(rs));
                }
        }
        if (searchClass.getAction_id() == 0 && searchClass.getCity_id() == 0 && searchClass.getType_id() == 0) {
            String sql = "SELECT * FROM ADS ";
        
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
//            ps.setInt(1, searchClass.getAction_id());
//            ps.setInt(2, searchClass.getCity_id());
//            ps.setInt(3, searchClass.getType_id());

            ResultSet rs ;
            rs = ps.executeQuery();

            while(rs.next())
            {
                allAds.add(prepareAdsObject(rs));
            }
        }
        
        
        
        return allAds;
    }
    
    public void deleteAd(int id) throws Exception
    {
        Connection connection = getConnection();
        PreparedStatement ps;
        String sql = "DELETE FROM COMMENTS WHERE AD_ID = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        
        ps.executeUpdate();
        sql = null;
        ps = null;
        sql = "DELETE FROM ADS WHERE AD_ID = ?";

        ps = connection.prepareStatement(sql);
        
        ps.setInt(1, id);
        
        ps.executeUpdate();
        
        ps.close();
    }
    
}
