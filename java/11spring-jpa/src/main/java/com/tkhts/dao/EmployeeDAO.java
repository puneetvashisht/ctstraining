package com.tkhts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tkhts.entity.Employee.Employee;


@Component
public class EmployeeDAO {
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
		System.out.println("Id is : " + id);
		Employee employee = em.find(Employee.class, id);
		System.out.println(employee);
		employee.setSalary(employee.getSalary() + amount);
		return employee;
	}

}
