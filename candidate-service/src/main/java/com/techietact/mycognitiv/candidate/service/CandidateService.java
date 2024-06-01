package com.techietact.mycognitiv.candidate.service;

import org.springframework.data.domain.Page;

import com.techietact.mycognitiv.candidate.model.CandidateModel;

public interface CandidateService {

	CandidateModel createCandidate (CandidateModel model);
	
	CandidateModel viewCandidate (long candidateId);
	
	CandidateModel updateCandidate (CandidateModel model);
	
	Boolean deleteCandidate (long candidateId , long deletedBy);
	
	Boolean isDuplicateEmail (String email);
	
	Boolean isDuplicateEmail (long candidateId, String email);
	
	Page<CandidateModel> paginateCandidates (int pageIndex , int pageSize , String attributeName , String sortOrder , String searchText);
		
}
