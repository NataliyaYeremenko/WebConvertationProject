package com.webConvertation.hibernateFactory;

import com.webConvertation.dao.entity.InputFile;
import com.webConvertation.dao.entity.OutputFile;
import com.webConvertation.dao.implementations.CommentDAOImpl;
import com.webConvertation.dao.implementations.FileImageDAOImpl;
import com.webConvertation.dao.implementations.UserDAOImpl;
import com.webConvertation.dao.interfaces.CommentDAO;
import com.webConvertation.dao.interfaces.ImageDAO;
import com.webConvertation.dao.interfaces.UserDAO;

/**
 * Created by Nataliya on 17.02.2017.
 */
public class Factory {

    private static UserDAO userDAO = null;
    private static ImageDAO imageDAO = null;
    private static CommentDAO commentDAO = null;

    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    public ImageDAO getImageDAO() {
        if (imageDAO == null) {
            imageDAO = new FileImageDAOImpl();
        }
        return imageDAO;
    }

    public CommentDAO getCommentDAO() {
        if (commentDAO == null) {
            commentDAO = new CommentDAOImpl();
        }
        return commentDAO;
    }
}