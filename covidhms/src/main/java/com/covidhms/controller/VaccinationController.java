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
	
	@PostMapping("/vaccinationRegister")
	@CrossOrigin(origins ="http://localhost:4200")
	public Vaccine registerVaccineAppointment(@RequestBody Vaccine v) throws Exception {
		
		Date d = v.getDate();
		//LocalDateTime t = v.getTime();
		//System.out.println("Time "+t);
		if(d != null ) {
			Vaccine vacdate = service.fetchUserByDate(d);
			if(vacdate != null)
			{
				flag=false;
				
				//System.out.println("Appointment on "+d+" is already exist!");
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
		if(flag) {
			Vaccine vObj=null;
			vObj = service.saveVaccine(v);
			return vObj;
		}else {
			flag=true;
			throw new Exception("Appointment on "+d+" is already exist!");
		}
	}
	
	@GetMapping("/getVaccineAppointmentInfo/{patientId}")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<Vaccine> getAllVaccineAppointment(@PathVariable int patientId){
		return service.getAllVaccineAppointmentOfId(patientId);
	}
	
	
	@CrossOrigin(origins ="http://localhost:4200")
	@PostMapping("/vaccination")
	public String confirmAppointment(@RequestBody Vaccine v) throws Exception{
		System.out.println("In confirm appointment 1");
		return service.confirmationAppointment(v,flag);
	}
}
