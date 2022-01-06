package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

import DTO.ExaminationDTO;
import DTO.SupervisorDTO;
import DTO.Supervisor_RoomDTO;

public class Supervisor_RoomDAO {

	private List<Supervisor_RoomDTO> supervisor_rooms = null;
	private String API_URL = "";
	
	public Supervisor_RoomDAO() {};
	
	public List<Supervisor_RoomDTO> getSupervisor_Rooms() {
		supervisor_rooms = new ArrayList<Supervisor_RoomDTO>();
//		HttpClient client = HttpClient.newHttpClient();
//	    HttpRequest request = HttpRequest.newBuilder()
//	            .uri(new URI(API_URL))
//	            .headers("Content-Type", "application/json;charset=UTF-8")
//	            .GET()
//	            .build();
//	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        JSONObject responseObj = new JSONObject(response.body().toString());
//        System.out.println(responseObj);
        return supervisor_rooms;
    };
    
    public Supervisor_RoomDTO getSupervisor_Room(int id) {
    	Supervisor_RoomDTO supervisor_roomDTO = null;
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("SupervisorRoom/"+String.valueOf(id), "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		supervisor_roomDTO = new Supervisor_RoomDTO(res.data);
    	}else {
    		supervisor_roomDTO = null;
    	};
        return supervisor_roomDTO;
    };
    
    public void insert(Supervisor_RoomDTO supervisor_room) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("SupervisorRoom", "POST", supervisor_room.toJSONObject().toString());
    };
    
    public void update(Supervisor_RoomDTO supervisor_room) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("SupervisorRoom", "PUT", supervisor_room.toJSONObject().toString());
    };
    
    public void delete(int id) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("SupervisorRoom/"+String.valueOf(id), "DELETE", null);
    };
    
	
}
