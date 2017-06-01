package test.java;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.ApplyHomeLoanDAO;
import com.cognizant.entity.HomeLoanDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyHomeLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ApplyHomeLoanTest {
	
	@Autowired
	ApplyHomeLoanDAO homeLoan;
	@Autowired
	UserDetails ud;
	@Autowired
	HomeLoanDetails homeloandetails; 
	@Autowired
	ApplyHomeLoanService homeLoanService;
	

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	@Before
	public void setup(){
		Date d = new Date(0);
		 ud = new UserDetails(4161000100125568l,"Savings","Dalchand Sharma",5000.0);
		 homeloandetails = new HomeLoanDetails(4161000100125568l,200000l,d,1000000l,"CTS","PAT",3,1);
	}
	/*@Test
	public void applyHomeLoanUserDetailsTestMethod()
	{
		
		
		
		
	    
		homeLoan.applyHomeLoanUserDetails(ud);
		assertTrue(true);
	}*/
	@Test
	public void insertHomeLoanDetailsTest()
	{
		homeLoanService.insertHomeLoanDetails(homeloandetails);
		assertTrue(true);
	}
	

}
