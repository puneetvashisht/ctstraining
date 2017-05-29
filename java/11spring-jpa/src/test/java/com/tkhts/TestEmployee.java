package com.tkhts;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tkhts.entity.Employee.Employee;
import com.tkhts.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestEmployee {
	
	@Autowired
	EmployeeService service;
	private List<Employee> employees;
	
	@Before
	public void setup(){
		Employee emp1 = new Employee("Ravi", 34344.44);
		Employee emp2 = new Employee("Priya", 35455.00);
		employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
	}
//	@Test
	public void addEmployees(){
		try {
			service.addEmployees(employees);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not supplied valid name");
		}
	}
	
//	@Test(expected=Exception.class)
	public void addEmployeesWithNamesEmpty() throws Exception{
		for(Employee emp: employees){
			emp.setName("");
		}		
		service.addEmployees(employees);	
	}
//	@Test
	public void testSalariesLessThanLimit(){
		List<Employee> employees = service.findEmployeesBySalary(35000);
//		employees.size()
		System.out.println(employees);
		assertEquals(employees.size(), 1);
	}
	@Test
	public void testSalaryIncrement(){
		double amount = 5000;
		Employee updatedEmp;
		try {
			updatedEmp = service.incrementSalary(1, amount);
			System.out.println(updatedEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		assertSame(updatedEmp.getSalary(),54344.44);
//		assertEquals(updatedEmp.getSalary(), 59344.44);
//		assertEquals(updatedEmp.getSalary(), employees.get(0).getSalary()+ amount);
	}

}
