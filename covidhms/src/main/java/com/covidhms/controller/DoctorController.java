package com.covidhms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covidhms.model.Doctor;
import com.covidhms.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService service;
	
	
	@PostMapping("/registerdoctor")
	@CrossOrigin(origins ="http://localhost:4200")
	public Doctor registerDoctor(@RequestBody Doctor doctor) throws Exception {
		
		String tempEmailId = doctor.getDoctorEmail();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			Doctor doctorobj = service.fetchDoctorByDoctorEmail(tempEmailId);
			if(doctorobj != null) {
				throw new Exception("Doctor with "+tempEmailId+" is already exist!");
			}
		}
		Doctor doctorObj=null;
		doctorObj = service.saveDoctor(doctor);
		return doctorObj;
	}
	
	@PostMapping("/logindoctor")
	@CrossOrigin(origins ="http://localhost:4200")
	public Doctor loginDoctor(@RequestBody Doctor doctor) throws Exception{
		String tempEmailId = doctor.getDoctorEmail();
		String tempPass = doctor.getPassword();
		Doctor doctorObj = null;
		if(tempEmailId != null && tempPass != null) {
			doctorObj = service.fetchDoctorByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(doctorObj == null) {
			throw new Exception("Bad Credentials!");
		}
		return doctorObj;
	}
	
	
}
