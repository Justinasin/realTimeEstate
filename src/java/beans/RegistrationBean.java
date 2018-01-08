package beans;

import daos.EventsDao;
import daos.UsersDao;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Credentials;
import models.Event;
import models.Users;


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
    private int gender_id;
    private String email;
    private final UsersDao usersDao = new UsersDao();
            
@Inject
private LoginBean loginBean;
@PostConstruct
    public void init(){                
        try {

            int selected = loginBean.getSelectedItemId();
            String userName = loginBean.getUsername();

            Users user = usersDao.getUser(userName);

            firstname = user.getFirstName();
            lastname = user.getLastName();
            phone1 = user.getPhoneNumber1();
            phone2 = user.getPhoneNumber2();
            address1 = user.getAddress1();
            address2 = user.getAddress2();
            email = user.getEmail();
            username = userName;
            password = loginBean.getPassword();
            
            
        } catch (Exception ex) {
            Logger.getLogger(AddEditEventBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    public RegistrationBean() {
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
    
    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public void saveEvent() {
        try {
            Users user = new Users();
            
            user.setFirstName(firstname);
            user.setLastName(lastname);
            //user.getUserId();
            user.setGender_id(gender_id);
            user.setAddress1(address1);
            user.setAddress2(address2);
            user.setUserName(username);
            user.setPassword(password);
            user.setPhoneNumber1(phone1);
            user.setPhoneNumber2(phone2);
            
            if (loginBean.getUsername()!= null) {
                usersDao.updateUser(user);
            } else {
                usersDao.insertUser(user);
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditEventBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        //sessionBean.navigate("manage_events");
    }
    
    
//    public void updateUser()
//    {
//        try
//        {
//            String userName = loginBean.getUsername();
//
//            Users user = usersDao.getUser(userName);
//
//            firstname = user.getFirstName();
//            lastname = user.getLastName();
//            phone1 = user.getPhoneNumber1();
//            phone2 = user.getPhoneNumber2();
//            address1 = user.getAddress1();
//            address2 = user.getAddress2();
//            email = user.getEmail();
//            username = userName;
//            password = loginBean.getPassword();
//        }catch (Exception ex) {
//            Logger.getLogger(AddEditEventBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
    //}
    
}
