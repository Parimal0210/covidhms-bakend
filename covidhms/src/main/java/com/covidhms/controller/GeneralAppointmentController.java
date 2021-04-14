package com.covidhms.controller;

import java.util.List;

import javax.transaction.Transactional;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.covidhms.model.GeneralAppointment;
import com.covidhms.service.GeneralAppointmentService;

@RestController
public class GeneralAppointmentController {

	@Autowired
	private GeneralAppointmentService service;
	
	@PostMapping("/generalappointment")
	@CrossOrigin(origins ="http://localhost:4200")
	public GeneralAppointment registerUser(@RequestBody GeneralAppointment appointment) throws Exception {
	
		GeneralAppointment userObj=null;
		userObj = service.saveAppointment(appointment);
		return userObj;
	}
	
	@GetMapping("/approveAppointment/{patientId}")
	@CrossOrigin(origins ="http://localhost:4200")
	public String approveAppointment(@PathVariable int patientId) throws Exception {
	
		System.out.println("In app mail pid = "+patientId);
		service.testAppointmentMail(patientId);
		return "Good";
	}
	
	
	@GetMapping("/pendingappointment")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<GeneralAppointment> getAllGeneralAppointment(GeneralAppointment ga){
		return service.getAllGeneralAppointment();
	}
	
	
	
	
	
	
	@DeleteMapping("/deleteappointment/{id}")
	@CrossOrigin(origins ="http://localhost:4200")
	public ResponseEntity<HttpStatus> deleteAppointmentById(@PathVariable int id){
		try {
			this.service.deleteAppointmentById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@DeleteMapping("/cancelappointment/{patientId}")
	@CrossOrigin(origins ="http://localhost:4200")
	public ResponseEntity<HttpStatus> deleteByPatientId(@PathVariable int patientId){
		try {
			System.out.println(patientId);
			this.service.deleteByPatientId(patientId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getTestAppointmentInfo/{patientId}")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<GeneralAppointment> getAllGeneralAppointment(@PathVariable int patientId){
		return service.getAllGeneralAppointmentOfId(patientId);
	}
	
	

	

	@GetMapping("/patientidappointment/{patientId}")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<GeneralAppointment> getAllGeneralAppointmentOfPatientId(@PathVariable int patientId){
		return service.getAllGeneralAppointmentOfPatientId(patientId);
	}
	
	
	
	
}

