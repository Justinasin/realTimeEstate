/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author pc
 */
public class Comments {
    
    private String commenterName;
    private String commentText;

    /**
     * @return the commenter
     */
    public String getCommenterName() {
        return commenterName;
    }

    /**
     * @param commenter the commenter to set
     */
    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
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
    
    public Comments(){}
}
