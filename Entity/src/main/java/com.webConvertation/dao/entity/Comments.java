package com.webConvertation.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nataliya on 15.02.2017.
 */
@Entity
@Table (name = "comments")
public class Comments {
    private int idComment;
    private Date dateComment;
    private String commentText;
    private User user;

    public Comments() {
        commentText = null;
    }

    public Comments(Date dateComment, String commentText) {
        this.dateComment = dateComment;
        this.commentText = commentText;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idComment")
    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    @Column (name = "commentDate")
    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    @Column (name = "commentText")
    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "idComment=" + idComment +
                ", dateComment=" + dateComment +
                ", commentText='" + commentText + '\'' +
                ", user=" + user +
                '}';
    }
}

