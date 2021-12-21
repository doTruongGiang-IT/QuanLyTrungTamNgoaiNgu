package com.sgu.foreign_language_center.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgu.foreign_language_center.entity.Room;
import com.sgu.foreign_language_center.exception.ResourceNotFoundException;
import com.sgu.foreign_language_center.repository.RoomRepository;

@RestController
@RequestMapping("/foreign_language_center_api/")
public class RoomController {

	@Autowired
	RoomRepository roomRepository;
	
	// Get all room
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("rooms")
	public LinkedHashMap<String, Object> getAllRoom() {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", 200);
		response.put("data", roomRepository.findAll());
		return response;
	};
	
	// Get room by id
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("rooms/{id}")
	public LinkedHashMap<String, Object> getRoom(@PathVariable(value = "id") long roomId) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room "+roomId+" not found"));
		response.put("status", 200);
		response.put("data", room);
		return response;
	};
	
	// Create new examination
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("rooms")
	public LinkedHashMap<String, Object> createRoom(@Valid @RequestBody Room room) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
	    String time = room.getExamTime();
	    String level = room.getLevel();
	    
	    if(!time.toLowerCase().equals("Morning".toLowerCase()) && !time.toLowerCase().equals("Afternoon".toLowerCase())) {
	    	room.setExamTime(null);
	    };
		if(!level.toLowerCase().equals("A2".toLowerCase()) && !level.toLowerCase().equals("B1".toLowerCase())) {
			room.setLevel(null);
		};
		
		response.put("status", 201);
		response.put("data", roomRepository.save(room));
		return response;
	};
	
	// Delete examination
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") long roomId) {
        Map<String, Boolean> respone = new HashMap<>();
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room "+roomId+" not found"));
        this.roomRepository.delete(room);
        respone.put("Room deleted: ", Boolean.TRUE);
        return respone;
    };
	
}
