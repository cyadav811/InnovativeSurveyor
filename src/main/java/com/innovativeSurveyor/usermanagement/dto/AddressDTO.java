package com.innovativeSurveyor.usermanagement.dto;

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
public class AddressDTO {
	private String keytail;
	private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country; 

}
