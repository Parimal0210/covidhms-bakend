package com.covidhms.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.covidhms.model.GeneralAppointment;

public interface GeneralAppointmentRepository extends JpaRepository<GeneralAppointment, Integer> {

	
	public List<GeneralAppointment> findAll();
	
	@Query("FROM GeneralAppointment where patientId = :id")
	public List<GeneralAppointment> findAllById(@Param("id")int id);
	
	//@Query("FROM GeneralAppointment where patientId = :id")
	
	
	public GeneralAppointment findById(int id);
	public GeneralAppointment deleteAppointmentById(int id);
	
	
	public List<GeneralAppointment> findAllByPatientId(int patientId);
	public GeneralAppointment findByPatientId(int patientId);	 
	@Transactional
	void deleteByPatientId(int patientId);
}
