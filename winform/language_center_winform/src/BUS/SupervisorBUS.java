package BUS;

import DTO.SupervisorDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import DAO.SupervisorDAO;

public class SupervisorBUS {

	public static List<SupervisorDTO> supervisors = new ArrayList<SupervisorDTO>();
    private SupervisorDAO supervisorDAO = new SupervisorDAO();
    
    public List<SupervisorDTO> getSupervisors() {
        if(supervisors == null) {
        	supervisors = new ArrayList<>();
        };
        
        try{
        	supervisors = supervisorDAO.getSupervisors();
        }catch (Exception e) {
            System.out.println(e);
        };
        for (SupervisorDTO supervisorDTO : supervisors) {
			System.out.println(supervisorDTO.toJSONObject().toString());
		}
        return supervisors;
    };
    
    public SupervisorDTO getExamination(int id) {
    	SupervisorDTO supervisor = new SupervisorDTO();
        try{
        	supervisor = supervisorDAO.getSupervisor(id);
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return supervisor;
    };
    
    public boolean insert(SupervisorDTO supervisor) {
    	try{
    		supervisorDAO.insert(supervisor);
    		supervisors.add(supervisor);
    		return true;
		}catch (Exception e) {
			System.out.println("Insert supervisor error");
			return false;
		}
    };
    
    public boolean update(SupervisorDTO supervisor) {
    	int index = -1;
    	boolean result = false;
        for(int i = 0; i < supervisors.size(); i++) {
            if((supervisors.get(i)).getId() == supervisor.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		supervisorDAO.update(supervisor);
        		supervisors.set(index, supervisor);
        		result = true;
    		}catch (Exception e) {
    			System.out.println("Update supervisor error");
    		};
        };
        return result;
    };

    public boolean delete(int id) {
        int index = -1;
        boolean result = false;
    	for(int i = 0; i < supervisors.size(); i++) {
            if((supervisors.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try{
        		supervisorDAO.delete(id);
        		supervisors.remove(index);
        		result = true;
    		}catch (Exception e) {
    			System.out.println("Delete supervisor error");
    		};
        };
        return result;
    };
    
    public List<SupervisorDTO> search(String name) {
    	List<SupervisorDTO> supervisorsSearch = new ArrayList<SupervisorDTO>();
        try{
        	supervisors = supervisorDAO.getSupervisors();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        for(SupervisorDTO supervisor : supervisors) {
            if(supervisor.getName().toLowerCase().equals(name.toLowerCase())) {
            	supervisorsSearch.add(supervisor);
            };
        };
        
        return supervisorsSearch;
    };
    
    
	
}
