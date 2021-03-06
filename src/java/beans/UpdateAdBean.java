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
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.NewAds;
import org.primefaces.showcase.view.input.SelectOneMenuView;
import javax.faces.event.ActionEvent;
import models.AllAds;
import models.UpdateAds;


@Named(value = "updateAdBean")
@SessionScoped

public class UpdateAdBean implements Serializable{
    
    
    private int adv_id;
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
    private final NewAdDao updateAdDao = new NewAdDao();
    private AllAds selectedAd = new AllAds();
    
    public UpdateAdBean() {
    }
    
  
    public void submitNewAd()
    {
        UpdateAds updateAd = new UpdateAds();
        
        int id = selectedAd.getAdv_id();
        updateAd.setType_id(type_id);
        updateAd.setAction_id(action_id);
        updateAd.setArea(area);
        updateAd.setBuildingYear(buildingYear);
        updateAd.setCity_id(city_id);
        updateAd.setEmail(email);
        updateAd.setFloors(getFloors());
        updateAd.setHeatingSystem_id(heatingSystem_id);
        updateAd.setHouseNumber(houseNumber);
        updateAd.setPhoneNumber(phoneNumber);
        updateAd.setPrice(price);
        updateAd.setRooms(rooms);
        updateAd.setDesc(desc);
        
        
            try {
                updateAdDao.updateAd(updateAd, id);
            } catch (Exception ex) {
                Logger.getLogger(SelectOneMenuView.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * @return the adv_id
     */
    public int getAdv_id() {
        return adv_id;
    }

    /**
     * @param adv_id the adv_id to set
     */
    public void setAdv_id(int adv_id) {
        this.adv_id = adv_id;
    }
    
    
    
    public void updateAd()
    {
        
    }

    /**
     * @return the selectedAd
     */
    public AllAds getSelectedAd() {
        return selectedAd;
    }

    /**
     * @param selectedAd the selectedAd to set
     */
    public void setSelectedAd(AllAds selectedAd) {
        this.selectedAd = selectedAd;
    }

    /**
     * @return the allAds
     */
    
   
 
    
}
