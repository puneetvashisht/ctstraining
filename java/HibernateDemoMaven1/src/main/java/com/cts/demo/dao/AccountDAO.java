package com.cts.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.cts.demo.Employee;
import com.cts.demo.entity.Account;

public class AccountDAO {
	
	SessionFactory sessionFactory = new AnnotationConfiguration().
            configure().
            addAnnotatedClass(Account.class).
            buildSessionFactory();
	
	public Account find(int id){
//		2. Create a session
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();	
		Account account = (Account) session.get(Account.class, id);
		t.commit();
		session.close();
		return account;
	}
	
	public boolean updateBalance(int id, double amount, boolean isDeposit){
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();	
		Account account = (Account) session.get(Account.class, id);
		if(isDeposit){
			account.setBalance(account.getBalance()+ amount);
		}
		else{
			account.setBalance(account.getBalance()- amount);

		}
//		account.setBalance(balance);
		t.commit();
		session.close();
		return true;
		
	}

	public void add(Account account) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();	
		session.save(account);
		t.commit();
		session.close();
	
		
	}

}
