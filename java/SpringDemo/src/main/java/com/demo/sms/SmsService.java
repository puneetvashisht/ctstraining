package com.demo.sms;

import org.springframework.stereotype.Component;

@Component

public class SmsService {
	public void sendSMS(){
		System.out.println("Sending SMS");
	}
}
