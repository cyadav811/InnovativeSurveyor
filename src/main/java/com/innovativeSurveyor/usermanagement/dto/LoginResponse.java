package com.innovativeSurveyor.usermanagement.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude (JsonInclude.Include.NON_NULL)
public class LoginResponse {

	private String customerid;
	private Boolean isLoginSuccess;
	private Boolean isUniqueCustId;
	private String message;
	private String loginType;
	private String status;
	private Boolean accountLocked;
	private Boolean isFirstTimeLogin;
	private Boolean mpinFlag;
	private Boolean touchIdFlag;
	private Boolean faceIdFlag;
	private LocalDateTime lastFailedAttemptTime;
}
