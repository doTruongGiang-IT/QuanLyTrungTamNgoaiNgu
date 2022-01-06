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

import DTO.CandidateDTO;
import DTO.RoomDTO;
import DTO.SupervisorDTO;

public class SupervisorDAO {

	private List<SupervisorDTO> supervisors = null;
	private String API_URL = "";
	
	public SupervisorDAO() {};
	
	public List<SupervisorDTO> getSupervisors() {
		supervisors = new ArrayList<SupervisorDTO>();
		ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("Supervisor", "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		try {
				JSONArray list = res.data.getJSONArray("data");
				for(int i=0; i<list.length();i++) {
					JSONObject jsonObj = (JSONObject) list.get(i);
					supervisors.add(new SupervisorDTO(jsonObj));
				};
			} catch (JSONException e) {
				e.printStackTrace();
			}
    	};
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
    	apiConn.callAPI("Supervisor", "POST", supervisor.toJSONObject().toString());
    };
    
    public void update(SupervisorDTO supervisor) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Supervisor", "PUT", supervisor.toJSONObject().toString());
    };
    
    public void delete(int id) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Supervisor/"+String.valueOf(id), "DELETE", null);
    };
    
    public static void main(String args[]) {
		SupervisorDAO dao = new SupervisorDAO();
		List<SupervisorDTO> dtoList = new ArrayList<SupervisorDTO>();
		dtoList = dao.getSupervisors();
		for (SupervisorDTO supervisorDTO : dtoList) {
			if(supervisorDTO != null) {
				System.out.println(supervisorDTO.getId());
				System.out.println(supervisorDTO.getName());
			}
			else {
				System.out.println("Nothing here");
			}
		};
	};
}
