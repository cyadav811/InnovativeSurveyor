package com.innovativeSurveyor.usermanagement.service;

import org.springframework.integration.core.MessagingTemplate;

public class Tester {
	
	public static void main(String[] args) {
		MessagingTemplate ms = new MessagingTemplate();
		OTPService otp = new OTPService(ms);
		otp.sendOtp("chandra");
	}

}
