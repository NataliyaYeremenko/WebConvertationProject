package com.webConvertation.dao.implementations;

import com.webConvertation.dao.entity.Comments;
import com.webConvertation.dao.interfaces.CommentDAO;
import com.webConvertation.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nataliya on 25.02.2017.
 */
public class CommentDAOImpl implements CommentDAO{
    @Override
    public void addComment(Comments comments) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save((comments));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateComment(Comments comments) throws SQLException {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession();){
            session.beginTransaction();
            session.update(comments);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteComment(Comments comments) throws SQLException {

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete((comments));
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comments> getCommentsByUserID(long idUser) throws SQLException {
        List<Comments> commentsList = new ArrayList<Comments>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            commentsList = session.createFilter("idUser", Long.toString(idUser)).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentsList;
    }
}
