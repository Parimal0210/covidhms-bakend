package com.covidhms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.covidhms.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

	public List<Bill> findAll();
	
	@Query("FROM Bill where patientId = :id")
	public List<Bill> findAllById(@Param("id")int id);
}
