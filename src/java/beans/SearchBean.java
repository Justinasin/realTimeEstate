//package beans;
//
//import javax.inject.Named;
//import java.io.Serializable;
//import javax.faces.application.FacesMessage;
//import javax.faces.application.NavigationHandler;
//import javax.faces.bean.ManagedBean;
//import javax.inject.Named;
//import javax.faces.context.FacesContext;
//import javax.faces.view.ViewScoped;
//
//@Named(value = "searchBean")
//@ManagedBean
//@ViewScoped
//public class SearchBean implements Serializable {
//
//    private String action;
//    private String type;
//    private String city;
//    private int houseNumber;
//    private int area;
//    private int rooms;
//    private int floors;
//    private Integer buildingYear;
//    private String heatingSystem;
//    private String desc;
//    private Integer price;
//    private String phoneNumber;
//    private String email;
//
//    public SearchBean() {
//    }
//
//    public void search() {
//        FacesMessage msg = new FacesMessage("Successful", "Thank you, " + getArea()+ " for submitting information");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
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
//    /**
//     * @return the action
//     */
//    public String getAction() {
//        return action;
//    }
//
//    /**
//     * @param action the action to set
//     */
//    public void setAction(String action) {
//        this.action = action;
//    }
//
//    /**
//     * @return the type
//     */
//    public String getType() {
//        return type;
//    }
//
//    /**
//     * @param type the type to set
//     */
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    /**
//     * @return the city
//     */
//    public String getCity() {
//        return city;
//    }
//
//    /**
//     * @param city the city to set
//     */
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    /**
//     * @return the houseNumber
//     */
//    public int getHouseNumber() {
//        return houseNumber;
//    }
//
//    /**
//     * @param houseNumber the houseNumber to set
//     */
//    public void setHouseNumber(int houseNumber) {
//        this.houseNumber = houseNumber;
//    }
//
//    /**
//     * @return the area
//     */
//    public int getArea() {
//        return area;
//    }
//
//    /**
//     * @param area the area to set
//     */
//    public void setArea(int area) {
//        this.area = area;
//    }
//
//    /**
//     * @return the rooms
//     */
//    public int getRooms() {
//        return rooms;
//    }
//
//    /**
//     * @param rooms the rooms to set
//     */
//    public void setRooms(int rooms) {
//        this.rooms = rooms;
//    }
//
//    /**
//     * @return the floors
//     */
//    public int getFloors() {
//        return floors;
//    }
//
//    /**
//     * @param floors the floors to set
//     */
//    public void setFloors(int floors) {
//        this.floors = floors;
//    }
//
//    /**
//     * @return the buildingYear
//     */
//    public Integer getBuildingYear() {
//        return buildingYear;
//    }
//
//    /**
//     * @param buildingYear the buildingYear to set
//     */
//    public void setBuildingYear(Integer buildingYear) {
//        this.buildingYear = buildingYear;
//    }
//
//    /**
//     * @return the heatingSystem
//     */
//    public String getHeatingSystem() {
//        return heatingSystem;
//    }
//
//    /**
//     * @param heatingSystem the heatingSystem to set
//     */
//    public void setHeatingSystem(String heatingSystem) {
//        this.heatingSystem = heatingSystem;
//    }
//
//    /**
//     * @return the desc
//     */
//    public String getDesc() {
//        return desc;
//    }
//
//    /**
//     * @param desc the desc to set
//     */
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    /**
//     * @return the price
//     */
//    public Integer getPrice() {
//        return price;
//    }
//
//    /**
//     * @param price the price to set
//     */
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    /**
//     * @return the phoneNumber
//     */
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    /**
//     * @param phoneNumber the phoneNumber to set
//     */
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    /**
//     * @return the email
//     */
//    public String getEmail() {
//        return email;
//    }
//
//    /**
//     * @param email the email to set
//     */
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//}
