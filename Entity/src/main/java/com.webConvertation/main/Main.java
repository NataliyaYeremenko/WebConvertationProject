package com.webConvertation.main;

import com.webConvertation.dao.entity.Comments;
import com.webConvertation.dao.entity.InputFile;
import com.webConvertation.dao.entity.OutputFile;
import com.webConvertation.dao.entity.User;
import com.webConvertation.hibernateFactory.Factory;

import java.sql.SQLException;

import java.util.*;

/**
 * Created by Nataliya on 28.02.2017.
 */
public class Main {


    public static void main(String[] args) throws SQLException, IndexOutOfBoundsException {

        Comments c1 = new Comments();
        c1.setCommentText("davhdsjvhdsj");
        c1.setDateComment(new Date());

        InputFile if1 = new InputFile();
        if1.setType("INPUT");
        if1.setImageName("image");
        if1.setPath("e:\\JAVA\\Course\\WebConvertationProject\\Images\\InputImages\\image.jpg");
        if1.setFormatFile("jpg");
        if1.setCurrentDate(new Date());

        OutputFile of1 = new OutputFile();
        of1.setType("OUTPUT");
        of1.setImageName("image1");
        of1.setPath("e:\\JAVA\\Course\\WebConvertationProject\\Images\\InputImages\\image.jpg");
        of1.setOutPath("e:\\JAVA\\Course\\WebConvertationProject\\Images\\OutputImages\\image1.jpg");
        of1.setFormatFile("jpg");
        of1.setQuality(25);
        of1.setCurrentDate(new Date());

        User u1 = new User();
        u1.setName("Ivanov");
        u1.setEmail("email1@gmail.com");
        u1.setPassword("123456");

        c1.setUser(u1);
        if1.setUser(u1);
        of1.setUser(u1);

        User u2 = new User ("Petrov", "gmail@gmail.com", "12345");
        Comments c2 = new Comments(new Date(), "bjnsgjbsjb");
        InputFile if2 = new InputFile("INPUT","font",
                "e:\\JAVA\\Course\\WebConvertationProject\\Images\\InputImages\\font.png",
                "jpg", new Date());
        OutputFile of2 = new OutputFile("OUTPUT","font1",
                "e:\\JAVA\\Course\\WebConvertationProject\\Images\\InputImages\\font.png",
                "e:\\JAVA\\Course\\WebConvertationProject\\Images\\OutputImages\\font1.png",
                "png", 35, new Date());

        Set<InputFile> inputFiles1= new HashSet<InputFile>();
        inputFiles1.add(if1);
        inputFiles1.add(if2);
        Set<OutputFile> outputFiles1= new HashSet<OutputFile>();
        outputFiles1.add(of1);
        outputFiles1.add(of2);
        Set<Comments> comments1 = new HashSet<Comments>();
        comments1.add(c1);
        comments1.add(c2);

        //u2.setInputFiles(inputFiles1);
        //u2.setCommentsSet(comments1);
        //u2.setOutputFiles(outputFiles1);
        c2.setUser(u2);
        if2.setUser(u2);
        of2.setUser(u2);

        Factory.getInstance().getUserDAO().addUser(u1);
        Factory.getInstance().getCommentDAO().addComment(c1);
        Factory.getInstance().getImageDAO().addImage(if1);
        Factory.getInstance().getImageDAO().addImage(of1);

        Factory.getInstance().getUserDAO().addUser(u2);
        Factory.getInstance().getImageDAO().addImage(if2);
        Factory.getInstance().getImageDAO().addImage(of2);
        Factory.getInstance().getCommentDAO().addComment(c2);


        List<OutputFile> outputFileList = Factory.getInstance().getImageDAO().getImageByUserId(u2,"OUTPUT");
        for (int i = 0; i<outputFileList.size(); i++) {
            System.out.println(outputFileList.get(i).getImageName());
            System.out.println(outputFileList.get(i).getPath());
            System.out.println(outputFileList.get(i).getOutPath());
        }

        List<InputFile> inputFileList = Factory.getInstance().getImageDAO().getImageByUserId(u2,"INPUT");
        for (int i = 0; i<inputFileList.size(); i++) {
            System.out.println(inputFileList.get(i).getImageName());
            System.out.println(inputFileList.get(i).getPath());
            System.out.println(inputFileList.get(i).getCurrentDate());
        }
          //  System.out.println((Factory.getInstance().getUserDAO().getUserById(1)).getName());


    }

}
