package com.cognizant.controller;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.Employee;
import com.cognizant.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	private List<Employee> employees;
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public String getEmployee(@ModelAttribute("employee") @Valid Employee employee,
			BindingResult result, Model model){
		
		return "employee";
	}
	
	
	@RequestMapping(value="/employees",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<Employee> getEmployees(@RequestParam("name") String name){
		
		Employee emp1 = new Employee(name, 34344.44);
		Employee emp2 = new Employee("Priya", 35455.00);
		employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		return employees;
	}
	

	
	
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
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String saveOrUpdateEmployee(
		@ModelAttribute("employee") @Valid Employee employee,
		BindingResult result, 
		Model model) {
		
		System.out.println(employee);
		employees = new ArrayList<>();	
		employees.add(employee);
		
//		EmployeeValidator validator = new EmployeeValidator();
		
//		 Set<ConstraintViolation<Object>> constraintViolations = validator.validate(employee, result);
		 
		        

		
//		new EmployeeValidator().validate(employee, result);
		try {
			service.addEmployees(employees);
		} 
		catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while(iterator.hasNext()){
				ConstraintViolation<?> next = iterator.next();
				System.out.println("Validation message: "+next.getMessage());
				System.out.println("Invalid field: "+next.getPropertyPath());
				System.out.println("Validation class/bean: "+next.getRootBean());
//				 result.reject(next.getPropertyPath(), next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
//				result.rejectValue(arg0, arg1, arg2);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("m1", employee.getName());

		if (result.hasErrors()) {
			return "employee";
		} 
		
		return "member";

	}

}
