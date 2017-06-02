package com.tkhts;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tkhts.dao.PersonDaoImpl;
import com.tkhts.entity.Person;
import com.tkhts.exceptions.CommitException;

public class HelloServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");

		Person puneet = new Person("Puneet", "Vashisht");
		try {
			dao.save(puneet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
