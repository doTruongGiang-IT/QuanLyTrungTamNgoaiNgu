package BUS;

import DTO.RoomDTO;
import java.util.ArrayList;
import java.util.List;
import DAO.RoomDAO;

public class RoomBUS {

	public static List<RoomDTO> rooms;
    private RoomDAO roomDAO = new RoomDAO();
    
    public List<RoomDTO> getRooms() {
        if (rooms == null) {
        	rooms = new ArrayList<>();
        };
        
        try {
        	rooms = roomDAO.getRooms();
        } catch (Exception e) {
            System.out.println(e);
        };
        
        return rooms;
    };
    
    public RoomDTO getExamination(int id) {
    	RoomDTO room = new RoomDTO();
        try {
        	room = roomDAO.getRoom(id);
        } catch (Exception e) {
            System.out.println(e);
        };
        
        return room;
    };
    
    public void insert(RoomDTO room) throws Exception {
    	try {
    		roomDAO.insert(room);
            rooms.add(room);
		} catch (Exception e) {
			System.out.println(e);
		};
    };
    
    public void update(RoomDTO room) throws Exception {
    	int index = -1;
        for (int i = 0; i < rooms.size(); i++) {
            if ((rooms.get(i)).getId() == room.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try {
        		roomDAO.update(room);
                rooms.set(index, room);
    		} catch (Exception e) {
    			// TODO: handle exception
    		};
        };
    };

    public void delete(int id) throws Exception {
        int index = -1;
    	for (int i = 0; i < rooms.size(); i++) {
            if ((rooms.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try {
        		roomDAO.delete(id);
        		rooms.remove(index);
    		} catch (Exception e) {
    			// TODO: handle exception
    		};
        };
    };
    
    public String search(String searchKey) {
        String name = "";
        try {
        	rooms = roomDAO.getRooms();
        } catch (Exception e) {
            System.out.println(e);
        };
        
        for (RoomDTO room : rooms) {
            if (room.getName().toLowerCase().equals(searchKey.toLowerCase())) {
                name = room.getName();
            };
        };
        
        return name;
    };
	
}
