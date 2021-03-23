package com.covidhms.service;

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

}
