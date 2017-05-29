package com.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class PaymentsTest {
//	@Autowired
//	PaymentsBO bo;
	
	@Autowired
	PaymentsService service;
	
	@Test
	public void testFundsTransfer(){
		service.fundsTransfer();
		assertTrue(true);
	}

	@Test
	public void test() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		bo = context.getBean("paymentsBO", PaymentsBO.class);
//		PaymentsBO bo = new PaymentsBO();
//		bo.credit();
		assertTrue(true);
	}

}
