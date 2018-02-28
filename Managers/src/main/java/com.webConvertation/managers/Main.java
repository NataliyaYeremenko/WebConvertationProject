package com.webConvertation.managers;


import com.webConvertation.dao.entity.OutputFile;
import com.webConvertation.dao.entity.User;
import com.webConvertation.hibernateFactory.Factory;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

/**
 * Created by Nataliya on 09.03.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        /*ImageManager im = new ImageManager();
        User user = Factory.getInstance().getUserDAO().getUserById(1);
        System.out.println("User 1 " + user.getName());
        List<OutputFile> outputFileList = Factory.getInstance().getImageDAO().getImageByUserId(user,"OUTPUT");
        String p1 = outputFileList.get(0).getPath();
        System.out.println(p1);
        String p2 = outputFileList.get(0).getOutPath();
        int q = outputFileList.get(0).getQuality();
        System.out.println("quality = " + q);
        //ImageToGrayScale grImage = new ImageToGrayScale(p1, "png", p2);
        //grImage.toGrayScale();

        //im.doSomethingWithImage();*/
    }
}
