package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.Candidate_RoomDTO;
import DTO.Supervisor_RoomDTO;

public class Candidate_RoomDAO {

	private List<Candidate_RoomDTO> candidate_rooms = null;
	private String API_URL = "";
	
	public Candidate_RoomDAO() {};
	
	public List<Candidate_RoomDTO> getCandidate_Rooms() {
		candidate_rooms = new ArrayList<Candidate_RoomDTO>();
//		HttpClient client = HttpClient.newHttpClient();
//	    HttpRequest request = HttpRequest.newBuilder()
//	            .uri(new URI(API_URL))
//	            .headers("Content-Type", "application/json;charset=UTF-8")
//	            .GET()
//	            .build();
//	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        JSONObject responseObj = new JSONObject(response.body().toString());
//        System.out.println(responseObj);
        return candidate_rooms;
    };
    
    public Candidate_RoomDTO getCandidate_Room(int id) {
    	Candidate_RoomDTO candidate_roomDTO = null;
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("CandidateRoom/"+String.valueOf(id), "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		candidate_roomDTO = new Candidate_RoomDTO(res.data);
    	}else {
    		candidate_roomDTO = null;
    	};
        return candidate_roomDTO;
    };
    
    public void insert(Candidate_RoomDTO candidate_room) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("CandidateRoom", "POST", candidate_room.toJSONObject().toString());
    };
    
    public void update(Candidate_RoomDTO candidate_room) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("CandidateRoom", "PUT", candidate_room.toJSONObject().toString());
    };
    
    public void delete(int id) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("CandidateRoom/"+String.valueOf(id), "DELETE", null);

    };
	
}
