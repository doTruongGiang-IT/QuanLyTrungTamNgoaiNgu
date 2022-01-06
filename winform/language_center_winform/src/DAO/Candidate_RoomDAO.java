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
import DTO.Candidate_RoomDTO;
import DTO.Supervisor_RoomDTO;

public class Candidate_RoomDAO {

	private List<Candidate_RoomDTO> candidate_rooms = null;
	private String API_URL = "";
	
	public Candidate_RoomDAO() {};
	
	public List<Candidate_RoomDTO> getCandidate_Rooms() {
		candidate_rooms = new ArrayList<Candidate_RoomDTO>();
		ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("CandidateRoom", "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		try {
				JSONArray list = res.data.getJSONArray("data");
				for(int i=0; i<list.length();i++) {
					JSONObject jsonObj = (JSONObject) list.get(i);
					candidate_rooms.add(new Candidate_RoomDTO(jsonObj));
				};
			} catch (JSONException e) {
				e.printStackTrace();
			}
    	};
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
    
    public boolean insert(Candidate_RoomDTO candidate_room) {
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("CandidateRoom", "POST", candidate_room.toJSONObject().toString());
    	
    	if (200 <= res.status_code && res.status_code <= 299) {
    		return true;
    	}
    	return false;
    };
    
    public boolean update(Candidate_RoomDTO candidate_room) {
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("CandidateRoom", "PUT", candidate_room.toJSONObject().toString());
    	
    	if (200 <= res.status_code && res.status_code <= 299) {
    		return true;
    	}
    	return false;
    };
    
    public boolean delete(int id) {
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("CandidateRoom/"+String.valueOf(id), "DELETE", null);
    	
    	if (200 <= res.status_code && res.status_code <= 299) {
    		return true;
    	}
    	return false;
    };
    
    public static void main(String args[]) {
    	Candidate_RoomDAO candidate_roomDAO = new Candidate_RoomDAO();
		List<Candidate_RoomDTO> dtos = candidate_roomDAO.getCandidate_Rooms();
		if(dtos != null) {
			for(int i=0; i< dtos.size(); i++) {
				System.out.println(dtos.get(i).getId());
				System.out.println(dtos.get(i).getCandidate_id());
				System.out.println(dtos.get(i).getCandidate_no());
				System.out.println(dtos.get(i).getRoom_id());
				System.out.println(dtos.get(i).getScore_listening());
				System.out.println(dtos.get(i).getScore_reading());
				System.out.println(dtos.get(i).getScore_writing());
				System.out.println(dtos.get(i).getScore_speaking());
				System.out.println("=====================");
			};
		};
	};
	
}
