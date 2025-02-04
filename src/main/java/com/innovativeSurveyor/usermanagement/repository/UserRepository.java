package com.innovativeSurveyor.usermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovativeSurveyor.usermanagement.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
	
	    
	    Optional<User> findByUsernameAndPassword(String username, String password);
	    Optional<User> findByEmailAndPassword(String email, String password);
	    Optional<User> findByMobileNumberAndPassword(String mobileNumber, String password);
	    Optional<User> findByUsernameAndOtp(String username, String otp);
	    Optional<User> findByEmailAndOtp(String email, String otp);
	    Optional<User> findByMobileNumberAndOtp(String mobileNumber, String otp);
		Optional<User> findByUsername(String username);
		Optional<User> findByEmail(String email);
		Optional<User> findByMobileNumber(String mobileNumber);
	}
