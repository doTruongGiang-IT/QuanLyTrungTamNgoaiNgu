package BUS;

import DTO.CandidateDTO;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import DAO.CandidateDAO;

public class CandidateBUS {

	public static List<CandidateDTO> candidates = new ArrayList<CandidateDTO>();
    private CandidateDAO candidateDAO = new CandidateDAO();
    
    public List<CandidateDTO> getCandidates() {
        if(candidates == null) {
        	candidates = new ArrayList<>();
        };
        
        try{
        	candidates = candidateDAO.getCandidates();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return candidates;
    };
    
    public CandidateDTO getCandidate(int id) {
    	CandidateDTO candidate = new CandidateDTO();
        try{
        	candidate = candidateDAO.getCandidate(id);
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return candidate;
    };
    
    public boolean insert(CandidateDTO candidate) {
    	try{
    		JSONObject result = candidateDAO.insert(candidate);
    		if(result != null) {
    			candidates.add(new CandidateDTO(result));
        		return true;
    		}else {
    			return false;
    		}
		}catch (Exception e) {
			System.out.println("Insert candidate error");
			return false;
		}
    };
    
    public boolean update(CandidateDTO candidate) {
    	int index = -1;
    	boolean result = false;
        for(int i = 0; i < candidates.size(); i++) {
            if((candidates.get(i)).getId() == candidate.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		boolean res = candidateDAO.update(candidate);
        		if(res) {
        			candidates.set(index, candidate);
            		result = true;
        		};
    		}catch (Exception e) {
    			System.out.println("Update candidate error");
    		};
        };
        return result;
    };

    public boolean delete(int id) {
        int index = -1;
        boolean result = false;
    	for(int i = 0; i < candidates.size(); i++) {
            if((candidates.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try{
        		boolean res = candidateDAO.delete(id);
        		if(res) {
        			candidates.remove(index);
            		result = true;
        		};
    		}catch (Exception e) {
    			System.out.println("Delete candidate error");
    		};
        };
        return result;
    };
    
    public List<CandidateDTO> search(String name) {
    	List<CandidateDTO> candidatesSearch = new ArrayList<CandidateDTO>();
        try{
        	candidates = candidateDAO.getCandidates();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        for(CandidateDTO candidate : candidates) {
            if(candidate.getFirst_name().toLowerCase().equals(name.toLowerCase()) || candidate.getLast_name().toLowerCase().equals(name.toLowerCase())) {
            	candidatesSearch.add(candidate);
            };
        };
        
        return candidatesSearch;
    };
	
}
