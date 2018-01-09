/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.CommentsDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Inject;
import models.AllAds;
import models.Comments;
import models.UpdateAds;

/**
 *
 * @author pc
 */
@Named(value = "commentsBean")
@SessionScoped
public class CommentsBean implements Serializable {
    
    private String commentText;
    private String commenterName;
    private final CommentsDao commentsDao = new CommentsDao();
    private AllAds selectedCommentAd = new AllAds();
    private ArrayList<Comments> comments = new ArrayList<Comments>();
    
@Inject
private LoginBean loginBean;

    /**
     * Creates a new instance of CommentsBean
     */
    public CommentsBean() {
    }
    
    public void postComment() throws Exception
    {
        Comments comment = new Comments();

        
        int id = selectedCommentAd.getAdv_id();
        comment.setCommentText(commentText);
        
        
        commentsDao.insertComment(loginBean.getUsername(),comment, id);
        
    }
    
    public ArrayList<Comments> fetchComments() throws Exception
    {
        comments.clear();
        int id = selectedCommentAd.getAdv_id();
        return comments = commentsDao.selectComments(id);
    }

    /**
     * @return the commentText
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * @param commentText the commentText to set
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    /**
     * @return the commenterName
     */
    public String getCommenterName() {
        return commenterName;
    }

    /**
     * @param commenterName the commenterName to set
     */
    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    /**
     * @return the selectedCommentAd
     */
    public AllAds getSelectedCommentAd() {
        return selectedCommentAd;
    }

    /**
     * @param selectedCommentAd the selectedCommentAd to set
     */
    public void setSelectedCommentAd(AllAds selectedCommentAd) {
        this.selectedCommentAd = selectedCommentAd;
    }
    
    
    
}
