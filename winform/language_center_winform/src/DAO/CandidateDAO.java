package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.CandidateDTO;

public class CandidateDAO {

	private List<CandidateDTO> candidates = null;
	private String API_URL = "";
	
	public CandidateDAO() {};
	
	public List<CandidateDTO> getCandidates() throws Exception {
		candidates = new ArrayList<CandidateDTO>();
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .GET()
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
        return candidates;
    };
    
    public CandidateDTO getCandidate(int id) throws Exception {
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
    
    public void insert(CandidateDTO candidate) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .POST(HttpRequest.BodyPublishers.ofString(candidate.toString()))
	            .build();
	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject responseObj = new JSONObject(response.body().toString());
        System.out.println(responseObj);
    };
    
    public void update(CandidateDTO candidate) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(API_URL))
	            .headers("Content-Type", "application/json;charset=UTF-8")
	            .PUT(HttpRequest.BodyPublishers.ofString(candidate.toString()))
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
