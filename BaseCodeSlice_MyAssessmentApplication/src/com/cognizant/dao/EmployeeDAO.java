package com.cognizant.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Employee;
import com.cognizant.entity.Increment;

import test.java.TestEmployee;

@Component
public class EmployeeDAO {

	static Logger logger = Logger.getLogger(EmployeeDAO.class);
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void addEmployee(Employee emp) {
		// session.save() - em.persist()
		em.persist(emp);

	}

	public List<Employee> findEmployeesBySalary(double salary) {
		Query query = em.createQuery("from Employee e where e.salary < ?");
		query.setParameter(1, salary);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Transactional
	public Employee incrementSalary(int id, double amount) {
		// logger.warn("Id is : " + id);
		// Employee employee = em.find(Employee.class, id);
		// logger.debug(employee);
		// employee.setSalary(employee.getSalary() + amount);
		// return employee;

		// Set<Increment> increments = new HashSet<Increment>();
		// increments.add(new Increment(amount));
		// em.persist(increments);
		//
		// logger.warn("Id is : " + id);
		// Employee employee = em.find(Employee.class, id);
		// logger.debug(employee);
		// employee.setSalary(employee.getSalary() + amount);
		//
		// employee.setIncrements(increments);
		Employee employee = null;
		try {
			logger.warn("Id is : " + id);
			employee = em.find(Employee.class, id);
			
			List<Increment> increments = new ArrayList<Increment>();
			increments.add(new Increment(employee, amount));
			employee.setIncrements(increments);
			em.persist(employee);
			
			logger.debug(employee);
			employee.setSalary(employee.getSalary() + amount);

			logger.debug("hello");
			logger.debug(increments);
//			employee.setIncrements(increments);
		} catch (Exception e) {
			System.out.println(employee);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}

		// employeeDAO.addEmployee(emp);

		return employee;

	}

}
