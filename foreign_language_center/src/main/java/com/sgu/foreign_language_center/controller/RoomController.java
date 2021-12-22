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
		List<Object> list = new ArrayList<Object>();
		List<Room> rooms = roomRepository.findAll();
		for(Room room : rooms) {
			LinkedHashMap<String, Object> formatRoom = new LinkedHashMap<String, Object>();
			formatRoom.put("id", room.getId());
			formatRoom.put("examination", room.getExamination().getId());
			formatRoom.put("examTime", room.getExamTime());
			formatRoom.put("level", room.getLevel());
			formatRoom.put("roomIdentify", room.getRoomIdentify());
			list.add(formatRoom);
		};
		response.put("status", 200);
		response.put("data", list);
		return response;
	};
	
	// Get room by id
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("rooms/{id}")
	public LinkedHashMap<String, Object> getRoom(@PathVariable(value = "id") long roomId) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room "+roomId+" not found"));
		LinkedHashMap<String, Object> formatRoom = new LinkedHashMap<String, Object>();
		formatRoom.put("id", room.getId());
		formatRoom.put("examination", room.getExamination().getId());
		formatRoom.put("examTime", room.getExamTime());
		formatRoom.put("level", room.getLevel());
		formatRoom.put("roomIdentify", room.getRoomIdentify());
		response.put("status", 200);
		response.put("data", formatRoom);
		return response;
	};
	
	// Create new examination
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("rooms")
	public LinkedHashMap<String, Object> createRoom(@Valid @RequestBody Room room) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> formatRoom = new LinkedHashMap<String, Object>();
	    String time = room.getExamTime();
	    String level = room.getLevel();
	    
	    if(!time.toLowerCase().equals("Morning".toLowerCase()) && !time.toLowerCase().equals("Afternoon".toLowerCase())) {
	    	room.setExamTime(null);
	    }else {
	    	room.setExamTime(time.toLowerCase());
	    };
	    
		if(!level.toLowerCase().equals("A2".toLowerCase()) && !level.toLowerCase().equals("B1".toLowerCase())) {
			room.setLevel(null);
		};
		
		Room newRoom = roomRepository.save(room);
		formatRoom.put("id", newRoom.getId());
		formatRoom.put("examination", newRoom.getExamination().getId());
		formatRoom.put("examTime", newRoom.getExamTime());
		formatRoom.put("level", newRoom.getLevel());
		
		/* Generate room identify in BUS
		 * String.format("%03d", yournumber);
		 *  */
		formatRoom.put("roomIdentify", newRoom.getRoomIdentify());
		
		response.put("status", 201);
		response.put("data", formatRoom);
		return response;
	};
	
	// Update candidate
 	@CrossOrigin(origins = "http://localhost:3000")
 	@PutMapping("rooms/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> updateRoom(@PathVariable(value = "id") long roomId, @Valid @RequestBody Room updateRoom) {
     	LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
     	LinkedHashMap<String, Object> formatRoom = new LinkedHashMap<String, Object>();
	    Room editRoom = null;
	    Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room "+roomId+" not found"));
	    
	    String time = updateRoom.getExamTime();
	    
	    if(!time.toLowerCase().equals("Morning".toLowerCase()) && !time.toLowerCase().equals("Afternoon".toLowerCase())) {
	    	room.setExamTime(null);
	    }else {
	    	room.setExamTime(time.toLowerCase());
	    };
	     
	    editRoom = roomRepository.save(room);
	    formatRoom.put("id", editRoom.getId());
	    formatRoom.put("examination", editRoom.getExamination().getId());
	    formatRoom.put("examTime", editRoom.getExamTime());
	    formatRoom.put("level", editRoom.getLevel());
	    formatRoom.put("roomIdentify", editRoom.getRoomIdentify());
		
		response.put("status", 200);
		response.put("data", formatRoom);
	    return ResponseEntity.ok().body(response);
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
