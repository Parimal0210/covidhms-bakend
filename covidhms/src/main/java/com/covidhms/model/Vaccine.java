package com.covidhms.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private Date date;
	
	@JsonFormat(pattern="HH:mm")
	private LocalTime time;
	
	private int adultCount;
	private int childCount;
	private int patientId;
	private String patientName;
	
	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Vaccine(int id, Date date,LocalTime time, int adultCount,int childCount,int patientId,String patientName) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.patientId = patientId;
		this.patientName = patientName;
	}
	
	
	//getters and setters
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public LocalTime getTime() {
		return time;
	}



	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	public int getAdultCount() {
		return adultCount;
	}



	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}
	
	
	
	public int getChildCount() {
		return childCount;
	}


	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	

	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	

	
	public String getPatientName() {
		return patientName;
	}


	public void setPatientId(String patientName) {
		this.patientName = patientName;
	}

}
