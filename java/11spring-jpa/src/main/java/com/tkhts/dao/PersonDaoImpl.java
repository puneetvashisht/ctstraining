package com.tkhts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tkhts.entity.Person;
import com.tkhts.exceptions.CommitException;
import com.tkhts.exceptions.RollbackException;





public class PersonDaoImpl {
 
    @PersistenceContext
    private EntityManager em;
    
    AnotherPersonDaoImpl anotherPersonDaoImpl;
    
    public AnotherPersonDaoImpl getAnotherPersonDaoImpl() {
		return anotherPersonDaoImpl;
	}
	public void setAnotherPersonDaoImpl(AnotherPersonDaoImpl anotherPersonDaoImpl) {
		this.anotherPersonDaoImpl = anotherPersonDaoImpl;
	}
	@Transactional(noRollbackFor=RuntimeException.class)
    public void save(Person person) throws Exception{
    	
        em.persist(person); 
        
//        throw new Exception("Something went wrong");
        
        
        
        
       /* Person person1 = new Person();
        person1.setName("Another");
        person1.setSurname("L1");
        
        
        throw new CommitException();*/
        
        
//        anotherPersonDaoImpl.saveAnother(person1);
//        throw new RollbackException();
        // Step 2 Message
//        throw new CommitException();   
        // Setup 3 Debit
        // Setup 4 Accounting
  
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void saveAnother(Person person) {
    	
    	Person anotherPerson = new Person();
    	anotherPerson.setName(person.getName());
    	anotherPerson.setSurname(person.getSurname());
    	
        em.persist(anotherPerson);
        
        
        throw new RollbackException();
        // Step 2 Message
//        throw new CommitException();   
        // Setup 3 Debit
        // Setup 4 Accounting
  
    }
     
    public List<Person>getAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
