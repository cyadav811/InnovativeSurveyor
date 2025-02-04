package com.innovativeSurveyor.usermanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.innovativeSurveyor.usermanagement.dto.LoginRequest;
import com.innovativeSurveyor.usermanagement.dto.LoginResponse;
import com.innovativeSurveyor.usermanagement.entity.User;
import com.innovativeSurveyor.usermanagement.repository.UserRepository;

public interface LoginService {

	    @Autowired
	    private UserRepository userRepository;

	  //  @Autowired
	  //  private PasswordEncoder passwordEncoder;

	    @Autowired
	    private OtpService otpService;

	    public Optional<User> loginWithUsernameAndPassword(String username, String password) {
	        return userRepository.findByUsernameAndPassword(username, passwordEncoder.encode(password));
	    }

	    public Optional<User> loginWithEmailAndPassword(String email, String password) {
	        return userRepository.findByEmailAndPassword(email, passwordEncoder.encode(password));
	    }

	    public Optional<User> loginWithMobileNumberAndPassword(String mobileNumber, String password) {
	        return userRepository.findByMobileNumberAndPassword(mobileNumber, passwordEncoder.encode(password));
	    }

	    public Optional<User> loginWithUsernameAndOtp(String username, String otp) {
	        Optional<User> user = userRepository.findByUsername(username);
	        if (user.isPresent() && otpService.validateOtp(username, otp)) {
	            otpService.invalidateOtp(username);
	            return user;
	        }
	        return Optional.empty();
	    }

	    public Optional<User> loginWithEmailAndOtp(String email, String otp) {
	        Optional<User> user = userRepository.findByEmail(email);
	        if (user.isPresent() && otpService.validateOtp(email, otp)) {
	            otpService.invalidateOtp(email);
	            return user;
	        }
	        return Optional.empty();
	    }

	    public Optional<User> loginWithMobileNumberAndOtp(String mobileNumber, String otp) {
	        Optional<User> user = userRepository.findByMobileNumber(mobileNumber);
	        if (user.isPresent() && otpService.validateOtp(mobileNumber, otp)) {
	            otpService.invalidateOtp(mobileNumber);
	            return user;
	        }
	        return Optional.empty();
	    }
	}

}
