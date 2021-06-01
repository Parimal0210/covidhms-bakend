package com.covidhms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String emailId;
	private String userName;
	private String phoneNumber;
	private String    dob;
	private String address;
	private String password;
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public User(int id, String emailId, String userName, String phoneNumber, String dob, String address,
			String password) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.address = address;
		this.password = password;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getDob() {
		return dob;
	}




	public void setDob(String dob) {
		this.dob = dob;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", userName=" + userName + ", phoneNumber=" + phoneNumber
				+ ", dob=" + dob + ", address=" + address + ", password=" + password + "]";
	}




	
	
	
	

}
