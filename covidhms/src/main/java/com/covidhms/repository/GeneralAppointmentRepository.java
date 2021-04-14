package com.covidhms.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.covidhms.model.GeneralAppointment;

public interface GeneralAppointmentRepository extends JpaRepository<GeneralAppointment, Integer> {

	
	public List<GeneralAppointment> findAll();
	
	@Query("FROM GeneralAppointment where patientId = :id")
	public List<GeneralAppointment> findAllById(@Param("id")int id);
	
	@Query("SELECT appointmentDate FROM GeneralAppointment WHERE patientId = :id")
	public Date getDateByPatientId(@Param("id")int id);
	
	public GeneralAppointment getByPatientId(int patientId);
	
	public GeneralAppointment findById(int id);
	public GeneralAppointment deleteAppointmentById(int id);
	
	@Query("FROM GeneralAppointment where status = 'Pending'")
	public List<GeneralAppointment> findAllPending();
}
