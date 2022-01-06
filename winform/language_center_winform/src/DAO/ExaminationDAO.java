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

public class ExaminationDAO {

    private List<ExaminationDTO> examinations = null;

    public ExaminationDAO() {
    }

    public List<ExaminationDTO> getExaminations() {
        examinations = new ArrayList<ExaminationDTO>();
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Examination", "GET", null);
        if (200 <= res.status_code && res.status_code <= 299) {
            try {
                JSONArray list = res.data.getJSONArray("data");
                for (int i = 0; i < list.length(); i++) {
                    JSONObject jsonObj = (JSONObject) list.get(i);
                    examinations.add(new ExaminationDTO(jsonObj));
                };
                
                return examinations;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        };
        return null;
    }

    public ExaminationDTO getExamination(int id) {
        ExaminationDTO examinationDTO = null;
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Examination/" + String.valueOf(id), "GET", null);
        if (200 <= res.status_code && res.status_code <= 299) {
            examinationDTO = new ExaminationDTO(res.data);
        } else {
            examinationDTO = null;
        };
        return examinationDTO;
    }

    public ExaminationDTO getCurrentExamination() {
        ExaminationDTO examinationDTO = null;
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Examination/current", "GET", null);
        if (200 <= res.status_code && res.status_code <= 299) {
            examinationDTO = new ExaminationDTO(res.data);
        } else {
            examinationDTO = null;
        };
        return examinationDTO;
    }

    public ExaminationDTO insert(ExaminationDTO examination) {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Examination", "POST", examination.toJSONObject().toString());

        if (200 <= res.status_code && res.status_code <= 299) {
            return new ExaminationDTO(res.data);
        }
        return null;
    }

    public boolean update(ExaminationDTO examination) throws Exception {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Examination", "PUT", examination.toJSONObject().toString());

        if (200 <= res.status_code && res.status_code <= 299) {
            return true;
        }

        return false;
    }

    public boolean delete(int id) throws Exception {
        ApiConnection apiConn = new ApiConnection();
        Response res = apiConn.callAPI("Examination/" + String.valueOf(id), "DELETE", null);

        if (200 <= res.status_code && res.status_code <= 299) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        ExaminationDAO examDAO = new ExaminationDAO();
//		List<ExaminationDTO> dtos = examDAO.getExaminations();
        ExaminationDTO dto = examDAO.getCurrentExamination();
//		if(dtos != null) {
//			for(int i=0; i< dtos.size(); i++) {
//				System.out.println(dtos.get(i).getId());
//				System.out.println(dtos.get(i).getName());
//				System.out.println(dtos.get(i).getDate());
//				System.out.println("=====================");
//			};
//		};
        if (dto != null) {
            System.out.println(dto.getId());
            System.out.println(dto.getName());
            System.out.println(dto.getDate());
        };
    }

}
