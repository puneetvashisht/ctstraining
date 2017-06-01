package com.cognizant.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Entity
@Component
public class HomeLoanDetails {
	@Id
	private String homeLoanId;
	private Long accountNumber;
	private String homeLoanAccountNumber;
	private Long loanAmount;
	private Date loanApplyDate;
	private long annualIncome;
	private String companyName;
	private String designation;
	int totalExp;
	int expCurrentDate;
	@ManyToOne(fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	
	private UserDetails user;
	
	public HomeLoanDetails(){
		
	}

	public HomeLoanDetails(String homeLoanId, Long account_Number, String homeLoanAccountNumber, Long loanAccount,
			Date loanApplyDate, long annualIncome, String companyName, String designation, int totalExp,
			int expCurrentDate) {
		super();
		this.homeLoanId = homeLoanId;
		this.accountNumber = account_Number;
		this.homeLoanAccountNumber = homeLoanAccountNumber;
		this.loanAmount = loanAccount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
	}

	public HomeLoanDetails(long account_Number, long loanAccount, Date loanApplyDate, long annualIncome, String companyName, String designation, int totalExp, int expCurrentDate) {
		// TODO Auto-generated constructor stub
		super();
		
		this.accountNumber = account_Number;
		
		this.loanAmount = loanAccount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		
	}
	
	

	public HomeLoanDetails(String homeLoanId, Long accountNumber, String homeLoanAccountNumber, Long loanAmount,
			Date loanApplyDate, long annualIncome, String companyName, String designation, int totalExp,
			int expCurrentDate, UserDetails user) {
		super();
		this.homeLoanId = homeLoanId;
		this.accountNumber = accountNumber;
		this.homeLoanAccountNumber = homeLoanAccountNumber;
		this.loanAmount = loanAmount;
		this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExp = totalExp;
		this.expCurrentDate = expCurrentDate;
		this.user = user;
	}

	public String getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long account_Number) {
		this.accountNumber = account_Number;
	}

	public String getHomeLoanAccountNumber() {
		return homeLoanAccountNumber;
	}

	public void setHomeLoanAccountNumber(String homeLoanAccountNumber) {
		this.homeLoanAccountNumber = homeLoanAccountNumber;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAccount) {
		this.loanAmount = loanAccount;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	public int getExpCurrentDate() {
		return expCurrentDate;
	}

	public void setExpCurrentDate(int expCurrentDate) {
		this.expCurrentDate = expCurrentDate;
	}

}
