package com.cts.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class EmployeeDAO {
//	1. Create a Session Factory
//	SessionFactory  sesssionFactory = new Configuration().configure().buildSessionFactory();
	
//	Configuration configuration = new Configuration().configure();
//    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    
	SessionFactory sessionFactory = new AnnotationConfiguration().
            configure().
            addAnnotatedClass(Employee.class).
            buildSessionFactory();
	
//	ALTER TABLE EMPLOYEE MODIFY COLUMN id INT auto_increment
	public static void main(String[] args) {
		Employee e = new Employee("Ravi");
		EmployeeDAO dao = new EmployeeDAO();
//		dao.find(2);
		dao.add(e);
	}
	
	public void add(Employee e){
//		2. Create a session
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(e);
		t.commit();
	}
	
	public void find(int id){
//		2. Create a session
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Employee e = (Employee) session.get(Employee.class, 2);
		e.setName("Arun");
		System.out.println(e);
		
	
		
		t.commit();
		session.close();
	}

}
