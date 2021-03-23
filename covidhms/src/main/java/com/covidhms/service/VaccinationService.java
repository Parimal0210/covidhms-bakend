package com.covidhms.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidhms.model.User;
import com.covidhms.model.Vaccine;
import com.covidhms.repository.VaccinationRepository;

@Service
public class VaccinationService {

	@Autowired
	private VaccinationRepository repo;
	
	public Vaccine saveVaccine(Vaccine v) {
		return repo.save(v);
	}
	
	/*public Vaccine fetchUserByDateAndTime(Date date, LocalDateTime time) {
		return repo.findByDateAndTime(date, time);
	}*/
	
	public Vaccine fetchUserByDate(Date date) {
		return repo.findByDate(date);
	}
}
