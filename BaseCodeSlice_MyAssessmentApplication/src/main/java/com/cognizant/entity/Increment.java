package com.cognizant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

@XmlRootElement
@Entity
public class Increment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Employee employee;

	private double amount;
	
	public Increment(){}
	
	public Increment(double amount){
		this.amount = amount;
	}
			
	public Increment(Employee employee, double amount) {
		super();
		this.employee = employee;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Increment [id=" + id + ", employee=" + employee + ", amount="
				+ amount + "]";
	}


}
