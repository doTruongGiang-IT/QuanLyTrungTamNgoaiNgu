package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.Registration_FormsDTO;

public class Registration_FormsDAO {

	private List<Registration_FormsDTO> registration_forms = null;
	private String API_URL = "";
	
	public Registration_FormsDAO() {};
	
	public List<Registration_FormsDTO> getRegistration_Forms() throws Exception {
		registration_forms = new ArrayList<Registration_FormsDTO>();
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .GET()
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
        return registration_forms;
    };
    
    public Registration_FormsDTO getRegistration_Form(int id) throws Exception {
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
    
    public void insert(Registration_FormsDTO registration_form) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .POST(HttpRequest.BodyPublishers.ofString(registration_form.toString()))
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
    };
    
    public void update(Registration_FormsDTO registration_form) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .PUT(HttpRequest.BodyPublishers.ofString(registration_form.toString()))
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
