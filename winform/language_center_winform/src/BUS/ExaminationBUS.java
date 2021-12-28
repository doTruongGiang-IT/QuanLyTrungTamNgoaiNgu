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
    
    public void insert(ExaminationDTO examination) throws Exception {
    	try{
    		examinationDAO.insert(examination);
            examinations.add(examination);
		}catch (Exception e) {
			System.out.println(e);
		};
    };
    
    public void update(ExaminationDTO examination) throws Exception {
    	int index = -1;
        for(int i = 0; i < examinations.size(); i++) {
            if((examinations.get(i)).getId() == examination.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		examinationDAO.update(examination);
                examinations.set(index, examination);
    		}catch (Exception e) {
    			// TODO: handle exception
    		};
        };
    };

    public void delete(int id) throws Exception {
        int index = -1;
    	for(int i = 0; i < examinations.size(); i++) {
            if((examinations.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try{
        		examinationDAO.delete(id);
                examinations.remove(index);
    		}catch (Exception e) {
    			// TODO: handle exception
    		};
        };
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
