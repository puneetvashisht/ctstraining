package com.cognizant.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.EmployeeDAO;
import com.cognizant.entity.Employee;
import com.cognizant.entity.Increment;


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

//	@Transactional
	public Employee incrementSalary(int id, double amount) throws Exception {
		
		Employee emp =  employeeDAO.incrementSalary(id, amount);
		
		return emp;
	}

	public List<Increment> incrementList(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.incrementList(id);
	}

}
