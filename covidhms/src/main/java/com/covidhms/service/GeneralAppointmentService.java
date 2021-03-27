package com.covidhms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidhms.model.GeneralAppointment;
import com.covidhms.repository.GeneralAppointmentRepository;

@Service
public class GeneralAppointmentService {
	
	@Autowired
	private GeneralAppointmentRepository repo;
	
	public GeneralAppointment saveAppointment(GeneralAppointment appointment) {
		return repo.save(appointment);
	}

	
	
	public List<GeneralAppointment> getAllGeneralAppointment() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	public void deleteAppointmentById(int id) {
		GeneralAppointment entity = repo.getOne(id);
		repo.delete(entity);
	}
	
	
	
}
