package com.covidhms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covidhms.model.RoomManagement;
import com.covidhms.model.Rooms;
import com.covidhms.service.RoomService;





@RestController
public class RoomController {

	
	@Autowired
	private RoomService service;
	
	
	@PostMapping("/confirmAddRoom")
	@CrossOrigin(origins ="http://localhost:4200")
	public String confirmAddNewRoom(@RequestBody Rooms r) throws Exception {
		
		service.addNewRoom(r);
		return "Room added!!";
	}
	
	@PostMapping("/confirmBed")
	@CrossOrigin(origins ="http://localhost:4200")
	public String confirmAddNewRoom(@RequestBody RoomManagement rm) throws Exception {
		
		service.addNewBed(rm);
		return "Room added!!";
	}
	
	
	@GetMapping("/getRoomNumbers/{type}")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<Rooms> getAllRoomNumbers(@PathVariable String type) throws Exception {
		
		return service.getRoomNumbers(type);
	}
	
	
	@GetMapping("/getRoomInfo")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<Rooms> getAllRoomInfo() throws Exception {
		
		return service.getRoomInfo();
	}
	
	
	@GetMapping("/getRoomStatusInfo")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<RoomManagement> getAllRoomStatusInfo() throws Exception {
		
		return service.getRoomStatusInfo();
	}
	
	
	@DeleteMapping("/deleteBed/{id}")
	@CrossOrigin(origins ="http://localhost:4200")
	public ResponseEntity<HttpStatus> deleteAppointmentById(@PathVariable int id){
		try {
			this.service.deleteRoomById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getRoomInfoByPid/{patientId}")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<RoomManagement> getAllRoomsByPid(@PathVariable int patientId){
		return service.getAllRoomsOfPatientId(patientId);
	}
}
