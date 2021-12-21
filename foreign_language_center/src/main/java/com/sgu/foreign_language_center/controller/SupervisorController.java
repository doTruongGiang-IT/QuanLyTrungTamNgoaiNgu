package com.sgu.foreign_language_center.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
import com.sgu.foreign_language_center.entity.Supervisor;
import com.sgu.foreign_language_center.exception.ResourceNotFoundException;
import com.sgu.foreign_language_center.repository.SupervisorRepository;

@RestController
@RequestMapping("/foreign_language_center_api/")
public class SupervisorController {

	@Autowired
	SupervisorRepository supervisorRepository;
	
	// Get all supervisor
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("supervisors")
	public LinkedHashMap<String, Object> getAllSupervisor() {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", 200);
		response.put("data", supervisorRepository.findAll());
		return response;
	};
	
	// Get supervisor by id
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("supervisors/{id}")
	public LinkedHashMap<String, Object> getSupervisor(@PathVariable(value = "id") long supervisorId) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		Supervisor supervisor = supervisorRepository.findById(supervisorId).orElseThrow(() -> new ResourceNotFoundException("Supervisor "+supervisorId+" not found"));
		response.put("status", 200);
		response.put("data", supervisor);
		return response;
	};
	
	// Create new supervisor
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("supervisors")
	public LinkedHashMap<String, Object> createSupervisor(@Valid @RequestBody Supervisor supervisor) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
	    String firstName = supervisor.getFirstName();
	    String lastName = supervisor.getLastName();
	    String gender = supervisor.getGender();
	    String phone = supervisor.getPhoneNumber();
	    String phoneRegex = "^(84|0[3|5|7|8|9])+([0-9]{8})$";
	    
	    if(firstName.replaceAll(" ", "").equals("")) {
	    	supervisor.setFirstName(null);
		};
		if(lastName.replaceAll(" ", "").equals("")) {
			supervisor.setLastName(null);
		};
	    if(!gender.toLowerCase().equals("Female".toLowerCase()) && !gender.toLowerCase().equals("Male".toLowerCase())) {
	    	supervisor.setGender("undefiend");
		}else {
			supervisor.setGender(gender.toLowerCase());
		};
		if(!phone.matches(phoneRegex)) {
			supervisor.setPhoneNumber(null);
		};
		
		response.put("status", 201);
		response.put("data", supervisorRepository.save(supervisor));
		return response;
	};
	
	// Update candidate
 	@CrossOrigin(origins = "http://localhost:3000")
 	@PutMapping("supervisors/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> updateSupervisor(@PathVariable(value = "id") long supervisorId, @Valid @RequestBody Supervisor updateSupervisor) {
     	LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
	    Supervisor editSupervisor = null;
	    Supervisor supervisor = supervisorRepository.findById(supervisorId).orElseThrow(() -> new ResourceNotFoundException("Supervisor "+supervisorId+" not found"));
	    String phoneRegex = "^(84|0[3|5|7|8|9])+([0-9]{8})$";
	    String firstName = updateSupervisor.getFirstName();
	    String lastName = updateSupervisor.getLastName();
	    String gender = updateSupervisor.getGender();
	    String phone = updateSupervisor.getPhoneNumber();
	    String email = updateSupervisor.getEmail();
	    
	    if(!gender.toLowerCase().equals("Female".toLowerCase()) && !gender.toLowerCase().equals("Male".toLowerCase())) {
	    	supervisor.setGender("undefiend");
		}else {
			supervisor.setGender(gender.toLowerCase());
		};
		
		if(!phone.matches(phoneRegex)) {
			supervisor.setPhoneNumber(null);
		}else {
			supervisor.setPhoneNumber(phone);
		};
		
		if(firstName.replaceAll(" ", "").equals("")) {
			supervisor.setFirstName(null);
		}else {
			supervisor.setFirstName(firstName);
		};
		
		if(lastName.replaceAll(" ", "").equals("")) {
			supervisor.setLastName(null);
		}else {
			supervisor.setLastName(lastName);
		};
		
		supervisor.setEmail(email);
	     
		editSupervisor = supervisorRepository.save(supervisor);
		response.put("status", 200);
		response.put("data", editSupervisor);
	    return ResponseEntity.ok().body(response);
    };
	
	// Delete examination
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("supervisors/{id}")
    public Map<String, Boolean> deleteSupervisor(@PathVariable(value = "id") long supervisorId) {
        Map<String, Boolean> respone = new HashMap<>();
        Supervisor supervisor = supervisorRepository.findById(supervisorId).orElseThrow(() -> new ResourceNotFoundException("Supervisor "+supervisorId+" not found"));
        this.supervisorRepository.delete(supervisor);
        respone.put("Supervisor deleted: ", Boolean.TRUE);
        return respone;
    };
	
}
