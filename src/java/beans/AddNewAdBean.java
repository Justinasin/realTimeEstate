/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.NewAdDao;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.NewAds;
import org.primefaces.showcase.view.input.SelectOneMenuView;
import javax.faces.event.ActionEvent;

/**
 *
 * @author pc
 */
@Named(value = "addNewAdBean")
@ViewScoped

public class AddNewAdBean implements Serializable{
    
    
    private int type_id;
    private int action_id;
    private int city_id;
    private String houseNumber;
    private String area;
    private String rooms;
    private String floors;
    private String buildingYear;
    private int heatingSystem_id;
    private String desc;
    private String price;
    private String phoneNumber;
    private String email;
    private int approved;
    private final NewAdDao newAdDao = new NewAdDao();
    
    
@Inject
private LoginBean loginBean;

    
    public AddNewAdBean() {
    }
    
  
    public void submitNewAd()
    {
        NewAds newAd = new NewAds();
        
        newAd.setType_id(type_id);
        newAd.setAction_id(action_id);
        newAd.setArea(area);
        newAd.setBuildingYear(buildingYear);
        newAd.setCity_id(city_id);
        newAd.setEmail(email);
        newAd.setFloors(getFloors());
        newAd.setHeatingSystem_id(heatingSystem_id);
        newAd.setHouseNumber(houseNumber);
        newAd.setPhoneNumber(phoneNumber);
        newAd.setPrice(price);
        newAd.setRooms(rooms);
        newAd.setDesc(desc);
        
        if (loginBean.getSelectedItemId() > 0) {
                //UsersDao.updateEvent(user);
            } else {
            try {
                newAdDao.insertNewAd(newAd, loginBean.getUsername());
            } catch (Exception ex) {
                Logger.getLogger(SelectOneMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        
        
    }

    /**
     * @return the type_id
     */
    public int getType_id() {
        return type_id;
    }

    /**
     * @param type_id the type_id to set
     */
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    /**
     * @return the action_id
     */
    public int getAction_id() {
        return action_id;
    }

    /**
     * @param action_id the action_id to set
     */
    public void setAction_id(int action_id) {
        this.action_id = action_id;
    }

    /**
     * @return the city_id
     */
    public int getCity_id() {
        return city_id;
    }

    /**
     * @param city_id the city_id to set
     */
    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    /**
     * @return the houseNumber
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the rooms
     */
    public String getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the floors
     */
    public String getFloors() {
        return floors;
    }

    /**
     * @param floors the floors to set
     */
    public void setFloors(String floors) {
        this.floors = floors;
    }

    /**
     * @return the buildingYear
     */
    public String getBuildingYear() {
        return buildingYear;
    }

    /**
     * @param buildingYear the buildingYear to set
     */
    public void setBuildingYear(String buildingYear) {
        this.buildingYear = buildingYear;
    }

    /**
     * @return the heatingSystem_id
     */
    public int getHeatingSystem_id() {
        return heatingSystem_id;
    }

    /**
     * @param heatingSystem_id the heatingSystem_id to set
     */
    public void setHeatingSystem_id(int heatingSystem_id) {
        this.heatingSystem_id = heatingSystem_id;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the approved
     */
    public int getApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(int approved) {
        this.approved = approved;
    }
 
    
}
