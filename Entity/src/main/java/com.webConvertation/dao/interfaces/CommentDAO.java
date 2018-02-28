package com.webConvertation.dao.interfaces;

import com.webConvertation.dao.entity.Comments;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nataliya on 25.02.2017.
 */
public interface CommentDAO {
    public void addComment(Comments comments) throws SQLException;
    public void updateComment(Comments comments) throws SQLException;
    public void deleteComment(Comments comments) throws SQLException;
    public List<Comments> getCommentsByUserID(long idUser) throws SQLException;

}
