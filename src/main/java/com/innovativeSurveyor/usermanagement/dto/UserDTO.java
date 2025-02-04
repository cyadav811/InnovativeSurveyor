package com.innovativeSurveyor.usermanagement.dto;

import java.util.List;

public class UserDTO {
	
	private String id;
    private String username;
    private String password;
    private String role; // "SURVEYOR", "BROKER", "UNDERWRITER", "EMPLOYEE"
    private NameDTO name;
    private String email;
    private String tempEmail;
    private String mobileNumber;
    private String tempMobileNumber;
    private AddressDTO perAddress;
    private AddressDTO tempAddress;

}
