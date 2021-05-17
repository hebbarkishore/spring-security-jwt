package com.org.data.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
 
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String empNo;
    private String empName;
    private String position;
 
    public Employee() {
 
    }

	public Employee(String empNo, String empName, String position) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.position = position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}    
	
	
 
}