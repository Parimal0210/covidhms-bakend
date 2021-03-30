package com.covidhms.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	
	/*public Vaccine fetchUserByDateAndTime(Date date, LocalDateTime time) {
		return repo.findByDateAndTime(date, time);
	}*/
	
	public Vaccine fetchUserByDate(Date date) {
		return repo.findByDate(date);
	}
	
	public ResponseEntity<String> confirmationAppointment(Vaccine v,boolean flag) throws Exception {
		System.out.println("In confirm appointment 2");
		Date d = v.getDate();
		int id = v.getPatientId();
		String email = regRepo.findById(id).getEmailId();
		System.out.println("email: "+email);
		
		if(flag){
			smtpMailSender.send(email, "Test mail from Spring", "Congratulations!!! Your vaccination appointment is scheduled on "+d+" !!");
			return ResponseEntity.ok("Approved !!!");
		}else
			return ResponseEntity.ok("Not approved ! Try again !!");
	}
}
