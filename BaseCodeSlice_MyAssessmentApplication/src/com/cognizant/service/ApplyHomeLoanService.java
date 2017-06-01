package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ApplyHomeLoanDAO;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;

@Component
@Transactional
public class ApplyHomeLoanService {
	@Autowired
	ApplyHomeLoanDAO homeLoanDao;
	@Autowired
	UserDetails user;
	public long insertHomeLoanDetails(HomeLoanDetails homeLoan)
	{
		long time = System.nanoTime();
		Random rd = new Random();
		int i= rd.nextInt(10);
		String random= Integer.toString(i);
		String timeInString1 = Long.toString(time);
		StringBuffer sb = new StringBuffer();
	    sb.append(timeInString1).append(random);
	    String sb2 = sb.toString();
		homeLoan.setHomeLoanAccountNumber(sb2);
		
		
		
		StringBuffer sb3 = new StringBuffer();
		long accountNumber = homeLoan.getAccountNumber();
		String account = Long.toString(accountNumber);
		String lastThreeDigit = account.substring(13, 16);
		sb3.append("HL").append("-").append(lastThreeDigit);
		String loanId = sb3.toString();
		homeLoan.setHomeLoanId(loanId);
		//System.out.println(loanId);
		//System.out.println(sb2);
		
		
		
		UserDetails ud = homeLoanDao.gettHomeLoanUserDetails(accountNumber);
		List list = new ArrayList();
		list.add(homeLoan);
		ud.setHomeloan(list);
		return 3l;
	}

}
