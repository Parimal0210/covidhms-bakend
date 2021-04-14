package com.covidhms.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidhms.model.GeneralAppointment;
import com.covidhms.repository.GeneralAppointmentRepository;
import com.covidhms.repository.RegistrationRepository;

@Service
public class GeneralAppointmentService {
	
	@Autowired
	private GeneralAppointmentRepository repo;
	
	@Autowired
	private RegistrationRepository regRepo;
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	public GeneralAppointment saveAppointment(GeneralAppointment appointment) {
		return repo.save(appointment);
	}

	
	
	public List<GeneralAppointment> getAllGeneralAppointment() {
		// TODO Auto-generated method stub
		return repo.findAllPending();
	}
	
	public List<GeneralAppointment> getAllGeneralAppointmentOfId(int id) {
		// TODO Auto-generated method stub
		return repo.findAllById(id);
	}
	
	public void deleteAppointmentById(int id) throws Exception {

		int patientId = repo.findById(id).getPatientId();
		System.out.println("ID: "+patientId);
		String email = regRepo.findById(patientId).getEmailId();
		
		
		smtpMailSender.send(email, "Mail for Covid-19 Test appointment","Congratulations!!! As per your response to the questionnaire,\n You don't need to take the Covid-19 Test. Just take the following precautions :\n Keep Social Distancing\n Wear Mask Regularly\n Use Sanitizer !!");

		
		GeneralAppointment entity = repo.getOne(id);
		repo.delete(entity);
	}
	
	public void testAppointmentMail(int patientId) throws Exception {
		
		System.out.println("ID: "+patientId);
		String email = regRepo.findById(patientId).getEmailId();
		System.out.println("email: "+email);
		repo.getByPatientId(patientId).setStatus("Approved");
		repo.save(repo.getByPatientId(patientId));
		System.out.println("Status : " +repo.getByPatientId(patientId).getStatus());
		Date d = repo.getDateByPatientId(patientId);
		System.out.println("Date: "+d);
		
		smtpMailSender.send(email, "Mail for Covid-19 Test appointment","Congratulations!!! Your Covid-19 Test appointment is scheduled on "+d+" !!");
	}
	
}
