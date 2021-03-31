package com.covidhms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String patientName;
	private String patientDescription;
	private int totalAmount;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int id, String patientName, String patientDescription, int totalAmount) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.patientDescription = patientDescription;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientDescription() {
		return patientDescription;
	}

	public void setPatientDescription(String patientDescription) {
		this.patientDescription = patientDescription;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", patientName=" + patientName + ", patientDescription=" + patientDescription
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	
	
}
