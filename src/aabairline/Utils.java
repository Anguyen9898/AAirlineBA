/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import aabairline.pojo.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    
    public static List<AirportInfo> getAirportInfos(){
        session = factory.openSession();
        cr = session.createCriteria(AirportInfo.class);
        List<AirportInfo> airportInfos = cr.list();
        session.close(); 
        return airportInfos;
    }
    
    public static List<Route> getDestinationByAId(AirportInfo ai){
        session = factory.openSession();
        cr = session.createCriteria(Route.class);
        cr.add(Restrictions.eq("takeOffAP", ai));
        List<Route> routes = cr.list();
        session.close(); 
        return routes;
    }
    
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
    
    public static List<Customer> getCustomerById(String id){
        session = factory.openSession();
        cr = session.createCriteria(Customer.class);
        cr.add(Restrictions.like("id", id));
        List<Customer> customers = cr.list();
        session.close(); 
        return customers;
    }
    
    public static boolean addOrUpdateCustomer(Customer customer){
        session = factory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.saveOrUpdate(customer);
            trans.commit();
        } catch (Exception ex) {
            if (trans != null)
                trans.rollback(); 
            return false;
        } finally {
            session.close();
        }
        
        return true;
    }
   
    public static List<Route> getRoutesByAirportId(AirportInfo takeOffId
            , AirportInfo arrival){
        session = factory.openSession();
        cr = session.createCriteria(Route.class);
       
        cr.add(Restrictions.and(Restrictions.eq("takeOffAP", takeOffId),
                Restrictions.eq("arrivalAP", arrival)));
        List<Route> route = cr.list();
        session.close(); 
        return route;
    }
    
    public static boolean addOrUpdateTicket(Ticket ticket){
        session = factory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.saveOrUpdate(ticket);
            trans.commit();
        } catch (Exception ex) {
            if (trans != null)
                trans.rollback(); 
            return false;
        } finally {
            session.close();
        }
        
        return true;
    }
    
     public static List<TicketingAgent> getTicketingAgentsByTxt(String txt){
        session = factory.openSession();
        cr = session.createCriteria(TicketingAgent.class);
        cr.add(Restrictions.or(Restrictions.like("ta_Id", txt)
                , Restrictions.like("ta_AccountId", txt)));
        List<TicketingAgent> ticketingAgents = cr.list();
        session.close(); 
        return ticketingAgents;
    }
    
    public static List<Route> getRoute(){
        session = factory.openSession();
        cr = session.createCriteria(Route.class);
        List<Route> routes = cr.list();
        session.close(); 
        return routes;
    }
    
    public static List<FlightInfo> getFlightInfo(){
        session = factory.openSession();
        cr = session.createCriteria(FlightInfo.class);
        List<FlightInfo> flightInfos = cr.list();
        session.close(); 
        return flightInfos;
    }
    
    public static List<FlightInfo> getFlightInfoById(String id){
        session = factory.openSession();
        cr = session.createCriteria(FlightInfo.class);
        cr.add(Restrictions.like("id", id));
        List<FlightInfo> flightInfos = cr.list();
        session.close(); 
        return flightInfos;
    }
     
    public static List<FlightInfo> getFlightInfosByCon(Date date, Route route){
        session = factory.openSession();
        cr = session.createCriteria(FlightInfo.class);
        cr.add(Restrictions.and(Restrictions.like("takeOfDate", date)
                , Restrictions.eq("route", route)));
        List<FlightInfo> flightInfos = cr.list();
        session.close(); 
        return flightInfos;
    }
    
    public static boolean addOrUpdateFlightInfo(FlightInfo flight){
        session = factory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.saveOrUpdate(flight);
            trans.commit();
        } catch (Exception ex) {
            if (trans != null)
                trans.rollback(); 
            return false;
        } finally {
            session.close();
        }
        
        return true;
    }
     
    public static boolean deleteFlightById(FlightInfo flightInfo){
        session = factory.openSession();
        try {
           session.beginTransaction();
           session.delete(flightInfo);
           session.getTransaction().commit(); 
           return true;
        } catch (Exception ex) {
           session.getTransaction().rollback();
           return false;
        }finally{
            session.close();
        }
    }
    
    public static List<Flying> getFlying(){
        session = factory.openSession();
        cr = session.createCriteria(Flying.class);
        List<Flying> flyings = cr.list();
        session.close(); 
        return flyings;
    }
    
    public static List<Flying> getFlyingById(FlightInfo fid){
        session = factory.openSession();
        cr = session.createCriteria(Flying.class);
        cr.add(Restrictions.eq("flightId", fid));
        List<Flying> flyings = cr.list();
        session.close(); 
        return flyings;
    }
    
    public static boolean deleteFlyingById(Flying flying){
        session = factory.openSession();
        try {
           session.beginTransaction();
           session.delete(flying);
           session.getTransaction().commit(); 
           return true;
        } catch (Exception ex) {
           session.getTransaction().rollback();
           return false;
        }finally{
            session.close();
        }
    }
    
    public static boolean addOrUpdateFlying(Flying flight){
        session = factory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.saveOrUpdate(flight);
            trans.commit();
        } catch (Exception ex) {
            if (trans != null)
                trans.rollback(); 
            return false;
        } finally {
            session.close();
        }
        
        return true;
    }
    
    public static List<Employee> getEmployees(String id){
        session = factory.openSession();
        cr = session.createCriteria(Employee.class);
        cr.add(Restrictions.ilike("e_Id", "%" + id + "%"));
        List<Employee> emps = cr.list();
        session.close(); 
        return emps;
    }
    
     public static List<Plane> getPlanes(){
        session = factory.openSession();
        cr = session.createCriteria(Plane.class);
        List<Plane> planes = cr.list();
        session.close(); 
        return planes;
    }
}
