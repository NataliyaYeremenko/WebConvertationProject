package com.webConvertation.dao.implementations;

import com.webConvertation.dao.entity.InputFile;
import com.webConvertation.dao.entity.OutputFile;
import org.hibernate.Session;
import com.webConvertation.dao.entity.FileImage;
import com.webConvertation.dao.entity.User;
import com.webConvertation.dao.interfaces.ImageDAO;
import com.webConvertation.hibernateFactory.HibernateSessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nataliya on 19.02.2017.
 */
public class FileImageDAOImpl<T extends FileImage> implements ImageDAO <T> {

    @Override
    public void addImage(T image) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save((image));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteImage(T image) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete((image));
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void updateImage(T image) throws SQLException {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update((image));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getImageByUserId(User user, String type) throws SQLException {
        List<T> imagesList = new ArrayList<T>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            //if (type == "OUTPUT")imagesList = session.createQuery("SELECT * FROM InputFile im WHERE im.idUser IN :id").setParameter("id", user.getIdUser()).getResultList();
            //imagesList = session.createCriteria(type).add(Restrictions.eq("user", user)).list();
            if (type == "OUTPUT") imagesList = session.createCriteria(OutputFile.class).add(Restrictions.eq("user", user)).list();
            if (type == "INPUT") imagesList = session.createCriteria(InputFile.class).add(Restrictions.eq("user", user)).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagesList;
    }
}
