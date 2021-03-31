package com.covidhms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidhms.model.Bill;
import com.covidhms.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository repo;
	
	public Bill saveB(Bill bill) {
		return repo.save(bill);
	}
	
	public List<Bill> getAllBills() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
