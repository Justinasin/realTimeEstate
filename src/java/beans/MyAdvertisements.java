package beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import models.Advertisement;


@Named(value = "myAdvertisements")
@ViewScoped
public class MyAdvertisements {

  private List<Advertisement> adv;
    
    public MyAdvertisements() {
    }
    
    public List<Advertisement> getAdv(){
        return adv;
    }
    
    public void setAdv(List<Advertisement> adv){
        this.adv=adv;
    }
    
}
    
