/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.apache.log4j.Logger;

/**
 *
 * @author eros
 */
public class HibernateUtilFaces {

     private static SessionFactory sessionFactory;
     static protected Logger log = Logger.getLogger("logs4.tmlab");
     private static Calendar cal1;


     static {
            try {
                // Create the SessionFactory from standard (hibernate.cfg.xml)
                // config file.
                sessionFactory = new AnnotationConfiguration().configure("hibernateOracle.cfg.xml").buildSessionFactory();
                System.out.println("Session is loaded...........................");
               // SessionFactory s = new AnnotationConfiguration().configure("kgk.xml").buildSessionFactory();
//                cal1 = Calendar.getInstance();
//                cal1.add(Calendar.HOUR, 168);

            } catch (Throwable ex) {
                // Log the exception.
                System.err.println("Initial SessionFactory creation failed." + ex);
//                log.error("SessionFactory creation failed. fuck.......", ex);
                
                throw new ExceptionInInitializerError(ex);
            }
    }



//    public static SessionFactory getSessionFactory() {
//                  Date caldate = cal1.getTime();
//
//                if(caldate.after(new GregorianCalendar().getTime())){
//                    if(sessionFactory.isClosed()){
//                            return sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//                    }
//                     return sessionFactory;
//                }else{
//                    
//                    
//                    log.error("SessionFactory was expired cause cal1 was expired adding 168hrs to cal1 and building a new sessionFactory. .......cal1: "+caldate);
//                    cal1 = Calendar.getInstance();
//                    cal1.add(Calendar.HOUR, 168);
//                    return sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//                }
//       
//    }


    
//    public static Session getSession(){
//            
//            return getSessionFactory().openSession();
//       
//    }

    

    
    public static Session getCurrentSession4Faces(){
        
        if(sessionFactory == null ){
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            return  sessionFactory.openSession();
        }else{
            return sessionFactory.openSession();
        }
            
    }
    
    

}
