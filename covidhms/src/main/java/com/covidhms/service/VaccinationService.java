package com.covidhms.service;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.covidhms.model.GeneralAppointment;
import com.covidhms.model.User;
import com.covidhms.model.Vaccine;
import com.covidhms.repository.RegistrationRepository;
import com.covidhms.repository.VaccinationRepository;

@Service
public class VaccinationService {

	@Autowired
	private VaccinationRepository repo;
	
	@Autowired
	private RegistrationRepository regRepo;
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	public Vaccine saveVaccine(Vaccine v) {
		return repo.save(v);
	}
	
	
	public List<Vaccine> getAllVaccineAppointment() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

	
	/*public Vaccine fetchUserByDateAndTime(Date date, LocalDateTime time) {
		return repo.findByDateAndTime(date, time);
	}*/
	public void deleteVaccineAppointmentById(int id) throws Exception {

		//int patientId = repo.findById(id).getPatientId();		
		Vaccine entity = repo.getOne(id);
		repo.delete(entity);
	}

	
	public Vaccine fetchUserByDate(Vaccine v) {
		return repo.findByDateOfPatient(v.getDate(),v.getPatientId());
	}
	
	public List<Vaccine> getAllVaccineAppointmentOfId(int id) {
		// TODO Auto-generated method stub
		return repo.findAllById(id);
	}
	
	public String confirmationAppointment(Vaccine v,boolean flag) throws Exception {
		System.out.println("In confirm appointment 2");
		Date d = v.getDate();
		int id = v.getPatientId();
		String email = regRepo.findById(id).getEmailId();
		System.out.println("email: "+email);
		System.out.println("Time: "+v.getTime());
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String timeString = v.getTime().format(formatter);
		Date tpTime = Date.valueOf(timeString);
		String strDateFormat = "hh:mm a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(tpTime);
	    System.out.println("Time: "+formattedDate);*/
	    
	    
		if(flag){
			smtpMailSender.send(email, "Mail for Vaccination appointment", "Congratulations!!! Your vaccination appointment is scheduled on "+d+" !!");
			return "Approved !!!";
		}else
			return "Not approved ! Try again !!";
	}
}
