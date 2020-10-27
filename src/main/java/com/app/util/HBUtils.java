package com.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtils {
	
	// static variable single_instance of type Singleton 
    private static SessionFactory single_instance = null;
    
    private HBUtils(){
    	
    }
    
    public static SessionFactory getSessionFactoryInstance()
    {
    	
        if (single_instance == null) {
        	Configuration cfg = new Configuration().configure();
        	single_instance = cfg.buildSessionFactory(); 
  
        }
        return single_instance; 
    } 
    
    public void closeSessionFactory() {
    	single_instance.close();
    }
}
