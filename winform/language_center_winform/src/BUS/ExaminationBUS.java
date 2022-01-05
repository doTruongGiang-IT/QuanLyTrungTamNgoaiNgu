package BUS;

import DTO.ExaminationDTO;
import java.util.ArrayList;
import java.util.List;
import DAO.ExaminationDAO;

public class ExaminationBUS {

	public static List<ExaminationDTO> examinations;
    private ExaminationDAO examinationDAO = new ExaminationDAO();
    
    public List<ExaminationDTO> getExaminations() {
        if(examinations == null) {
        	examinations = new ArrayList<>();
        };
        
        try{
        	examinations = examinationDAO.getExaminations();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return examinations;
    };
    
    public ExaminationDTO getExamination(int id) {
    	ExaminationDTO examination = new ExaminationDTO();
        try{
        	examination = examinationDAO.getExamination(id);
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return examination;
    };
    
    public boolean insert(ExaminationDTO examination) {
    	try{
    		examinationDAO.insert(examination);
            examinations.add(examination);
            return true;
		}catch (Exception e) {
			System.out.println("Insert examination error");
			return false;
		}
    };
    
    public boolean update(ExaminationDTO examination) {
    	int index = -1;
    	boolean result = false;
        for(int i = 0; i < examinations.size(); i++) {
            if((examinations.get(i)).getId() == examination.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		examinationDAO.update(examination);
                examinations.set(index, examination);
                result = true;
    		}catch (Exception e) {
    			System.out.println("Update examination error");
    		}
        };
		return result;
    };

    public boolean delete(int id) {
        int index = -1;
        boolean result = false;
    	for(int i = 0; i < examinations.size(); i++) {
            if((examinations.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try{
        		examinationDAO.delete(id);
                examinations.remove(index);
                result = true;
    		}catch (Exception e) {
    			System.out.println("Delete examination error");
    		}
        };
        return result;
    };
    
    public List<ExaminationDTO> search(String name) {
    	List<ExaminationDTO> examinationsSearch = new ArrayList<ExaminationDTO>();
        try{
        	examinations = examinationDAO.getExaminations();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        for(ExaminationDTO examination : examinations) {
            if(examination.getName().toLowerCase().equals(name.toLowerCase())) {
            	examinationsSearch.add(examination);
            };
        };
        
        return examinationsSearch;
    };
	
}
