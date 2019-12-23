/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import aabairline.pojo.AirportInfo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author anguy
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configure = new Configuration();
            configure.addAnnotatedClass(AirportInfo.class);
            configure.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder builder
                    = new StandardServiceRegistryBuilder()
                            .applySettings(configure.getProperties());
            sessionFactory = configure.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
