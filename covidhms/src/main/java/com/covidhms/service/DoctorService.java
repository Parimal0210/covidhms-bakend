package com.covidhms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidhms.model.Doctor;
import com.covidhms.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository repo;
	
	
	public Doctor saveDoctor(Doctor doctor) {
		return repo.save(doctor);
	}
	
	public Doctor fetchDoctorByDoctorEmail(String email) {
		return repo.findByDoctorEmail(email);
	}
	
	public Doctor fetchDoctorByEmailIdAndPassword(String email, String password) {
		return repo.findByDoctorEmailAndPassword(email, password);
	}

}
