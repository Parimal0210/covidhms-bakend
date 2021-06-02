package com.covidhms.repository;

import java.sql.Date;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.covidhms.model.Bill;
import com.covidhms.model.GeneralAppointment;
import com.covidhms.model.Vaccine;

public interface VaccinationRepository extends JpaRepository<Vaccine, Integer>{
	
	public Vaccine findByDate(Date date);
	//public Vaccine findByDateAndTime(Date date, LocalDateTime time);
	

	@Query("FROM Vaccine where patientId = :id")
	public List<Vaccine> findAllById(@Param("id")int id);

	public List<Vaccine> findAll();
	
	public Vaccine deleteVaccineAppointmentById(int id);
	
	@Query("FROM Vaccine where date = :date AND patientId = :patientId")
	public Vaccine findByDateOfPatient(Date date,int patientId);
}
