package org.primefaces.showcase.view.input;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
 
 
@ManagedBean
public class SelectOneMenuView {
     
    private String type;
    private String city;
    private int houseNumber;
    private int area;
    private int rooms;
    private int floors;
    private Integer buildingYear;
    private String heatingSystem;
    private String desc;
    private Integer price;
    private Integer phoneNumber;
    private String email;
    
     
    @PostConstruct
    public void init() {
       
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
    
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
    
    public int getNumber() {
        return houseNumber;
    }
 
    public void setNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    
    public int getArea() {
        return area;
    }
 
    public void setArea(int area) {
        this.area = area;
    }
    
    public Integer getBuildingYear() {
        return buildingYear;
    }
 
    public void setBuildingYear(Integer buildingYear) {
        this.buildingYear = buildingYear;
    }
    
    public String getHeatingSystem() {
        return heatingSystem;
    }
 
    public void setHeatingSystem(String heatingSystem) {
        this.heatingSystem = heatingSystem;
    }
    
    public String getDescription() {
        return desc;
    }
 
    public void setDescription(String desc) {
        this.desc = desc;
    }
    
    public Integer getPrice() {
        return price;
    }
 
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
    
    
    
    
    public int getRooms() {
        return rooms;
    }
 
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    
    
    public int getFloors() {
        return floors;
    }
 
    public void setFloors(int floors) {
        this.floors = floors;
    }
 
}