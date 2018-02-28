package com.webConvertation.controller;

import com.webConvertation.managers.ImageManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Nataliya on 28.02.2017.
 */
public class ImageServlet extends APIHandlerServlet.APIRequestHandler {
    public static final ImageServlet instance = new ImageServlet();


    public static ImageServlet getInstance() {
        return instance;
    }

    private ImageServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        String type = map.get("type")[0];
       // Map<String, String> dataFromDb = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        switch (type) {
            case "change_Image": jsonObject = doSomethingWithImage(map); break;
            case "": break;

        }

    return  jsonObject;

    }

    private JSONObject doSomethingWithImage(Map<String, String[]> map){
        JSONObject jsonObject = new JSONObject();

        String[] dbFunctionResponce = new String [2];
        try {
            ImageManager.getImageManager().doSomethingWithImage(map);
        } catch (Exception e) {
            jsonObject.put("State", "Error! Can't change image!");
            return jsonObject;
        }
        jsonObject.put("State", "The image was changed!");
        return jsonObject;
    }

}
