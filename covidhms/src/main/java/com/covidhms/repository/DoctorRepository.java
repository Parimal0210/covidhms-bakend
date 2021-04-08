package com.covidhms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.covidhms.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	
	public Doctor findByDoctorEmail(String doctorEmail);
	public Doctor findByDoctorEmailAndPassword(String email, String password);
	public List<Doctor> findAll();

}
