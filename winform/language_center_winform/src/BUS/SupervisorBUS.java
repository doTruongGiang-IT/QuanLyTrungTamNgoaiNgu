package BUS;

import DTO.SupervisorDTO;
import java.util.ArrayList;
import java.util.List;
import DAO.SupervisorDAO;

public class SupervisorBUS {

	public static List<SupervisorDTO> supervisors;
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
    
    public void insert(SupervisorDTO supervisor) throws Exception {
    	try{
    		supervisorDAO.insert(supervisor);
    		supervisors.add(supervisor);
		}catch (Exception e) {
			System.out.println(e);
		};
    };
    
    public void update(SupervisorDTO supervisor) throws Exception {
    	int index = -1;
        for(int i = 0; i < supervisors.size(); i++) {
            if((supervisors.get(i)).getId() == supervisor.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		supervisorDAO.update(supervisor);
        		supervisors.set(index, supervisor);
    		}catch (Exception e) {
    			// TODO: handle exception
    		};
        };
    };

    public void delete(int id) throws Exception {
        int index = -1;
    	for(int i = 0; i < supervisors.size(); i++) {
            if((supervisors.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try{
        		supervisorDAO.delete(id);
        		supervisors.remove(index);
    		}catch (Exception e) {
    			// TODO: handle exception
    		};
        };
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
