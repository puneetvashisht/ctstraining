package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.sms.SmsService;
@Component
public class PaymentsService {
	@Autowired
	PaymentsBO paymentsBO;
	
	@Autowired
	SmsService smsService;
	
	public void fundsTransfer(){
		paymentsBO.credit();
		paymentsBO.debit();
		paymentsBO.accountsEntry();
		smsService.sendSMS();
	}

}
