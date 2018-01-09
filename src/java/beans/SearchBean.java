package beans;

import daos.AdsDao;
import daos.UsersDao;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import models.SearchClass;
import models.AllAds;

@Named(value = "searchBean")
@ManagedBean
@ViewScoped
public class SearchBean implements Serializable {

    
    private int action;
    private int type;
    private int city;
    private ArrayList<AllAds> allAds = new ArrayList<AllAds>();
    private final AdsDao adsDao = new AdsDao();
    private AllAds selectedObject = new AllAds();
    private final UsersDao usersDao = new UsersDao();

    
            
    public SearchBean() {
    }
    
    
    
    public ArrayList<AllAds> search() throws Exception
    {
        
        SearchClass searchClass = new SearchClass();
        searchClass.setAction_id(action);
        searchClass.setCity_id(city);
        searchClass.setType_id(type);
        

        return allAds = adsDao.searchDao(searchClass);
        
    }
    
    public String fetchUser() throws Exception
    {
        String ownerName = null;
        int id = selectedObject.getAdv_id();
        return ownerName = usersDao.fetchUser(id);
    }
    
    
    

    /**
     * @return the action
     */
    public int getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(int action) {
        this.action = action;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the city
     */
    public int getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(int city) {
        this.city = city;
    }

    /**
     * @return the selectedObject
     */
    public AllAds getSelectedObject() {
        return selectedObject;
    }

    /**
     * @param selectedObject the selectedObject to set
     */
    public void setSelectedObject(AllAds selectedObject) {
        this.selectedObject = selectedObject;
    }
    

    



}