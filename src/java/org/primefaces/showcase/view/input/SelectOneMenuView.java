//package org.primefaces.showcase.view.input;
//
//import beans.SessionBean;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
//import javax.faces.application.NavigationHandler;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.context.FacesContext;
//import javax.faces.model.SelectItem;
//import javax.faces.model.SelectItemGroup;
//import javax.inject.Inject;
//
//@ManagedBean
//public class SelectOneMenuView implements Serializable {
//
//    private String action;
//    private String type;
//    private String city;
//    private String street;
//    private int houseNumber;
//    private int area;
//    private int rooms;
//    private int floors;
//    private Integer buildingYear;
//    private String heatingSystem;
//    private String desc;
//    private String text;
//    private Integer price;
//    private String phoneNumber;
//    private String email;
//
//    public SelectOneMenuView() {
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public int getNumber() {
//        return houseNumber;
//    }
//
//    public void setNumber(int houseNumber) {
//        this.houseNumber = houseNumber;
//    }
//
//    public int getArea() {
//        return area;
//    }
//
//    public void setArea(int area) {
//        this.area = area;
//    }
//
//    public Integer getBuildingYear() {
//        return buildingYear;
//    }
//
//    public void setBuildingYear(Integer buildingYear) {
//        this.buildingYear = buildingYear;
//    }
//
//    public String getHeatingSystem() {
//        return heatingSystem;
//    }
//
//    public void setHeatingSystem(String heatingSystem) {
//        this.heatingSystem = heatingSystem;
//    }
//
//    public String getDescription() {
//        return desc;
//    }
//
//    public void setDescription(String desc) {
//        this.desc = desc;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(int rooms) {
//        this.rooms = rooms;
//    }
//
//    public int getFloors() {
//        return floors;
//    }
//
//    public void setFloors(int floors) {
//        this.floors = floors;
//    }
//
//    public String getAction() {
//        return action;
//    }
//
//    public void setAction(String action) {
//        this.action = action;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//    
//    
//
//    public int getHouseNumber() {
//        return houseNumber;
//    }
//
//    public void setHouseNumber(int houseNumber) {
//        this.houseNumber = houseNumber;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//    
//    public void search() {        
//       
//        navigate("houses");
//    }
//    
//    public void navigate(String url) {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//
//        if (facesContext != null) {
//            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
//            navigationHandler.handleNavigation(facesContext, null, url + "?faces-redirect=true");
//        }
//    }
//
//}
