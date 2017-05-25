package com.cts.demo.bo;

import java.util.List;

import com.cts.demo.dao.AccountDAO;
import com.cts.demo.entity.Account;

public class AccountBO {
	AccountDAO dao;
	
	public AccountBO(){
		dao = new AccountDAO();
	}
	
	public boolean deposit(int id, double amount){
//		Account account = dao.find(id);
//		double balance = account.getBalance();
//		double newBalance =  balance + amount;
		return dao.updateBalance(id, amount, true);
	}
	
	public boolean withdraw(int id, double amount){
//		Account account = dao.find(id);
//		double balance = account.getBalance();
//		double newBalance =  balance - amount;
		return dao.updateBalance(id, amount, false);
	}
	
	public void add(Account account){
		dao.add(account);
	}

	public List<Account> getLowBalanceAccounts() {
		return dao.getLowBalanceAccounts();
	}
	
	
}
