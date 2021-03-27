package com.covidhms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String doctorName;
	private String doctorEmail;
	private String doctorDegree;
	private String password;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int id, String doctorName, String doctorEmail, String doctorDegree, String password) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.doctorEmail = doctorEmail;
		this.doctorDegree = doctorDegree;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorDegree() {
		return doctorDegree;
	}

	public void setDoctorDegree(String doctorDegree) {
		this.doctorDegree = doctorDegree;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorName=" + doctorName + ", doctorEmail=" + doctorEmail + ", doctorDegree="
				+ doctorDegree + ", password=" + password + "]";
	}
	
	
	
	

}
