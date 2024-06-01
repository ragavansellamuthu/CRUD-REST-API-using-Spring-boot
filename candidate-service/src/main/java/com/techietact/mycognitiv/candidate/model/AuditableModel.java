package com.techietact.mycognitiv.candidate.model;

import java.util.Date;

import lombok.Data;

@Data
public abstract class AuditableModel {

	private boolean isDeleted ;
	
	private long createdBy ;
	
	private long modifiedBy ;
	
	private long deletedBy ;
	
	private Date createdAt ;
	
	private Date modifiedAt ;
	
	private Date deletedAt ;
	
}
