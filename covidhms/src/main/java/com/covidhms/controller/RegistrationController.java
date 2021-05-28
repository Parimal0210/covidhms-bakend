package com.covidhms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covidhms.model.User;
import com.covidhms.service.RegistrationService;


@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins ="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if(userobj != null) {
				throw new Exception("User with "+tempEmailId+" is already exist!");
			}
		}
		User userObj=null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	
	@PostMapping("/login")
	@CrossOrigin(origins ="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception{
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if(tempEmailId != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj == null) {
			throw new Exception("Bad Credentials!");
		}
		return userObj;
		
	}
	
	
	@GetMapping("/allpatient")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<User> getAllPatient(User user){
		return service.getAllPatient();
	}
	
	
	
	
	
}
