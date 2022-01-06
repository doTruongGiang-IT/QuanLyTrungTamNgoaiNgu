package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import DTO.Registration_FormsDTO;
import DTO.SupervisorDTO;
import DTO.Supervisor_RoomDTO;

public class Registration_FormsDAO {

	private List<Registration_FormsDTO> registration_forms = null;
	private String API_URL = "";
	
	public Registration_FormsDAO() {};
	
	public List<Registration_FormsDTO> getRegistration_Forms() {
		registration_forms = new ArrayList<Registration_FormsDTO>();
		ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("RegistrationForm", "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		try {
				JSONArray list = res.data.getJSONArray("data");
				for(int i=0; i<list.length();i++) {
					JSONObject jsonObj = (JSONObject) list.get(i);
					registration_forms.add(new Registration_FormsDTO(jsonObj));
				};
			} catch (JSONException e) {
				e.printStackTrace();
			}
    	};
        return registration_forms;
    };
    
    public Registration_FormsDTO getRegistration_Form(int id) {
    	Registration_FormsDTO registrationDTO = null;
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("RegistrationForm/"+String.valueOf(id), "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		registrationDTO = new Registration_FormsDTO(res.data);
    	}else {
    		registrationDTO = null;
    	};
        return registrationDTO;
    };
    
    public void insert(Registration_FormsDTO registration_form) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("RegistrationForm", "POST", registration_form.toJSONObject().toString());
    };
    
    public void update(Registration_FormsDTO registration_form) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("RegistrationForm", "PUT", registration_form.toJSONObject().toString());
    };
    
    public void delete(int id) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("RegistrationForm/"+String.valueOf(id), "DELETE", null);
    };

    public static void main(String args[]) {
    	Registration_FormsDAO registration_FormsDAO = new Registration_FormsDAO();
		List<Registration_FormsDTO> dtos = registration_FormsDAO.getRegistration_Forms();
		if(dtos != null) {
			for(int i=0; i< dtos.size(); i++) {
				System.out.println(dtos.get(i).getId());
				System.out.println(dtos.get(i).getCandidate_id());
				System.out.println(dtos.get(i).getExamination_id());
				System.out.println(dtos.get(i).getLevel());
				System.out.println(dtos.get(i).isStatus());
				System.out.println("=====================");
			};
		};
	};
	
}
