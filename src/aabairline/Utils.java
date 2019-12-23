/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import aabairline.pojo.AirportInfo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
}
