package com.techietact.mycognitiv.candidate.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public abstract class AuditableModel implements Serializable{

	private static final long serialVersionUID = -1861321136069192344L;

	private boolean isDeleted ;
	
	private long createdBy ;
	
	private long modifiedBy ;
	
	private long deletedBy ;
	
	private Date createdAt ;
	
	private Date modifiedAt ;
	
	private Date deletedAt ;
	
}
