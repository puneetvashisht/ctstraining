package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
/*@Table(name="USER_DETAILS")*/
public class UserDetails {
	@Id
	Long accountNumber;
	String accountType;
	String accountHolderName;
	Double accountBalance;
	/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<TransactionDetails> trans;*/
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<HomeLoanDetails> homeloan;
	public UserDetails()
	{
	}
	public UserDetails(Long accountNumber, String accountType, String accountHolderName, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}
	public UserDetails(Long accountNumber, String accountType, String accountHolderName, Double accountBalance,
			List<HomeLoanDetails> homeloan) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.homeloan = homeloan;
	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)

	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<HomeLoanDetails> getHomeloan() {
		return homeloan;
	}
	public void setHomeloan(List<HomeLoanDetails> homeloan) {
		this.homeloan = homeloan;
	}
	@Override
	public String toString() {
		return "UserDetails [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", accountBalance=" + accountBalance + ", homeloan=" + homeloan + "]";
	}
	
	
	
	

}
