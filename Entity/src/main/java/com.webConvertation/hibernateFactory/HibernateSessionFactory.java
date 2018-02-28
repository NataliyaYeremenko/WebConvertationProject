package com.webConvertation.hibernateFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Nataliya on 17.02.2017.
 */
public class HibernateSessionFactory {
        private static SessionFactory sessionFactory = null;

        static {
            try{
                sessionFactory =  new Configuration().configure().buildSessionFactory();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public static SessionFactory getSessionFactory(){
            return sessionFactory;
        }
}
