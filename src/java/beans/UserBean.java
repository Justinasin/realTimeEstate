package beans;

import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@Named(value = "userBean")
@ManagedBean
@ViewScoped
public class UserBean implements Serializable {

    private boolean disableComment = false;
    private boolean disableEmail = false;

    public void showComment() {

        disableComment = true;
        disableEmail = false;
    }

    public void showEmail() {

        disableComment = false;
        disableEmail = true;
    }

    public boolean getStatusOfComment() {
        return disableComment;
    }

    public void setStatusOfComment(boolean disableComment) {
        this.disableComment = disableComment;
    }

    public boolean getStatusOfEmail() {
        return disableEmail;
    }

    public void setStatusOfEmail(boolean disableEmail) {
        this.disableEmail = disableEmail;
    }

}
