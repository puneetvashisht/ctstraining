package com.cognizant.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.EmployeeDAO;
import com.cognizant.entity.Employee;


@Component
public class EmployeeBO {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	public void addEmployees(List<Employee> employees) throws Exception {
		for(Employee emp: employees){
			if(emp.getName()== null || emp.getName().trim().equals("")){
				throw new Exception("Invalid Input");
			}
			else{
				employeeDAO.addEmployee(emp);
			}
		}
		
	}

	public List<Employee> findEmployeesBySalary(double salary) {
		
		return employeeDAO.findEmployeesBySalary(salary);
	}

	@Transactional
	public Employee incrementSalary(int id, double amount) throws Exception {
		
		Employee emp =  employeeDAO.incrementSalary(id, amount);
		if(id==1)
			throw new RuntimeException("Id not supplied");
		return emp;
	}

}
