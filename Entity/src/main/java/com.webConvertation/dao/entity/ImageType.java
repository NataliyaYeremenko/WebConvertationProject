package com.webConvertation.dao.entity;

/**
 * Created by Nataliya on 09.03.2017.
 */
public enum ImageType {
    INPUT("InputFile"),
    OUTPUT("OutputFile");

    private String description;

    private ImageType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
