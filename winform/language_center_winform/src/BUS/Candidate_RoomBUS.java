package BUS;

import DTO.Candidate_RoomDTO;
import java.util.ArrayList;
import java.util.List;
import DAO.Candidate_RoomDAO;

public class Candidate_RoomBUS {

	public static List<Candidate_RoomDTO> candidate_rooms;
    private Candidate_RoomDAO candidate_roomDAO = new Candidate_RoomDAO();
    
    public List<Candidate_RoomDTO> getCandidate_Rooms() {
        if(candidate_rooms == null) {
        	candidate_rooms = new ArrayList<>();
        };
        
        try{
        	candidate_rooms = candidate_roomDAO.getCandidate_Rooms();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return candidate_rooms;
    };
    
    public Candidate_RoomDTO getCandidate_Room(int id) {
    	Candidate_RoomDTO candidate_room = new Candidate_RoomDTO();
        try{
        	candidate_room = candidate_roomDAO.getCandidate_Room(id);
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return candidate_room;
    };
    
    public void insert(Candidate_RoomDTO candidate_room) throws Exception {
    	try{
    		candidate_roomDAO.insert(candidate_room);
    		candidate_rooms.add(candidate_room);
		}catch (Exception e) {
			System.out.println(e);
		};
    };
    
    public void update(Candidate_RoomDTO candidate_room) throws Exception {
    	int index = -1;
        for(int i = 0; i < candidate_rooms.size(); i++) {
            if((candidate_rooms.get(i)).getId() == candidate_room.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		candidate_roomDAO.update(candidate_room);
        		candidate_rooms.set(index, candidate_room);
    		}catch (Exception e) {
    			// TODO: handle exception
    		};
        };
    };

    public void delete(int id) throws Exception {
        int index = -1;
    	for(int i = 0; i < candidate_rooms.size(); i++) {
            if((candidate_rooms.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try{
        		candidate_roomDAO.delete(id);
        		candidate_rooms.remove(index);
    		}catch (Exception e) {
    			// TODO: handle exception
    		};
        };
    };
    
    public Candidate_RoomDTO search(int identification) {
    	Candidate_RoomDTO candidate_roomSearch = new Candidate_RoomDTO();
        try{
        	candidate_rooms = candidate_roomDAO.getCandidate_Rooms();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        for(Candidate_RoomDTO candidate_room : candidate_rooms) {
            if(candidate_room.getCandidate_id() == identification) {
            	candidate_roomSearch = candidate_room;
            };
        };
        
        return candidate_roomSearch;
    };
	
}
