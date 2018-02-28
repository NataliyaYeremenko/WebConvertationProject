package com.webConvertation.managers;

import com.webConvertation.dao.entity.FileImage;
import com.webConvertation.dao.entity.InputFile;
import com.webConvertation.dao.entity.OutputFile;
import com.webConvertation.dao.entity.User;
import com.webConvertation.hibernateFactory.Factory;
import com.webConvertation.managers.IDT.ImageToGrayScale;
import com.webConvertation.managers.IDT.JpegEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import static com.webConvertation.dao.entity.ImageType.INPUT;
import static com.webConvertation.dao.entity.ImageType.OUTPUT;
import static com.webConvertation.dao.entity.OperationType.CONVERT;
import static com.webConvertation.dao.entity.OperationType.TOGRAYSCALE;


/**
 * Created by Nataliya on 25.02.2017.
 */
public class ImageManager {

    private static ImageManager instanse = null;

    public static ImageManager getImageManager() {
        if (instanse == null) {
            instanse = new ImageManager();
        }
        return instanse;
    }

    public void doSomethingWithImage(Map<String, String[]> mapParam) throws Exception {
        int id = Integer.parseInt(mapParam.get("index")[0]);
        User currentUser = null;
        try {
            currentUser = Factory.getInstance().getUserDAO().getUserById(id);
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't Find user!");
            throw new Exception();
        }
        String imagetype = mapParam.get("imageType")[0];
        String imageName = mapParam.get("name")[0];
        String formatFile = mapParam.get("formatFile")[0];
        String inputpath = mapParam.get("inputpath")[0];
        String operationType = mapParam.get("operationType")[0];
        String newImageName = mapParam.get("newName")[0];
        String outputpath = mapParam.get("outputpath")[0];
        String quality = mapParam.get("quality")[0];
        String dateStr = mapParam.get("date")[0];
        Date date = Date.valueOf(dateStr);

        FileImage image = new InputFile();
        OutputFile outImage = new OutputFile();
        FileImage outputFile = new FileImage();

        if (imagetype.equals(INPUT.getDescription())){
            image.setFormatFile(imagetype);
            image.setCurrentDate(date);
            image.setFormatFile(formatFile);
            image.setPath(inputpath);
            image.setImageName(imageName);
            addFile(image, currentUser);
            System.out.println("create inputfile");
        }
        if (imagetype.equals(OUTPUT.getDescription())){
            outImage.setImageName(newImageName);
            outImage.setFormatFile(imagetype);
            outImage.setCurrentDate(date);
            outImage.setFormatFile(formatFile);
            outImage.setPath(inputpath);
            outImage.setOutPath(outputpath);
            outImage.setQuality(Integer.parseInt(quality));
            addFile(outImage, currentUser);
            System.out.println("create outputfile");
            if(operationType.equals(CONVERT.getDescription())){
                BufferedImage imageBuf = ImageIO.read (new File(inputpath));
                FileOutputStream outputStream = new FileOutputStream(outputpath);
                JpegEncoder jpegEncoder = new JpegEncoder(imageBuf, Integer.parseInt(quality), outputStream);
                jpegEncoder.Compress();
                outputFile = new FileImage(imagetype, newImageName, outputpath, formatFile, date);
                System.out.println("Convert and add image");
            }
            if(operationType.equals(TOGRAYSCALE.getDescription())) {
                ImageToGrayScale grImage = new ImageToGrayScale(inputpath, formatFile, outputpath);
                grImage.toGrayScale();
                outputFile = new FileImage(imagetype, newImageName, outputpath, formatFile, date);
                System.out.println("toGrayScale and add image");
        }
        try {
            Factory.getInstance().getImageDAO().addImage(outputFile);
        }catch (SQLException e) {
            System.out.println("Enable to chandge image");
            e.printStackTrace();
            throw new Exception();
        }
    }
   }

    private void addFile(FileImage fileImage, User currentUser) throws Exception {
        fileImage.setUser(currentUser);
        try {
            System.out.println("get factory");
            Factory.getInstance().getImageDAO().addImage(fileImage);

        }catch (SQLException e) {
            System.out.println("Enable to add image");
            e.printStackTrace();
            throw new Exception();

        }

    }


}
