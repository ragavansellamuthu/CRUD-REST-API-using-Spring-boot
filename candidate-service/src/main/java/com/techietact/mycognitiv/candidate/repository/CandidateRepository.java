package com.techietact.mycognitiv.candidate.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techietact.mycognitiv.candidate.entity.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {
	
	CandidateEntity findAllByEmailAndIsDeletedFalse(String email);
	
	CandidateEntity findByCandidateIdAndIsDeletedFalse(long candidateId);
	
	List<CandidateEntity> findAllByIsDeletedFalse(Sort sort);
	
	Page<CandidateEntity> findAllByIsDeletedFalse(Pageable pagebale);
	
	Page<CandidateEntity> findAllByNameContainingIgnoreCaseAndIsDeletedFalse(String name,Pageable pagebale);
	
}
