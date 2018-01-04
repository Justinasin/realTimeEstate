package beans;

import javax.inject.Named;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "registrationBean")
@ManagedBean
@ViewScoped
public class RegistrationBean implements Serializable {
    
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String address1;
    private String address2;
    private String phone1;
    private String phone2;
    private String gender;
    private String email;
    
    
    private String action;
    private String type;
    private String city;
    private Integer houseNumber;
    private Integer area;
    private int rooms;
    private int floors;
    private Integer buildingYear;
    private String heatingSystem;
    private String desc;
    private Integer price;
    private String phoneNumber;
    
            
    public RegistrationBean() {
    }
    
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Thank you, " + getFirstname() + " for submitting information");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        navigate("loginPage");
    }
    
    public void update() {        
       
        navigate("houses");
    }
    
    public void add() {        
       
        navigate("houses");
    }
    
    public void search_login() {        
       
        navigate("searchResult");
    }
    
    public void search_without_login() {        
       
        navigate("searchResult_without_login");
    }
    
    public void navigate(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (facesContext != null) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, url + "?faces-redirect=true");
        }
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    
    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    
    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the houseNumber
     */
    public Integer getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the area
     */
    public Integer getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * @return the rooms
     */
    public int getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the floors
     */
    public int getFloors() {
        return floors;
    }

    /**
     * @param floors the floors to set
     */
    public void setFloors(int floors) {
        this.floors = floors;
    }

    /**
     * @return the buildingYear
     */
    public Integer getBuildingYear() {
        return buildingYear;
    }

    /**
     * @param buildingYear the buildingYear to set
     */
    public void setBuildingYear(Integer buildingYear) {
        this.buildingYear = buildingYear;
    }

    /**
     * @return the heatingSystem
     */
    public String getHeatingSystem() {
        return heatingSystem;
    }

    /**
     * @param heatingSystem the heatingSystem to set
     */
    public void setHeatingSystem(String heatingSystem) {
        this.heatingSystem = heatingSystem;
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
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
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

    
}
