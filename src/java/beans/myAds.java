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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.AllAds;

/**
 *
 * @author pc
 */
@Named(value = "myAds")
@SessionScoped
public class myAds implements Serializable{
    
    private ArrayList<AllAds> allAdsList = new ArrayList<AllAds>();
    private ArrayList<AllAds> usersAdsList = new ArrayList<AllAds>();
    private AllAds selectedAd = new AllAds();
    private final AdsDao adsDao = new AdsDao();
    
    
    @Inject
private LoginBean loginBean;


    /**
     * Creates a new instance of myAds
     */
    public myAds() {
    }
    
    
    public ArrayList<AllAds> fetchAds() throws Exception
    {
        return allAdsList = adsDao.getAllAds();
    }
    
    public ArrayList<AllAds> fetchUsersAds() throws Exception
    {
        usersAdsList.clear();
        String userName = loginBean.getUsername();
        return usersAdsList = adsDao.fetchUsersAds(userName);
    }
    
    public ArrayList<AllAds> fetchAds(String cityName, String action_type, String type) throws Exception
    {
        return allAdsList = adsDao.getAllAds();
    }
    


    /**
     * @return the allAdsList
     */
    public ArrayList<AllAds> getAllAdsList() {
        return allAdsList;
    }

    /**
     * @param allAdsList the allAdsList to set
     */
    public void setAllAdsList(ArrayList<AllAds> allAdsList) {
        this.allAdsList = allAdsList;
    }

    /**
     * @return the usersAdsList
     */
    public ArrayList<AllAds> getUsersAdsList() {
        return usersAdsList;
    }

    /**
     * @param usersAdsList the usersAdsList to set
     */
    public void setUsersAdsList(ArrayList<AllAds> usersAdsList) {
        this.usersAdsList = usersAdsList;
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
    
}
