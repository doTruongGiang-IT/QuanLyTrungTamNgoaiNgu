package com.sgu.foreign_language_center.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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

import com.sgu.foreign_language_center.entity.Candidate;
import com.sgu.foreign_language_center.entity.CandidatesInRoom;
import com.sgu.foreign_language_center.entity.Room;
import com.sgu.foreign_language_center.exception.ResourceNotFoundException;
import com.sgu.foreign_language_center.repository.CandidateRepository;
import com.sgu.foreign_language_center.repository.CandidatesInRoomRepository;
import com.sgu.foreign_language_center.repository.RoomRepository;

@RestController
@RequestMapping("/foreign_language_center_api/")
public class CandidatesInRoomController {

	@Autowired
	CandidatesInRoomRepository candidatesInRoomRepository;
	
	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	// Get all candidates in room
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("candidates_in_room")
	public LinkedHashMap<String, Object> getAllCandidatesInRoom() {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		List<CandidatesInRoom> candidatesInRoomList = candidatesInRoomRepository.findAll();
		for(CandidatesInRoom candidatesInRoom : candidatesInRoomList) {
			LinkedHashMap<String, Object> formatCandidatesInRoom = new LinkedHashMap<String, Object>();
			formatCandidatesInRoom.put("candidates_in_room_id", candidatesInRoom.getId());
			formatCandidatesInRoom.put("candidate", candidatesInRoom.getCandidate().getIdentityCard());
			formatCandidatesInRoom.put("room", candidatesInRoom.getRoom().getId());
			formatCandidatesInRoom.put("candidateNumber", candidatesInRoom.getCandidateNumber());
			formatCandidatesInRoom.put("listeningScore", candidatesInRoom.getListeningScore());
			formatCandidatesInRoom.put("readingScore", candidatesInRoom.getReadingScore());
			formatCandidatesInRoom.put("writingScore", candidatesInRoom.getWritingScore());
			formatCandidatesInRoom.put("speakingScore", candidatesInRoom.getSpeakingScore());
			list.add(formatCandidatesInRoom);
		};
		response.put("status", 200);
		response.put("data", list);
		return response;
	};
	
	// Get all candidates in room
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("candidates_in_room/{id}")
	public LinkedHashMap<String, Object> getAllCandidateInRoom(@PathVariable(value = "id") long roomId) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		CandidatesInRoom room = candidatesInRoomRepository.findRoomById(roomId);
		response.put("status", 200);
		response.put("data", room);
		return response;
	};
	
	// Get all candidates in room
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("candidates_in_room/candidate/{id}")
	public LinkedHashMap<String, Object> getCandidateScore(@PathVariable(value = "id") long candidateId) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		CandidatesInRoom candidate = candidatesInRoomRepository.findCandidateByIdentityCard(candidateId);
		if(candidate != null) {
			LinkedHashMap<String, Object> formatCandidatesInRoom = new LinkedHashMap<String, Object>();
			formatCandidatesInRoom.put("candidates_in_room_id", candidate.getId());
			formatCandidatesInRoom.put("candidate", candidate.getCandidate().getIdentityCard());
			formatCandidatesInRoom.put("room", candidate.getRoom().getId());
			formatCandidatesInRoom.put("candidateNumber", candidate.getCandidateNumber());
			formatCandidatesInRoom.put("listeningScore", candidate.getListeningScore());
			formatCandidatesInRoom.put("readingScore", candidate.getReadingScore());
			formatCandidatesInRoom.put("writingScore", candidate.getWritingScore());
			formatCandidatesInRoom.put("speakingScore", candidate.getSpeakingScore());
			
			response.put("status", 200);
			response.put("data", formatCandidatesInRoom);
		}else {
			throw new ResourceNotFoundException("Candidate "+candidateId+" not found");
		};
		
		return response;
	};
	
	// Create new candidates in room ** Remove key examination in object room **
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("candidates_in_room")
	public LinkedHashMap<String, Object> createCandidatesInRoom(@Valid @RequestBody CandidatesInRoom candidatesInRoom) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> formatCandidatesInRoom = new LinkedHashMap<String, Object>();
	    float listeningScore = candidatesInRoom.getListeningScore();
	    float readingScore = candidatesInRoom.getReadingScore();
	    float writingScore = candidatesInRoom.getWritingScore();
	    float speakingScore = candidatesInRoom.getSpeakingScore();
	    Candidate candidate = candidateRepository.findById(candidatesInRoom.getCandidate().getIdentityCard()).orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));
		Room room = roomRepository.findById(candidatesInRoom.getRoom().getId()).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
	    
		if((listeningScore<0 || listeningScore>10) || (readingScore<0 || readingScore>10)
			|| (writingScore<0 || writingScore>10) || (speakingScore<0 || speakingScore>10)) {
			candidatesInRoom.setListeningScore(0);
			candidatesInRoom.setReadingScore(0);
			candidatesInRoom.setWritingScore(0);
			candidatesInRoom.setSpeakingScore(0);
		};
		CandidatesInRoom newCandidatesInRoom = candidatesInRoomRepository.save(candidatesInRoom);
		formatCandidatesInRoom.put("candidates_in_room_id", newCandidatesInRoom.getId());
		formatCandidatesInRoom.put("candidate", newCandidatesInRoom.getCandidate().getIdentityCard());
		formatCandidatesInRoom.put("room", newCandidatesInRoom.getRoom().getId());
		
		/* Generate candidate number in BUS
		 * String.format("%03d", yournumber);
		 *  */
		formatCandidatesInRoom.put("candidateNumber", newCandidatesInRoom.getCandidateNumber());
		formatCandidatesInRoom.put("listeningScore", newCandidatesInRoom.getListeningScore());
		formatCandidatesInRoom.put("readingScore", newCandidatesInRoom.getReadingScore());
		formatCandidatesInRoom.put("writingScore", newCandidatesInRoom.getWritingScore());
		formatCandidatesInRoom.put("speakingScore", newCandidatesInRoom.getSpeakingScore());
		
		response.put("status", 201);
		response.put("data", formatCandidatesInRoom);
		return response;
	};
	
}
