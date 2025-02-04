package com.innovativeSurveyor.usermanagement.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {
	private String id;
	private String role;
	private String loginType;
	private String mobileNumber;
	private String emailId;
	private LocalDate dateOfBirth;
	private String deviceID;
	private boolean mobileNotificationFlag;
	private boolean whatsAppNotificationFlag;
	private boolean isNotificationFlag;

}
