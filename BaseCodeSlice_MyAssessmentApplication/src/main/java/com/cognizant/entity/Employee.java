package com.cognizant.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
//	@javax.validation.constraints.
	@NotNull
    @Size(min=2, max=30)
	private String name;
	
	@Min(value=5000)
	private double salary;
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "EMPLOYEE_INC", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "INC_ID") })
//	private Set<Increment> increments = new HashSet<Increment>(0);
//	private Set<Increment> increments;
	private List<Increment> increments = new ArrayList<Increment>(0);

	public Employee(){ }

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Increment> getIncrements() {
		return increments;
	}

	public void setIncrements(List<Increment> increments) {
		this.increments = increments;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}


	
}
