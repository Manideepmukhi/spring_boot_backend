package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	@Column(name="fisrt_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="Email_ID")
	private String EmailId;
	public Employee()
	{
		
	}
	public Employee(String firstname, String lastname, String emailId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		EmailId = emailId;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	

}
