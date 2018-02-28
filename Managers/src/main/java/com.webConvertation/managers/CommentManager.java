package com.webConvertation.managers;

import com.webConvertation.dao.entity.Comments;
import com.webConvertation.dao.entity.User;
import com.webConvertation.hibernateFactory.Factory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nataliya on 27.02.2017.
 */
public class CommentManager {
    private static CommentManager instanse = null;

    public static CommentManager getCommentManager() {
        if (instanse == null) {
            instanse = new CommentManager();
        }
        return instanse;
    }

    public void addComment(Map<String, String[]> mapParam) throws Exception {
        int id = Integer.parseInt(mapParam.get("index")[0]);
        User currentUser = null;
        try {
            currentUser = Factory.getInstance().getUserDAO().getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't Find user!");
            throw new Exception();
        }
        String commentText = mapParam.get("commentText")[0];
        String dateStr = mapParam.get("date")[0];
        Comments comments = new Comments();

        Date date = Date.valueOf(dateStr);
        comments.setCommentText(commentText);
        comments.setDateComment(date);
        Set<Comments> commentSet = new HashSet<Comments>();
        commentSet.add(comments);
        currentUser.setCommentsSet(commentSet);
        System.out.println(commentText);
    }

    private void addInputComment(Comments comments, User currentUser) throws Exception {
        comments.setUser(currentUser);
        try {
            System.out.println("get factory");
            Factory.getInstance().getCommentDAO().addComment(comments);
        }catch (SQLException e) {
            System.out.println("Enable to add comment");
            e.printStackTrace();
            throw new Exception();
    }
    }
}
