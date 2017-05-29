package com.demo;

import org.springframework.stereotype.Component;

@Component
public class PaymentsDAO {
	
	public PaymentsDAO(){
		
	}

	public void credit() {
		System.out.println("Credit in DAO class");
		
	}

	public void debit() {
		System.out.println("Debit in DAO class");
		
	}

	public void accountsEntry() {
		System.out.println("AccountsEntry in DAO class");
	}

}
