package com.covidhms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidhms.model.GeneralAppointment;

public interface GeneralAppointmentRepository extends JpaRepository<GeneralAppointment, Integer> {

	
	public List<GeneralAppointment> findAll();
	
	
	public GeneralAppointment deleteAppointmentById(int id);
}
