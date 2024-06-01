package com.techietact.mycognitiv.candidate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.techietact.mycognitiv.candidate.annotation.Age;
import com.techietact.mycognitiv.candidate.annotation.MobileNumber;
import com.techietact.mycognitiv.candidate.annotation.UniqueEmail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CandidateModel extends AuditableModel {

	private static final long serialVersionUID = 6205305264083330343L;

	private long candidateId ; 
	
	@NotBlank(message = "Name is required",groups= {ValidCreation.class,ValidUpdation.class})
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces",groups= {ValidCreation.class,ValidUpdation.class})
	@Size(max = 25, message = "Name must be less than or equal to 25 characters",groups= {ValidCreation.class,ValidUpdation.class})
	private String name ; 
	
	@NotBlank(message = "Email is required",groups= {ValidCreation.class,ValidUpdation.class})
	@Email(message ="Invalid Email Address",groups= {ValidCreation.class,ValidUpdation.class})
	@Size(max = 50 , message = "Email must be less than or equal to 50 characters",groups= {ValidCreation.class,ValidUpdation.class})
	@UniqueEmail(groups = ValidCreation.class)
	private String email ;
	
	@NotBlank(message = "Password is required",groups=ValidCreation.class)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
    message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special symbol",
    groups = ValidCreation.class)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password ;
	
	@Age(groups= {ValidCreation.class,ValidUpdation.class})
	private int age;
	
	@MobileNumber(groups= {ValidCreation.class,ValidUpdation.class})
	private long mobileNumber;
	
	// Validation Groups :- 
	
	public interface ValidCreation {}
	
	public interface ValidUpdation {}
	
}
