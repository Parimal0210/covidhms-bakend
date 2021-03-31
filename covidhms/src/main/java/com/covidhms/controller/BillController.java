package com.covidhms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covidhms.model.Bill;
import com.covidhms.model.GeneralAppointment;
import com.covidhms.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService service;
	
	@PostMapping("/bill")
	@CrossOrigin(origins ="http://localhost:4200")
	public Bill saveBill(@RequestBody Bill bill) throws Exception {
		
		
		Bill billObj=null;
		billObj = service.saveB(bill);
		return billObj;
	}
	
	@GetMapping("/billhistory")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<Bill> getAllBills(Bill b){
		return service.getAllBills();
	}

}
