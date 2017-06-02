package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.bo.EmployeeBO;
import com.cognizant.entity.Employee;
import com.cognizant.entity.Increment;

@Component
public class EmployeeService {
	@Autowired
	EmployeeBO bo;

	public void addEmployees(List<Employee> employees) throws Exception {
		bo.addEmployees(employees);
		
	}

	public List<Employee> findEmployeesBySalary(double salary) {
		return bo.findEmployeesBySalary(salary);
	}

	public Employee incrementSalary(int id, double amount) throws Exception {
		return bo.incrementSalary(id, amount);
		
	}

	public List<Increment> incrementList(int id) {
		return bo.incrementList(id);
		
	}

}
