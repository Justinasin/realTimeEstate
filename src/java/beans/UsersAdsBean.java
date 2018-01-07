/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.AdsDao;
import daos.UsersDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.AllAds;

/**
 *
 * @author pc
 */
@Named(value = "usersAdsBean")
@ViewScoped
public class UsersAdsBean implements Serializable{
    
    private ArrayList<AllAds> usersAdsList = new ArrayList<AllAds>();
    private final AdsDao adsDao = new AdsDao();

@Inject
private LoginBean loginBean;
    /**
     * Creates a new instance of UsersAdsBean
     */
    public UsersAdsBean() {
    }
    
    public ArrayList<AllAds> fetchUsersAds() throws Exception
    {
        String userName = loginBean.getUsername();
        return usersAdsList = adsDao.fetchUsersAds(userName);
    }
    

    /**
     * @return the allAdsList
     */
    public ArrayList<AllAds> getusersAdsList() {
        return usersAdsList;
    }

    /**
     * @param allAdsList the allAdsList to set
     */
    public void setusersAdsList(ArrayList<AllAds> usersAdsList) {
        this.usersAdsList = usersAdsList;
    }
}
