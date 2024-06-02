package com.techietact.mycognitiv.candidate.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;

import com.techietact.mycognitiv.candidate.model.CandidateModel;

public interface CandidateService {
	
	Boolean isDuplicateEmail (String email);
	
	Boolean isDuplicateEmail (long candidateId, String email);

	CandidateModel createCandidate (CandidateModel model);
	
	@Cacheable(value = "Candidate", key = "#candidateId")
	CandidateModel viewCandidate (long candidateId);
	
	@Caching(evict = {@CacheEvict(value = "Candidates", allEntries = true)},put = {@CachePut(value = "Candidate", key = "#model.candidateId")})
	CandidateModel updateCandidate (CandidateModel model);
	
	@Caching(evict = {@CacheEvict(value = "Candidates", allEntries = true),@CacheEvict(value = "Candidate", key = "#candidateId")})
	Boolean deleteCandidate (long candidateId , long deletedBy);
	
	@Cacheable(value = "Candidates", key = "{#pageIndex, #pageSize, #attributeName, #sortOrder, #searchText}")
	Page<CandidateModel> paginateCandidates (int pageIndex , int pageSize , String attributeName , String sortOrder , String searchText);

	@Cacheable(value = "Candidates")
	List<CandidateModel> listAllCandidates();

		
}
