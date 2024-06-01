package com.techietact.mycognitiv.candidate.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="candidate")
@Data
@EqualsAndHashCode(callSuper=false)
public class CandidateEntity extends AuditableEntity implements Serializable{

	private static final long serialVersionUID = 1177176105056996641L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long candidateId;

	@Column(name="name",nullable=false,length=25)
	private String name;

	@Column(name="email",nullable=false,length=50)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;

	@Column(name="age",nullable=false)
	private int age;

	@Column(name="mobile_number",nullable=false,length=10)
	private long mobileNumber;

}
