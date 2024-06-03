package com.techietact.mycognitiv.candidate.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techietact.mycognitiv.candidate.model.CandidateModel;
import com.techietact.mycognitiv.candidate.model.CandidateModel.ValidCreation;
import com.techietact.mycognitiv.candidate.model.CandidateModel.ValidUpdation;
import com.techietact.mycognitiv.candidate.service.CandidateService;
import com.techietact.mycognitiv.candidate.util.CustomUtils;

import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor

public class CandidateController {

	private final CandidateService candidateService;

	@PostMapping
	public ResponseEntity<?> createCandidate(@Validated(ValidCreation.class) @RequestBody CandidateModel model,
			BindingResult result) {
		if (result.hasErrors()) {
			return CustomUtils.badRequest(result);
		}
		return ResponseEntity.ok(candidateService.createCandidate(model));
	}

	@GetMapping("/{candidateId}")
	public ResponseEntity<CandidateModel> viewCandidate(@PathVariable("candidateId") long candidateId) {
		return ResponseEntity.ok(candidateService.viewCandidate(candidateId));
	}

	@PutMapping
	public ResponseEntity<?> updateCandidate(@Validated(ValidUpdation.class) @RequestBody CandidateModel model,
			BindingResult result) {
		if (result.hasErrors()) {
			if (model != null) {
				long candidateId = model.getCandidateId();
				String email = model.getEmail();
				if (candidateId > 0 && StringUtils.hasText(email)
						&& candidateService.isDuplicateEmail(candidateId, email)) {
					result.rejectValue("email", email, "Email already Exists");
				}
			}
			return CustomUtils.badRequest(result);
		}
		return ResponseEntity.ok(candidateService.updateCandidate(model));
	}

	@DeleteMapping("/{candidateId}/{deletedBy}")
	public ResponseEntity<Boolean> deleteCandidate(@PathVariable("candidateId") long candidateId,
			@PathVariable("deletedBy") long deletedBy) {
		return ResponseEntity.ok(candidateService.deleteCandidate(candidateId, deletedBy));
	}

	@GetMapping("/list")
	public ResponseEntity<List<CandidateModel>> getAllCandidates() {
		return ResponseEntity.ok(candidateService.listAllCandidates());
	}

	@GetMapping("/page")
	public ResponseEntity<Page<CandidateModel>> paginateCandidates(
			@RequestParam(value = "pageIndex", required = true) int pageIndex,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "attributeName", required = false) String attributeName,
			@RequestParam(value = "sortOrder", required = false) String sortOrder,
			@RequestParam(value = "searchText", required = false) String searchText) {
		return ResponseEntity
				.ok(candidateService.paginateCandidates(pageIndex, pageSize, attributeName, sortOrder, searchText));
	}

	@GetMapping("check-duplicate-email/{email}")
	public ResponseEntity<Boolean> isDuplicateEmail(@Email @PathVariable("email") String email) {
		return ResponseEntity.ok(candidateService.isDuplicateEmail(email));
	}

}
