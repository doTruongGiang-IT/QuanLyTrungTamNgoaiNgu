package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.Candidate_RoomDTO;

public class Candidate_RoomDAO {

	private List<Candidate_RoomDTO> candidate_rooms = null;
	private String API_URL = "";
	
	public Candidate_RoomDAO() {};
	
	public List<Candidate_RoomDTO> getCandidate_Rooms() throws Exception {
		candidate_rooms = new ArrayList<Candidate_RoomDTO>();
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .GET()
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
        return candidate_rooms;
    };
    
    public Candidate_RoomDTO getCandidate_Room(int id) throws Exception {
    	HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .GET()
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
        return null;
    };
    
    public void insert(Candidate_RoomDTO candidate_room) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .POST(HttpRequest.BodyPublishers.ofString(candidate_room.toString()))
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
    };
    
    public void update(Candidate_RoomDTO candidate_room) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .PUT(HttpRequest.BodyPublishers.ofString(candidate_room.toString()))
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
    };
    
    public void delete(int id) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .DELETE()
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
    };
	
}
