package com.covidhms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidhms.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

	public List<Bill> findAll();
}
