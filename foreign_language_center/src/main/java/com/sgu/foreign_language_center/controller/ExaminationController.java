package com.sgu.foreign_language_center.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
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
import com.sgu.foreign_language_center.entity.Examination;
import com.sgu.foreign_language_center.entity.Room;
import com.sgu.foreign_language_center.exception.ResourceNotFoundException;
import com.sgu.foreign_language_center.repository.ExaminationRepository;

@RestController
@RequestMapping("/foreign_language_center_api/")
public class ExaminationController {

	@Autowired
	ExaminationRepository examinationRepository;
	
	// Get all examination
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("examinations")
	public LinkedHashMap<String, Object> getAllEamination() {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", 200);
		response.put("data", examinationRepository.findAll());
		return response;
	};
	
	// Get examination by id
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("examinations/{id}")
	public LinkedHashMap<String, Object> getEamination(@PathVariable(value = "id") long examinationId) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		Examination examination = examinationRepository.findById(examinationId).orElseThrow(() -> new ResourceNotFoundException("Examination "+examinationId+" not found"));
		response.put("status", 200);
		response.put("data", examination);
		return response;
	};
	
	// Create new examination
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("examinations")
	public LinkedHashMap<String, Object> createExamination(@Valid @RequestBody Examination examination) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
//		Set<Room> roomList = new HashSet<Room>();
		String dateString = examination.getExamDate();
		String name = examination.getName();
		String dateRegex = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))/02/29)$" 
      	      + "|^(((19|2[0-9])[0-9]{2})/02/(0[1-9]|1[0-9]|2[0-8]))$"
      	      + "|^(((19|2[0-9])[0-9]{2})/(0[13578]|10|12)/(0[1-9]|[12][0-9]|3[01]))$" 
      	      + "|^(((19|2[0-9])[0-9]{2})/(0[469]|11)/(0[1-9]|[12][0-9]|30))$";
	    if (!dateString.matches(dateRegex)) {
	       examination.setExamDate(null);
	    };
	    if (name.replaceAll(" ", "").equals("")) {
	    	examination.setName(null);
	    };
	    
//	    examination.setRooms(roomList);
		response.put("status", 201);
		response.put("data", examinationRepository.save(examination));
		return response;
	};
    
    // Update examination
 	@CrossOrigin(origins = "http://localhost:3000")
 	@PutMapping("examinations/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> updateExamination(@PathVariable(value = "id") long examinationId, @Valid @RequestBody Examination updateExamination) {
     	LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
	    Examination editExamination = null;
	    Examination examination = examinationRepository.findById(examinationId).orElseThrow(() -> new ResourceNotFoundException("Examination "+examinationId+" not found"));
	    String dateString = updateExamination.getExamDate();
	    String name = updateExamination.getName();
	    String dateRegex = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))/02/29)$" 
	      	      + "|^(((19|2[0-9])[0-9]{2})/02/(0[1-9]|1[0-9]|2[0-8]))$"
	      	      + "|^(((19|2[0-9])[0-9]{2})/(0[13578]|10|12)/(0[1-9]|[12][0-9]|3[01]))$" 
	      	      + "|^(((19|2[0-9])[0-9]{2})/(0[469]|11)/(0[1-9]|[12][0-9]|30))$";
	     
	    if (!dateString.matches(dateRegex)) {
	    	examination.setExamDate(null);
	    }else{
	    	examination.setExamDate(dateString);
	    };
	     
	    if (name.replaceAll(" ", "").equals("")) {
	    	examination.setName(null);
	    }else{
	    	examination.setName(name);
	    };
	     
	 	editExamination = examinationRepository.save(examination);
		response.put("status", 200);
		response.put("data", editExamination);
	    return ResponseEntity.ok().body(response);
    };
	
	// Delete examination
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("examinations/{id}")
    public Map<String, Boolean> deleteExamination(@PathVariable(value = "id") long examinationId) {
        Map<String, Boolean> respone = new HashMap<>();
        Examination examination = examinationRepository.findById(examinationId).orElseThrow(() -> new ResourceNotFoundException("Examination "+examinationId+" not found"));
        this.examinationRepository.delete(examination);
        respone.put("Examination deleted: ", Boolean.TRUE);
        return respone;
    };
	
}
