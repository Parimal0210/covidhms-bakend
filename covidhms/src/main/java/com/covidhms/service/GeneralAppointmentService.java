package com.covidhms.service;

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
		return repo.findAll();
	}
	
	public List<GeneralAppointment> getAllGeneralAppointmentOfId(int id) {
		// TODO Auto-generated method stub
		return repo.findAllById(id);
	}
	
	public List<GeneralAppointment> getAllGeneralAppointmentOfPatientId(int patientId) {
		// TODO Auto-generated method stub
		return repo.findAllByPatientId(patientId);
	}

	
	public void deleteAppointmentById(int id) throws Exception {

		int patientId = repo.findById(id).getPatientId();
		System.out.println("ID: "+patientId);
		String email = regRepo.findById(patientId).getEmailId();
		
		smtpMailSender.send(email, "Mail for Covid-19 Test appointment","Congratulations!!! As per your response to the questionnaire,\n You don't need to take the Covid-19 Test. Just take the following precautions :\n Keep Social Distancing\n Wear Mask Regularly\n Use Sanitizer !!");

		
		GeneralAppointment entity = repo.getOne(id);
		repo.delete(entity);
	}
	
	

	
	public void deleteByPatientId(int patientId) throws Exception {
		repo.deleteByPatientId(patientId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void testAppointmentMail(int patientId) throws Exception {
		
		System.out.println("ID: "+patientId);
		String email = regRepo.findById(patientId).getEmailId();
		System.out.println("email: "+email);
		
		smtpMailSender.send(email, "Mail for Covid-19 Test appointment","Congratulations!!! Your Covid-19 Test appointment is Confirmed you can visit our hospital at any time on Mon-Sat between 10:00 AM To 07:00 PM !!");
	}
	
}
