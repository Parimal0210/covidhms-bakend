package com.covidhms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.covidhms.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{

	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String email, String password);
}
