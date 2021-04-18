package com.covidhms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rooms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String roomType;
	private String status;
	
	
	
	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Rooms(int id, String roomType, String status) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getRoomType() {
		return roomType;
	}



	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Rooms [id=" + id + ", roomType=" + roomType + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
