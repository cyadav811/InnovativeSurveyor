package com.innovativeSurveyor.usermanagement.entity;

import com.innovativeSurveyor.usermanagement.dto.AddressDTO;
import com.innovativeSurveyor.usermanagement.dto.NameDTO;


public class User {
	
	private String id;
    private String username;
    private String password;
    private String role; // "SURVEYOR", "BROKER", "UNDERWRITER", "EMPLOYEE"
    private NameDTO name;
    private String email;
    private String tempEmail;
    private String mobileNumber;
    private String tempMobileNumber;
    private Address perAddress;
    private Address tempAddress;
    
}
