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
    private int rooms;
    private int floors;
     
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