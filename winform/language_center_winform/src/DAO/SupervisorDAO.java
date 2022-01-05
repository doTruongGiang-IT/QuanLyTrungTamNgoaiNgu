package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

import DTO.CandidateDTO;
import DTO.SupervisorDTO;

public class SupervisorDAO {

	private List<SupervisorDTO> supervisors = null;
	private String API_URL = "";
	
	public SupervisorDAO() {};
	
	public List<SupervisorDTO> getSupervisors() {
		supervisors = new ArrayList<SupervisorDTO>();
//		HttpClient client = HttpClient.newHttpClient();
//	    HttpRequest request = HttpRequest.newBuilder()
//	            .uri(new URI(API_URL))
//	            .headers("Content-Type", "application/json;charset=UTF-8")
//	            .GET()
//	            .build();
//	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        JSONObject responseObj = new JSONObject(response.body().toString());
//        System.out.println(responseObj);
        return supervisors;
    };
    
    public SupervisorDTO getSupervisor(int id) {
    	SupervisorDTO supervisorDTO = null;
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("Supervisor/"+String.valueOf(id), "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		supervisorDTO = new SupervisorDTO(res.data);
    	}else {
    		supervisorDTO = null;
    	};
        return supervisorDTO;
    };
    
    public void insert(SupervisorDTO supervisor) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Supervisor", "POST", supervisor.toString());
    };
    
    public void update(SupervisorDTO supervisor) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Supervisor", "PUT", supervisor.toString());
    };
    
    public void delete(int id) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Supervisor/"+String.valueOf(id), "DELETE", null);
    };
	
}
