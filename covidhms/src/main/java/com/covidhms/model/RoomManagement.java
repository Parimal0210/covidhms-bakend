package com.covidhms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomManagement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int patientId;
	private String patientName;
	private int roomNo;
	private Date admitDate;
	
	
	public RoomManagement() {
		super();
	}
	
	
	
	public RoomManagement(int id, int patientId, String patientName, int roomNo, Date admitDate) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.patientName = patientName;
		this.roomNo = roomNo;
		this.admitDate = admitDate;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public int getRoomNo() {
		return roomNo;
	}



	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}



	public Date getAdmitDate() {
		return admitDate;
	}



	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}



	@Override
	public String toString() {
		return "RoomManagement [id=" + id + ", patientId=" + patientId + ", patientName=" + patientName + ", roomNo="
				+ roomNo + ", admitDate=" + admitDate + "]";
	}
	
	
	
}
