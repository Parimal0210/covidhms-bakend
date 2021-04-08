package com.covidhms.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidhms.model.Vaccine;

public interface VaccinationRepository extends JpaRepository<Vaccine, Integer>{
	
	public Vaccine findByDate(Date date);
	//public Vaccine findByDateAndTime(Date date, LocalDateTime time);
	
	public List<Vaccine> findAll();
	
	
}
