package com.webConvertation.dao.interfaces;

import java.sql.SQLException;
import com.webConvertation.dao.entity.User;

/**
 * Created by Nataliya on 15.02.2017.
 */
public interface UserDAO {
    public void addUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public User getUserByName(String name) throws SQLException;
    public void deleteUser(User user) throws SQLException;
    public Long getUserIdByName(String name) throws SQLException;
    public User getUserById(long id)throws SQLException;
}
