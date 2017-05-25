import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cts.demo.bo.AccountBO;
import com.cts.demo.entity.Account;

public class TestAccount {
	AccountBO bo;
	
	@Before
	public void setup(){
		bo = new AccountBO();
	}

	@Test
	public void testDeposit() {
		int id = 1;
		double amount = 2300;
		boolean result = bo.deposit(id, amount);
		assertTrue(result);
	}
//	@Test
	public void addAccount() {
		Account account = new Account(50000, "Ravi");
		bo.add(account);
		assertTrue(true);
	}

}
