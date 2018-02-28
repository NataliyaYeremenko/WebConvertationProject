package com.webConvertation.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nataliya on 08.02.2017.
 */
@Entity
@Table(name = "outputFiles")
public class OutputFile extends FileImage{
    private String outPath;
    private int quality;
    private User user;

    public OutputFile() {

    }

    public OutputFile(String type, String imageName, String path, String formatFile, Date date) {
        super(type, imageName, path, formatFile, date);
    }

    public OutputFile(String type, String imageName, String path, String outPath, String formatFile, int quality,
                      Date date) {
        super(type, imageName, path, formatFile, date);
        this.outPath = outPath;
        this.quality = quality;
    }

    @Column (name = "outputPath")
    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    @Column (name = "quality")
    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
