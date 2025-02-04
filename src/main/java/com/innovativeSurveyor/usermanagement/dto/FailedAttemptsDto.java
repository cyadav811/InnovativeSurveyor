package com.innovativeSurveyor.usermanagement.dto;

import java.time.LocalDateTime;

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
public class FailedAttemptsDto {
	private int retryCount;
	private int resendAttemptCount;
	private String type;
	private LocalDateTime lastFailedAttemptTime;;
	private LocalDateTime otpGeneratedTime;

}
