package com.sgu.foreign_language_center.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgu.foreign_language_center.entity.Candidate;
import com.sgu.foreign_language_center.exception.ResourceNotFoundException;
import com.sgu.foreign_language_center.repository.CandidateRepository;

@RestController
@RequestMapping("/foreign_language_center_api/")
public class CandidateController {

	@Autowired
	CandidateRepository candidateRepository;
	
	// Get all candidate
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("candidates")
	public LinkedHashMap<String, Object> getAllCandidate() {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", 200);
		response.put("data", candidateRepository.findAll());
		return response;
	};
	
	// Get candidate by id
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("candidates/{id}")
	public LinkedHashMap<String, Object> getCandidate(@PathVariable(value = "id") long candidateId) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException("Candidate "+candidateId+" not found"));
		response.put("status", 200);
		response.put("data", candidate);
		return response;
	};
	
	// Create new candidate
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("candidates")
	public LinkedHashMap<String, Object> createCandidate(@Valid @RequestBody Candidate candidate) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		String dateRegex = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))/02/29)$" 
        	      + "|^(((19|2[0-9])[0-9]{2})/02/(0[1-9]|1[0-9]|2[0-8]))$"
        	      + "|^(((19|2[0-9])[0-9]{2})/(0[13578]|10|12)/(0[1-9]|[12][0-9]|3[01]))$" 
        	      + "|^(((19|2[0-9])[0-9]{2})/(0[469]|11)/(0[1-9]|[12][0-9]|30))$";
		String phoneRegex = "^(84|0[3|5|7|8|9])+([0-9]{8})$";
		Optional<Candidate> checkCandidate = candidateRepository.findById(candidate.getIdentityCard());
		
		if(!checkCandidate.isPresent()) {
			String dateOfBirth = candidate.getDayOfBirth();
			String dateProvide = candidate.getDayProvide();
			String gender = candidate.getGender();
			String phone = candidate.getPhoneNumber();
			String firstName = candidate.getFirstName();
			String lastName = candidate.getLastName();
			String identityCard = String.valueOf(candidate.getIdentityCard());

			if(!dateOfBirth.matches(dateRegex)) {
				candidate.setDayOfBirth(null);
			};
			if(!dateProvide.matches(dateRegex)) {
				candidate.setDayProvide(null);
			};
			if(!gender.toLowerCase().equals("Female".toLowerCase()) && !gender.toLowerCase().equals("Male".toLowerCase())) {
				candidate.setGender("undefiend");
			}else {
				candidate.setGender(gender.toLowerCase());
			};
			if(!phone.matches(phoneRegex)) {
				candidate.setPhoneNumber(null);
			};
			if(firstName.replaceAll(" ", "").equals("")) {
				candidate.setFirstName(null);
			};
			if(lastName.replaceAll(" ", "").equals("")) {
				candidate.setLastName(null);
			};
			if(identityCard.length() < 10) {
				candidate.setIdentityCard(0);
			};
			
			response.put("status", 201);
			response.put("data", candidateRepository.save(candidate));
		};
		
		if(checkCandidate.isPresent()) {
			throw new ResourceNotFoundException("Candidate "+candidate.getIdentityCard()+" already exists");
		};
		
		return response;
	};
	
	// Update candidate
 	@CrossOrigin(origins = "http://localhost:3000")
 	@PutMapping("candidates/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> updateCandidate(@PathVariable(value = "id") long candidateId, @Valid @RequestBody Candidate updateCandidate) {
     	LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
	    Candidate editCandidate = null;
	    Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException("Candidate "+candidateId+" not found"));
	    String dateRegex = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))/02/29)$" 
      	      + "|^(((19|2[0-9])[0-9]{2})/02/(0[1-9]|1[0-9]|2[0-8]))$"
      	      + "|^(((19|2[0-9])[0-9]{2})/(0[13578]|10|12)/(0[1-9]|[12][0-9]|3[01]))$" 
      	      + "|^(((19|2[0-9])[0-9]{2})/(0[469]|11)/(0[1-9]|[12][0-9]|30))$";
		String phoneRegex = "^(84|0[3|5|7|8|9])+([0-9]{8})$";
	    
	    String dateOfBirth = updateCandidate.getDayOfBirth();
		String dateProvide = updateCandidate.getDayProvide();
		String gender = updateCandidate.getGender();
		String phone = updateCandidate.getPhoneNumber();
		String firstName = updateCandidate.getFirstName();
		String lastName = updateCandidate.getLastName();
		String identityCard = String.valueOf(updateCandidate.getIdentityCard());
		String email = updateCandidate.getEmail();

		if(!dateOfBirth.matches(dateRegex)) {
			candidate.setDayOfBirth(null);
		}else {
			candidate.setDayOfBirth(dateOfBirth);
		};
		
		if(!dateProvide.matches(dateRegex)) {
			candidate.setDayProvide(null);
		}else {
			candidate.setDayProvide(dateProvide);
		};
		
		if(!gender.toLowerCase().equals("Female".toLowerCase()) && !gender.toLowerCase().equals("Male".toLowerCase())) {
			candidate.setGender("undefiend");
		}else {
			candidate.setGender(gender.toLowerCase());
		};
		
		if(!phone.matches(phoneRegex)) {
			candidate.setPhoneNumber(null);
		}else {
			candidate.setPhoneNumber(phone);
		};
		
		if(firstName.replaceAll(" ", "").equals("")) {
			candidate.setFirstName(null);
		}else {
			candidate.setFirstName(firstName);
		};
		
		if(lastName.replaceAll(" ", "").equals("")) {
			candidate.setLastName(null);
		}else {
			candidate.setLastName(lastName);
		};
		
		candidate.setEmail(email);
		
		if(identityCard.length() < 10) {
			candidate.setIdentityCard(0);
		}else {
			candidate.setIdentityCard(updateCandidate.getIdentityCard());
		};
	     
	    editCandidate = candidateRepository.save(candidate);
		response.put("status", 200);
		response.put("data", editCandidate);
	    return ResponseEntity.ok().body(response);
    };
	
	// Delete candidate
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("candidates/{id}")
    public Map<String, Boolean> deleteCandidate(@PathVariable(value = "id") long candidateId) {
        Map<String, Boolean> respone = new HashMap<>();
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException("Candidate "+candidateId+" not found"));
        this.candidateRepository.delete(candidate);
        respone.put("Candidate deleted: ", Boolean.TRUE);
        return respone;
    };
	
}
