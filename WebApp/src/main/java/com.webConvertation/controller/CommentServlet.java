package com.webConvertation.controller;

import com.webConvertation.dao.entity.Comments;
import com.webConvertation.dao.entity.User;
import com.webConvertation.hibernateFactory.Factory;
import com.webConvertation.managers.CommentManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.events.Comment;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nataliya on 28.02.2017.
 */
public class CommentServlet extends APIHandlerServlet.APIRequestHandler {
    public static final CommentServlet instance = new CommentServlet();


    public static CommentServlet getInstance() {
        return instance;
    }

    private CommentServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String comment = request.getParameter("comment");
        String date = request.getParameter("date");
        //String userLog = request.getParameter("user");
        Cookie [] cookies = request.getCookies();
        String userLog = cookies[0].getValue();
        Comments commentNew = new Comments();
        //String user = request.getParameter("name");
        //System.out.println(user);
        commentNew.setCommentText(comment);
        commentNew.setDateComment(new java.util.Date());
        Set<Comments> commentSet = new HashSet<Comments>();
        commentSet.add(commentNew);
        User user = Factory.getInstance().getUserDAO().getUserByName(userLog);
        user.setCommentsSet(commentSet);
        commentNew.setUser(user);
        Factory.getInstance().getUserDAO().updateUser(user);
        Factory.getInstance().getCommentDAO().addComment(commentNew);
        /*try {
            Factory.getInstance().getUserDAO().updateUser(user);
            Factory.getInstance().getCommentDAO().addComment(commentNew);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't Find user!");
            throw new Exception();
        }*/

        System.out.println("comment: " + comment);
        return null;





    }
        /*Map<String, String[]> map = request.getParameterMap();
        String type = map.get("type")[0];
       // Map<String, String> dataFromDb = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        switch (type) {
            case "add_Comment": jsonObject = addComment(map); break;
            case "": break;

        }

    return  jsonObject;

    }

    private JSONObject addComment(Map<String, String[]> map){
        JSONObject jsonObject = new JSONObject();

        String[] dbFunctionResponce = new String [2];
        try {
            CommentManager.getCommentManager().addComment(map);
        } catch (Exception e) {
            jsonObject.put("State", "Error! Can't add comment!");
            return jsonObject;
        }
        jsonObject.put("State", "The comment was added!");
        return jsonObject;
    }*/

}
