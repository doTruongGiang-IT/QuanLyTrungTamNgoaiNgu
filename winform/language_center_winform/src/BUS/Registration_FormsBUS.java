package BUS;

import DTO.Registration_FormsDTO;
import java.util.ArrayList;
import java.util.List;
import DAO.Registration_FormsDAO;

public class Registration_FormsBUS {

	public static List<Registration_FormsDTO> registration_forms;
    private Registration_FormsDAO registration_formDAO = new Registration_FormsDAO();
    
    public List<Registration_FormsDTO> getRegistration_Forms() {
        if(registration_forms == null) {
        	registration_forms = new ArrayList<>();
        };
        
        try{
        	registration_forms = registration_formDAO.getRegistration_Forms();
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return registration_forms;
    };
    
    public Registration_FormsDTO getRegistration_Form(int id) {
    	Registration_FormsDTO registration_form = new Registration_FormsDTO();
        try{
        	registration_form = registration_formDAO.getRegistration_Form(id);
        }catch (Exception e) {
            System.out.println(e);
        };
        
        return registration_form;
    };
    
    public void insert(Registration_FormsDTO registration_form) throws Exception {
    	try{
    		registration_formDAO.insert(registration_form);
    		registration_forms.add(registration_form);
		}catch (Exception e) {
			System.out.println(e);
		};
    };
    
    public void update(Registration_FormsDTO registration_form) throws Exception {
    	int index = -1;
        for(int i = 0; i < registration_forms.size(); i++) {
            if((registration_forms.get(i)).getId() == registration_form.getId()) {
            	index = i;
            };
        };
        
        if(index != -1) {
        	try{
        		registration_formDAO.update(registration_form);
        		registration_forms.set(index, registration_form);
    		}catch (Exception e) {
    			// TODO: handle exception
    		};
        };
    };

    public void delete(int id) throws Exception {
        int index = -1;
    	for(int i = 0; i < registration_forms.size(); i++) {
            if((registration_forms.get(i)).getId() == id) {
            	index = i;
            };
        };
        if(index != -1) {
        	try{
        		registration_formDAO.delete(id);
        		registration_forms.remove(index);
    		}catch (Exception e) {
    			// TODO: handle exception
    		};
        };
    };
	
}
