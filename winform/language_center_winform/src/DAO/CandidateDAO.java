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

public class CandidateDAO {

	private List<CandidateDTO> candidates = null;
	private String API_URL = "";
	
	public CandidateDAO() {};
	
	public List<CandidateDTO> getCandidates() {
		candidates = new ArrayList<CandidateDTO>();
		ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("Candidate", "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		try {
				JSONArray list = res.data.getJSONArray("data");
				for(int i=0; i<list.length();i++) {
					JSONObject jsonObj = (JSONObject) list.get(i);
					candidates.add(new CandidateDTO(jsonObj));
				};
			} catch (JSONException e) {
				e.printStackTrace();
			}
    	};
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
    	System.out.println(candidate.toJSONObject().toString());
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
    
    public static void main(String args[]) {
		CandidateDAO candidateDAO = new CandidateDAO();
		List<CandidateDTO> dtos = candidateDAO.getCandidates();
		if(dtos != null) {
			for(int i=0; i< dtos.size(); i++) {
				System.out.println(dtos.get(i).getId());
				System.out.println(dtos.get(i).getIdentification());
				System.out.println(dtos.get(i).getFirst_name());
				System.out.println(dtos.get(i).getLast_name());
				System.out.println(dtos.get(i).getEmail());
				System.out.println(dtos.get(i).getGender());
				System.out.println(dtos.get(i).getDay_of_birth());
				System.out.println(dtos.get(i).getPlace_of_birth());
				System.out.println(dtos.get(i).getIssue_date());
				System.out.println(dtos.get(i).getIssue_place());
				System.out.println(dtos.get(i).getPhone());
				System.out.println("=====================");
			};
		};
	};
	
}
