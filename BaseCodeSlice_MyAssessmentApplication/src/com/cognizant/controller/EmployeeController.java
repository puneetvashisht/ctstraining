package com.cognizant.controller;



import java.util.ArrayList;
import java.util.List;

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
