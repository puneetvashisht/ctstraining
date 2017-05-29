package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentsBO {
	
	PaymentsDAO paymentsDAO;
//	PaymentsBO(){
//		dao = new PaymentsDAO();
//	}
	
	public PaymentsBO(){
		
	}
	@Autowired
	public PaymentsBO(PaymentsDAO paymentsDAO){
		this.paymentsDAO = paymentsDAO;
	}
	
	public void credit(){
		System.out.println("Credit in BO class");
		paymentsDAO.credit();
		
	}
	public void debit() {
		System.out.println("Debit in BO class");
		paymentsDAO.debit();
		
	}
	public void accountsEntry() {
		System.out.println("Accounts entry in BO class");
		paymentsDAO.accountsEntry();
		
	}

}
