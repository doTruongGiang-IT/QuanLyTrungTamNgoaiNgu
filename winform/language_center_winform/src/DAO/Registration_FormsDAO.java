package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.Registration_FormsDTO;
import DTO.SupervisorDTO;

public class Registration_FormsDAO {

	private List<Registration_FormsDTO> registration_forms = null;
	private String API_URL = "";
	
	public Registration_FormsDAO() {};
	
	public List<Registration_FormsDTO> getRegistration_Forms() {
		registration_forms = new ArrayList<Registration_FormsDTO>();
//		HttpClient client = HttpClient.newHttpClient();
//	    HttpRequest request = HttpRequest.newBuilder()
//	            .uri(new URI(API_URL))
//	            .headers("Content-Type", "application/json;charset=UTF-8")
//	            .GET()
//	            .build();
//	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        JSONObject responseObj = new JSONObject(response.body().toString());
//        System.out.println(responseObj);
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

	
}
