package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.CandidateDTO;
import DTO.RoomDTO;

public class CandidateDAO {

	private List<CandidateDTO> candidates = null;
	private String API_URL = "";
	
	public CandidateDAO() {};
	
	public List<CandidateDTO> getCandidates() {
		candidates = new ArrayList<CandidateDTO>();
//		HttpClient client = HttpClient.newHttpClient();
//	    HttpRequest request = HttpRequest.newBuilder()
//	            .uri(new URI(API_URL))
//	            .headers("Content-Type", "application/json;charset=UTF-8")
//	            .GET()
//	            .build();
//	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        JSONObject responseObj = new JSONObject(response.body().toString());
//        System.out.println(responseObj);
        return candidates;
    };
    
    public CandidateDTO getCandidate(int id) {
    	CandidateDTO candidateDTO = null;
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("Candidate/"+String.valueOf(id), "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		candidateDTO = new CandidateDTO(res.data);
    	}else {
    		candidateDTO = null;
    	};
        return candidateDTO;
    };
    
    public void insert(CandidateDTO candidate) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Candidate", "POST", candidate.toJSONObject().toString());
    };
    
    public void update(CandidateDTO candidate) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Candidate", "PUT", candidate.toJSONObject().toString());
    };
    
    public void delete(int id) {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Candidate/"+String.valueOf(id), "DELETE", null);
    };
	
}
