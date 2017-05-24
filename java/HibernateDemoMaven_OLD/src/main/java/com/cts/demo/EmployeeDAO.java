package com.cts.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
//	1. Create a Session Factory
	SessionFactory  sesssionFactory = new Configuration().configure().buildSessionFactory();

	
//	ALTER TABLE EMPLOYEE MODIFY COLUMN id INT auto_increment
	public static void main(String[] args) {
		Employee e = new Employee("Priya");
		EmployeeDAO dao = new EmployeeDAO();
		dao.find(2);
	}
	
	public void add(Employee e){
//		2. Create a session
		Session session = sesssionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(e);
		t.commit();
	}
	
	public void find(int id){
//		2. Create a session
		Session session = sesssionFactory.openSession();
		Transaction t = session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, 2);
		System.out.println(e);
		t.commit();
	}

}
