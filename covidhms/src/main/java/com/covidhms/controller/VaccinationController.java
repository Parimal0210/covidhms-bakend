package com.covidhms.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covidhms.model.GeneralAppointment;
import com.covidhms.model.Vaccine;
import com.covidhms.service.VaccinationService;

@RestController
public class VaccinationController {

	@Autowired
	private VaccinationService service;
		
	
	private boolean flag=true;
	
	@PostMapping("/vaccination")
	//@CrossOrigin(origins ="http://localhost:4200")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public Vaccine registerVaccineAppointment(@RequestBody Vaccine v) throws Exception {
		
		Date d = v.getDate();
		//LocalDateTime t = v.getTime();
		//System.out.println("Time "+t);
		if(d != null ) {
			Vaccine vacdate = service.fetchUserByDate(d);
			if(vacdate != null)
			{
				flag=false;
				throw new Exception("Appointment on "+d+" is already exist!");
			}
			/*if(vacdate != null)
			{
				Vaccine vac = service.fetchUserByDateAndTime(d, t);
				if(vac != null) {
					flag=false;
					throw new Exception("Appointment on "+d+" is already exist!");
				}
			}*/
		}
		
		Vaccine vObj=null;
		vObj = service.saveVaccine(v);
		return vObj;
	}
	
	
	//@CrossOrigin(origins ="http://localhost:4200")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@GetMapping("/vaccination/{v}")
	public String confirmAppointment(@PathVariable Vaccine v) throws Exception{
		System.out.println("In confirm appointment 1");
		return service.confirmationAppointment(v,flag);
	}
	
	
	@GetMapping("/vaccinependingappointments")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<Vaccine> getAllVaccineAppointment(Vaccine v){
		return service.getAllVaccineAppointment();
	}
}
