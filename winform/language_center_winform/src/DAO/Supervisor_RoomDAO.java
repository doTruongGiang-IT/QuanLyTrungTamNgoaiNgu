package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.Supervisor_RoomDTO;

public class Supervisor_RoomDAO {

	private List<Supervisor_RoomDTO> supervisor_rooms = null;
	private String API_URL = "";
	
	public Supervisor_RoomDAO() {};
	
	public List<Supervisor_RoomDTO> getSupervisor_Rooms() throws Exception {
		supervisor_rooms = new ArrayList<Supervisor_RoomDTO>();
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .GET()
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
        return supervisor_rooms;
    };
    
    public Supervisor_RoomDTO getSupervisor_Room(int id) throws Exception {
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
    
    public void insert(Supervisor_RoomDTO supervisor_room) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .POST(HttpRequest.BodyPublishers.ofString(supervisor_room.toString()))
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
    };
    
    public void update(Supervisor_RoomDTO supervisor_room) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .PUT(HttpRequest.BodyPublishers.ofString(supervisor_room.toString()))
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
