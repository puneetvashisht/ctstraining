package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Employee;

import test.java.TestEmployee;



@Component
public class EmployeeDAO {
	
	static Logger logger = Logger.getLogger(EmployeeDAO.class);
    @PersistenceContext
    private EntityManager em;

    @Transactional
	public void addEmployee(Employee emp) {
		//session.save() - em.persist()
		em.persist(emp);
		
	}

	public List<Employee> findEmployeesBySalary(double salary) {
		Query query = em.createQuery("from Employee e where e.salary < ?");
		query.setParameter(1, salary);
		List<Employee> employees = query.getResultList();
		return employees;
	}

//	@Transactional
	public Employee incrementSalary(int id, double amount) {
		logger.warn("Id is : " + id);
		Employee employee = em.find(Employee.class, id);
		logger.debug(employee);
		employee.setSalary(employee.getSalary() + amount);
		return employee;
	}

}
