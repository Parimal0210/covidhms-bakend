package com.covidhms.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

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
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm a")
	//private LocalDateTime time;
	
	private int adultCount;
	private int childCount;
	private int patientId;
	
	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Vaccine(int id, Date date, int adultCount,int childCount,int patientId) {
		super();
		this.id = id;
		this.date = date;
		//this.time = time;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.patientId = patientId;
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
	
	
	/*public LocalDateTime getTime() {
		return time;
	}



	public void setTime(LocalDateTime time) {
		this.time = time;
	}*/
	
	
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
	
	
}
