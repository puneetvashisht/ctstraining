package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Employee;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;

@Component
public class ApplyHomeLoanDAO {
	@PersistenceContext
    private EntityManager em;
	
        @Transactional	
 	    public boolean applyHomeLoanUserDetails(UserDetails ud)
	    {
	    	
			System.out.println("in dao add 2");
				
				System.out.println("in dao add 3");
				
				System.out.println("in dao add 4");
				em.persist(ud);
					System.out.println("in dao add 5");
					
	    	
	    	return true;
	    }
	    
        public long insertHomeLoanDetails(UserDetails user)
        {
        	
        	
        	
        	return 3l;
        }
        
        public UserDetails gettHomeLoanUserDetails(long accountNumber)
        {
        	
        	UserDetails ud = em.find(UserDetails.class, accountNumber);
    		return ud;
        	
        	
        	
        }
	
	
	

}
