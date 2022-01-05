package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.RoomDTO;

public class RoomDAO {

	private List<RoomDTO> rooms = null;
	private String API_URL = "";
	
	public RoomDAO() {};
	
	public List<RoomDTO> getRooms() {
		rooms = new ArrayList<RoomDTO>();
//		HttpClient client = HttpClient.newHttpClient();
//	    HttpRequest request = HttpRequest.newBuilder()
//	            .uri(new URI(API_URL))
//	            .headers("Content-Type", "application/json;charset=UTF-8")
//	            .GET()
//	            .build();
//	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        JSONObject responseObj = new JSONObject(response.body().toString());
//        System.out.println(responseObj);
        return rooms;
    };
    
    public RoomDTO getRoom(int id) {
    	RoomDTO roomDTO = null;
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("Room/"+String.valueOf(id), "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		roomDTO = new RoomDTO(res.data);
    	}else {
    		roomDTO = null;
    	};
        return roomDTO;
    };
    
    public void insert(RoomDTO room) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Room", "POST", room.toString());
    };
    
    public void update(RoomDTO room) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Room", "PUT", room.toString());
    };
    
    public void delete(int id) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Room/"+String.valueOf(id), "DELETE", null);
    };
	
}
