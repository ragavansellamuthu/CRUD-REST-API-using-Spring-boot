package com.techietact.mycognitiv.candidate.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity implements Serializable {

	private static final long serialVersionUID = 5578905690385385817L;

	@Column(name = "is_deleted", nullable = false)
	private boolean isDeleted;

	@Column(name = "created_by", nullable = false)
	private long createdBy;

	@Column(name = "modified_by", nullable = false)
	private long modifiedBy;

	@Column(name = "deleted_by", nullable = false)
	private long deletedBy;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "modified_at")
	private Date modifiedAt;

	@Column(name = "deleted_at")
	private Date deletedAt;

    @PreUpdate
    public void preUpdate() {
    	if(this.isDeleted) {
    		this.deletedAt = new Date();
    	} else {
            this.modifiedAt = new Date();
    	}
    }
}
