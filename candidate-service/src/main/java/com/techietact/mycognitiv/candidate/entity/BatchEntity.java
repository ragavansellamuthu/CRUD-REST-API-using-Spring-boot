package com.techietact.mycognitiv.candidate.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="batch")
@Data
@EqualsAndHashCode(callSuper=false)
public class BatchEntity extends AuditableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id",insertable = false,updatable = false)
	private int batchId ;
	
	@Column(name="batch_name",nullable=false,length=30)
	private String batchName ; 
	
	@Column(name="description")
	private String description ;
	
	@Column(name="start_date",nullable=false)
	private Date startDate ;
	
	@Column(name="end_date",nullable=false)
	private Date endDate ;
	
	@Column(name="size",nullable=false)
	private int size ;
	
	@Column(name="capacity",nullable=false)
	private int capacity ;
	
	@Column(name="status",nullable=false)
	private String status ;
	
	@Column(name="is_available",nullable=false)
	private boolean isAvailable ;
	
}
