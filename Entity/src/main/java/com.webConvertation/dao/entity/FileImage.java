package com.webConvertation.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by Nataliya on 19.02.2017.
 */
@MappedSuperclass
public class FileImage {
    private int idImage;
    private String type;
    private String imageName;
    private String path;
    private String formatFile;
    private Date currentDate;

    private User user;

    public FileImage() {
        path = null;
    }

    public FileImage(String type, String imageName, String path, String formatFile, Date date){
        super();
        this.type = type;
        this.imageName = imageName;
        this.path = path;
        this.formatFile = formatFile;
        this.currentDate = date;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idImage")

    public int getId() {
        return idImage;
    }

    public void setId(int idImage) {
        this.idImage = idImage;
    }

    @Column (name = "imageType")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column (name = "imageName")
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Column (name = "filePath")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column (name = "formatFile")
    public String getFormatFile() {
        return formatFile;
    }

    public void setFormatFile(String formatFile) {
        this.formatFile = formatFile;
    }

    @Column(name = "currentDate")
    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return currentDate + " " + imageName + " " + path + " "
                + formatFile;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
