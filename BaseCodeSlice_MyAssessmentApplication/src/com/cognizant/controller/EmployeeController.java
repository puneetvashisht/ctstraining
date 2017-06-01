package com.cognizant.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.entity.Employee;
import com.cognizant.exception.ApplicationException;
import com.cognizant.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	private List<Employee> employees;
	
	public EmployeeController() {
		super();
	}

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String addMember(Model model){
		model.addAttribute("m1", "Kumar");
		return "member";		
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addMember(@RequestParam("name") String name, Model model){
		employees = new ArrayList<Employee>();
		Employee emp = new Employee(name, 3434.2);
		employees.add(emp);
		try {
			service.addEmployees(employees);
			model.addAttribute("m1", name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member";
	}
	
//	http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/add2?name=jagga
	@RequestMapping(value="/add2", method=RequestMethod.GET)
	public String addEmp(
			@RequestParam("name") String name, 
//			@RequestParam("email") String email, 
//			@RequestParam("salary") double salary, 
//			@RequestParam("age") int age, 
//			@RequestParam("joiningDate") Date joiningDate, 

			Model model){
		employees = new ArrayList<Employee>();
		
		String email = "jagga@gmail.com";
		double salary = 360000.0;
		int age = 25;

		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmail(email);
		emp.setSalary(salary);
		emp.setAge(age);

		employees.add(emp);
		try {
			service.addEmployees(employees);
			model.addAttribute("m1", name);
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while(iterator.hasNext()){
				ConstraintViolation<?> next = iterator.next();
				System.out.println("Validation message: "+next.getMessage());
				System.out.println("Invalid field: "+next.getPropertyPath());
				System.out.println("Validation class/bean: "+next.getRootBean());
			}
			e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}

		return "member";
	}
	
	
}


/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.entity.Employee;
import com.cognizant.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	private List<Employee> employees;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addMember(@RequestParam("name") String name, Model model){
		employees = new ArrayList<>();
		Employee emp = new Employee(name, 3434.2);
		employees.add(emp);
		try {
			service.addEmployees(employees);
			model.addAttribute("m1", name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "member";
	}

}
*/