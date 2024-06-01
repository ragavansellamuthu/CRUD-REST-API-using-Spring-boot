package com.techietact.mycognitiv.candidate.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techietact.mycognitiv.candidate.entity.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {
	
	CandidateEntity findByCandidateIdAndIsDeletedFalse(long candidateId);

	CandidateEntity findAllByEmailAndIsDeletedFalse(String email);
	
	Page<CandidateEntity> findAllByIsDeletedFalse(Pageable pagebale);
	
	Page<CandidateEntity> findAllByNameContainingIgnoreCaseAndIsDeletedFalse(String name,Pageable pagebale);
	
}
