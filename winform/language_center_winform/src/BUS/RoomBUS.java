package BUS;

import DTO.RoomDTO;
import java.util.ArrayList;
import java.util.List;
import DAO.RoomDAO;

public class RoomBUS {

	public static List<RoomDTO> rooms;
    private RoomDAO roomDAO = new RoomDAO();
    
    public List<RoomDTO> getRooms() {
        if(rooms == null) {
        	rooms = new ArrayList<>();
        };
        
        try{
        	rooms = roomDAO.getRooms();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return rooms;
    };
    
    public RoomDTO getRoom(int id) {
    	RoomDTO room = new RoomDTO();
        try{
        	room = roomDAO.getRoom(id);
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return room;
    };
    
    public boolean insert(RoomDTO room) {
    	try{
    		roomDAO.insert(room);
            rooms.add(room);
            return true;
		}catch (Exception e) {
			System.out.println("Insert room error");
			return false;
		}
    };
    
    public boolean update(RoomDTO room) {
    	int index = -1;
    	boolean result = false;
        for(int i = 0; i < rooms.size(); i++) {
            if((rooms.get(i)).getId() == room.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		roomDAO.update(room);
                rooms.set(index, room);
                result = true;
    		}catch (Exception e) {
    			System.out.println("Update examination error");
    		};
        };
        return result;
    };

    public boolean delete(int id) {
        int index = -1;
        boolean result = false;
    	for (int i = 0; i < rooms.size(); i++) {
            if ((rooms.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try {
        		roomDAO.delete(id);
        		rooms.remove(index);
        		result = true;
    		} catch (Exception e) {
    			System.out.println("Delete examination error");
    		};
        };
        return result;
    };
    
    public List<RoomDTO> search(String name) {
    	List<RoomDTO> roomsSearch = new ArrayList<RoomDTO>();
        try{
        	rooms = roomDAO.getRooms();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        for(RoomDTO room : rooms) {
            if(room.getName().toLowerCase().equals(name.toLowerCase())) {
            	roomsSearch.add(room);
            };
        };
        
        return roomsSearch;
    };
	
}
