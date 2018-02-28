package com.webConvertation.dao.interfaces;

import com.webConvertation.dao.entity.FileImage;
import com.webConvertation.dao.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nataliya on 19.02.2017.
 */
public interface ImageDAO <T extends FileImage>{
    public void addImage(T image) throws SQLException;
    public void deleteImage(T image) throws SQLException;
    public void updateImage(T image) throws SQLException;
    public List<T> getImageByUserId(User user, String type) throws SQLException;

}
