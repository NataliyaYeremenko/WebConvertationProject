package com.webConvertation.dao.entity;

/**
 * Created by Nataliya on 25.02.2017.
 */
public enum ImageFormatType {
    JPG ("jpg"),
    PNG ("png");

    private String description;

    private ImageFormatType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
