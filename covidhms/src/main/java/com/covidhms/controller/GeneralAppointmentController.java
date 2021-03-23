package com.covidhms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
}

