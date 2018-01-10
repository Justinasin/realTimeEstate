package beans;

import daos.UsersDao;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.Credentials;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private Connection connection;
    private int selectedItemId;
    private int menuIndex = 3;
    ArrayList<Credentials> credentialsList = new ArrayList<Credentials>();

    
    public LoginBean() {
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

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(int selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

    public void login() throws Exception {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UsersDao usersDao = new UsersDao();
        boolean success = false;
        credentialsList.clear();
        credentialsList = usersDao.validateUser(username, password);
        
        for(Credentials c: credentialsList)
        {
            if (username.equals(c.getUserName()) && password.equals(c.getPassword())) {
                success = true;
           }
            else
            {
                success = false;
            }
        }

        try {

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {

        }

        if (success) {
            navigate("/houses/houses");
            
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
            //navigate("/houses/loginPage");
        }
    }

    public void logout() throws Exception {
        try {
            // Release and close database resources and connections 
            if (connection != null) {
                if (!connection.getAutoCommit()) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }

                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            setPassword(null);
            setUsername(null);

            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().invalidateSession();
        }
    }

    public void navigate(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (facesContext != null) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, url + "?faces-redirect=true");
        }
    }
}
