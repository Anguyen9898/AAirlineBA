/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import aabairline.pojo.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author anguy
 */
public class Utils {
    private static Session session;
    private static Criteria cr;
    //private static Query query;
    private static final SessionFactory factory = HibernateUtils.getSessionFactory();
    
    /**
     * Airport table
     * @return 
     */
    public static List<AirportInfo> getAirportInfos(){
        session = factory.openSession();
        cr = session.createCriteria(AirportInfo.class);
        List<AirportInfo> airportInfos = cr.list();
        session.close(); 
        return airportInfos;
    }
    
    /**
     * Route table
     * @param ai
     * @return 
     */
    public static List<Route> getDestinationByAId(AirportInfo ai){
        session = factory.openSession();
        cr = session.createCriteria(Route.class);
        cr.add(Restrictions.eq("takeOffAP", ai));
        List<Route> routes = cr.list();
        session.close(); 
        return routes;
    }
    
    /**
     * Country table
     * @return 
     */
    public static List<Country> getCountry(){
        session = factory.openSession();
        cr = session.createCriteria(Country.class);
        List<Country> countries = cr.list();
        session.close(); 
        return countries;
    }
    
    public static List<String> getPhonePrefix(){
        List<String> phonePrefix = new ArrayList<>();
        getCountry().forEach(item ->{
            phonePrefix.add(item.getPhonePrefix() + " (" + item.getName() + ")");
        });
        return phonePrefix;
    }
    
    /**
     * Customer table
     * @return 
     */
    public static long countCustomer(){
        session = factory.openSession();
        cr = session.createCriteria(Customer.class);
        cr.setProjection(Projections.count("id"));
        List<Long> kq = cr.list();
        session.close();
        
        return kq.get(0);
    }
    
    public static List<Customer> getCustomer(){
        session = factory.openSession();
        cr = session.createCriteria(Customer.class);
        List<Customer> customers = cr.list();
        session.close(); 
        return customers;
    }
}
