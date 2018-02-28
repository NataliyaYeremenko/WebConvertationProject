package com.webConvertation.controller;

import com.webConvertation.dao.entity.User;
import com.webConvertation.hibernateFactory.Factory;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nataliya on 27.03.2017.
 */
public class ChangeInfoServlet extends APIHandlerServlet.APIRequestHandler {
    public static final ChangeInfoServlet instance = new ChangeInfoServlet();


    public static ChangeInfoServlet getInstance() {
        return instance;
    }

    private ChangeInfoServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String password = request.getParameter("repeat_password");
        String email = request.getParameter("emailReg");
        Cookie[] cookies = request.getCookies();
        String userLog = cookies[0].getValue();
        User user = Factory.getInstance().getUserDAO().getUserByName(userLog);
        String pasFromDB = user.getPassword();
        System.out.println(pasFromDB);
        if (pasFromDB.equals(oldPassword)){
            if (newPassword.equals(password)) {
                user.setPassword(password);
                user.setEmail(email);
                user.setName(userLog);
                Factory.getInstance().getUserDAO().updateUser(user);
            }
            else System.out.println("Passwords do not match");
        }
        else System.out.println("Incorrect password");

        return null;





    }


}
