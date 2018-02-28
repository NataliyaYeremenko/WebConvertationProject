package com.webConvertation.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nataliya on 08.02.2017.
 */
@Entity
@Table (name = "inputfiles")
public class InputFile extends FileImage {

    private User user;

    public InputFile() {

    }

    public InputFile(String type, String imageName, String path, String formatFile, Date date) {
        super(type, imageName, path, formatFile, date);
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
        return "InputFiles{" +
                "id=" + getId() +
                ", imageName=" + getFormatFile() +
                ", imageFormat='" + getFormatFile() + '\'' +
                ", imagePath='" + getPath() + '\'' +
                ", date='" + getCurrentDate() + '\'' +
                ", user=" + user +
                '}';
    }

}

