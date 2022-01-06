package BUS;

import DTO.Supervisor_RoomDTO;
import DTO.SupervisorDTO;
import java.util.ArrayList;
import java.util.List;
import DAO.Supervisor_RoomDAO;
import DAO.SupervisorDAO;

public class Supervisor_RoomBUS {

	public static List<Supervisor_RoomDTO> supervisor_rooms = new ArrayList<Supervisor_RoomDTO>();
    private Supervisor_RoomDAO supervisor_roomDAO = new Supervisor_RoomDAO();
    private SupervisorDAO supervisorDAO = new SupervisorDAO();
    
    public List<Supervisor_RoomDTO> getSupervisor_Rooms() {
        if(supervisor_rooms == null) {
        	supervisor_rooms = new ArrayList<>();
        };
        
        try{
        	supervisor_rooms = supervisor_roomDAO.getSupervisor_Rooms();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return supervisor_rooms;
    };
    
    public Supervisor_RoomDTO getSupervisor_Room(int id) {
    	Supervisor_RoomDTO supervisor_room = new Supervisor_RoomDTO();
        try{
        	supervisor_room = supervisor_roomDAO.getSupervisor_Room(id);
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return supervisor_room;
    };
    
    public boolean insert(Supervisor_RoomDTO supervisor_room) {
    	try{
    		supervisor_roomDAO.insert(supervisor_room);
    		supervisor_rooms.add(supervisor_room);
    		return true;
		}catch (Exception e) {
			System.out.println("Insert supervisor_room error");
			return false;
		}
    };
    
    public boolean update(Supervisor_RoomDTO supervisor_room) {
    	int index = -1;
    	boolean result = false;
        for(int i = 0; i < supervisor_rooms.size(); i++) {
            if((supervisor_rooms.get(i)).getId() == supervisor_room.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		supervisor_roomDAO.update(supervisor_room);
        		supervisor_rooms.set(index, supervisor_room);
        		result = true;
    		}catch (Exception e) {
    			System.out.println("Update supervisor_room error");
    		};
        };
        return result;
    };

    public boolean delete(int id) {
        int index = -1;
        boolean result = false;
    	for(int i = 0; i < supervisor_rooms.size(); i++) {
            if((supervisor_rooms.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try{
        		supervisor_roomDAO.delete(id);
        		supervisor_rooms.remove(index);
        		result = true;
    		}catch (Exception e) {
    			System.out.println("Delete supervisor_room error");
    		};
        };
        return result;
    };
    
    public List<Supervisor_RoomDTO> search(String name) {
    	List<Supervisor_RoomDTO> supervisor_roomsSearch = new ArrayList<Supervisor_RoomDTO>();
        try{
        	supervisor_rooms = supervisor_roomDAO.getSupervisor_Rooms();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        for(Supervisor_RoomDTO supervisor_room : supervisor_rooms) {
        	try{
				SupervisorDTO supervisor = supervisorDAO.getSupervisor(supervisor_room.getSupervisor_id());
				if(supervisor.getName().toLowerCase().equals(name.toLowerCase())) {
	            	supervisor_roomsSearch.equals(supervisor_room);
	            };
			}catch (Exception e) {
				System.out.println(e);
			};
        };
        
        return supervisor_roomsSearch;
    };
	
}
