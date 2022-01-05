package BUS;

import DTO.CandidateDTO;
import java.util.ArrayList;
import java.util.List;
import DAO.CandidateDAO;

public class CandidateBUS {

	public static List<CandidateDTO> candidates;
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
    		candidateDAO.insert(candidate);
    		candidates.add(candidate);
    		return true;
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
        		candidateDAO.update(candidate);
        		candidates.set(index, candidate);
        		result = true;
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
        		candidateDAO.delete(id);
        		candidates.remove(index);
        		result = true;
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
