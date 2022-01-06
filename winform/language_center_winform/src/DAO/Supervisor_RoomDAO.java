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

import DTO.Candidate_RoomDTO;
import DTO.ExaminationDTO;
import DTO.SupervisorDTO;
import DTO.Supervisor_RoomDTO;

public class Supervisor_RoomDAO {

    private List<Supervisor_RoomDTO> supervisor_rooms = null;
    private String API_URL = "";

    public Supervisor_RoomDAO() {
    }

    public List<Supervisor_RoomDTO> getSupervisor_Rooms() {
        supervisor_rooms = new ArrayList<Supervisor_RoomDTO>();
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("SupervisorRoom", "GET", null);
        if (200 <= res.status_code && res.status_code <= 299) {
            try {
                JSONArray list = res.data.getJSONArray("data");
                for (int i = 0; i < list.length(); i++) {
                    JSONObject jsonObj = (JSONObject) list.get(i);
                    supervisor_rooms.add(new Supervisor_RoomDTO(jsonObj));
                };        
                
                return supervisor_rooms;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        };
        return null;
    }

    public Supervisor_RoomDTO getSupervisor_Room(int id) {
        Supervisor_RoomDTO supervisor_roomDTO = null;
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("SupervisorRoom/" + String.valueOf(id), "GET", null);
        if (200 <= res.status_code && res.status_code <= 299) {
            supervisor_roomDTO = new Supervisor_RoomDTO(res.data);
        } else {
            supervisor_roomDTO = null;
        };
        return supervisor_roomDTO;
    }

    public Supervisor_RoomDTO insert(Supervisor_RoomDTO supervisor_room) {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("SupervisorRoom", "POST", supervisor_room.toJSONObject().toString());
    
        if (200 <= res.status_code && res.status_code <= 299) {
            return new Supervisor_RoomDTO(res.data);
        }
        
        return null;
    }

    public boolean update(Supervisor_RoomDTO supervisor_room) {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("SupervisorRoom", "PUT", supervisor_room.toJSONObject().toString());
        
        if (200 <= res.status_code && res.status_code <= 299) {
            return true;
        }

        return false;
    }

    public boolean delete(int id) {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("SupervisorRoom/" + String.valueOf(id), "DELETE", null);
                
        if (200 <= res.status_code && res.status_code <= 299) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Supervisor_RoomDAO supervisor_RoomDAO = new Supervisor_RoomDAO();
        List<Supervisor_RoomDTO> dtos = supervisor_RoomDAO.getSupervisor_Rooms();
        if (dtos != null) {
            for (int i = 0; i < dtos.size(); i++) {
                System.out.println(dtos.get(i).getId());
                System.out.println(dtos.get(i).getSupervisor_id());
                System.out.println(dtos.get(i).getRoom_id());
                System.out.println("=====================");
            };
        };
    }

}
