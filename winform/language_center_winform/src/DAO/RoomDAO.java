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

import DTO.ExaminationDTO;
import DTO.RoomDTO;

public class RoomDAO {

    private List<RoomDTO> rooms = null;
    private String API_URL = "";

    public RoomDAO() {
    }

    public List<RoomDTO> getRooms() {
        rooms = new ArrayList<RoomDTO>();
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Room", "GET", null);
        if (200 <= res.status_code && res.status_code <= 299) {
            try {
                JSONArray list = res.data.getJSONArray("data");
                for (int i = 0; i < list.length(); i++) {
                    JSONObject jsonObj = (JSONObject) list.get(i);
                    rooms.add(new RoomDTO(jsonObj));
                };
                
                return rooms;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        };
        
        return null;
    }

    public RoomDTO getRoom(int id) {
        RoomDTO roomDTO = null;
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Room/" + String.valueOf(id), "GET", null);
        if (200 <= res.status_code && res.status_code <= 299) {
            roomDTO = new RoomDTO(res.data);
        } else {
            roomDTO = null;
        };
        return roomDTO;
    }
    
    public RoomDTO getRoomByExamination(int id) {
        RoomDTO roomDTO = null;
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Room/" + String.valueOf(id), "GET", null);
        if (200 <= res.status_code && res.status_code <= 299) {
            roomDTO = new RoomDTO(res.data);
        } else {
            roomDTO = null;
        };
        return roomDTO;
    }

    public RoomDTO insert(RoomDTO room) {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Room", "POST", room.toJSONObject().toString());
        if (200 <= res.status_code && res.status_code <= 299) {
            return new RoomDTO(res.data);
        }
        return null;
    }

    public boolean update(RoomDTO room) {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Room", "PUT", room.toJSONObject().toString());
        
        if (200 <= res.status_code && res.status_code <= 299) {
            return true;
        }

        return false;
    }

    public boolean delete(int id) {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Room/" + String.valueOf(id), "DELETE", null);
        
        if (200 <= res.status_code && res.status_code <= 299) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        RoomDAO roomDAO = new RoomDAO();
        List<RoomDTO> dtos = roomDAO.getRooms();
        if (dtos != null) {
            for (int i = 0; i < dtos.size(); i++) {
                System.out.println(dtos.get(i).getId());
                System.out.println(dtos.get(i).getName());
                System.out.println(dtos.get(i).getExamination_id());
                System.out.println(dtos.get(i).getLevel());
                System.out.println(dtos.get(i).getTime());
                System.out.println("=====================");
            };
        };
    }

}
