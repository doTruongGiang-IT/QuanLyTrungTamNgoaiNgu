package DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import DTO.ExaminationDTO;

public class ExaminationDAO {

	private List<ExaminationDTO> examinations = null;
	
	public ExaminationDAO() {};
	
	public List<ExaminationDTO> getExaminations() {
		examinations = new ArrayList<ExaminationDTO>();
//		HttpClient client = HttpClient.newHttpClient();
//	    HttpRequest request = HttpRequest.newBuilder()
//	            .uri(new URI(API_URL))
//	            .headers("Content-Type", "application/json;charset=UTF-8")
//	            .GET()
//	            .build();
//	    HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        JSONObject responseObj = new JSONObject(response.body().toString());
//        System.out.println(responseObj);
        return examinations;
    };
    
    public ExaminationDTO getExamination(int id) {
    	ExaminationDTO examinationDTO = null;
    	ApiConnection apiConn = new ApiConnection();
    	Response res = apiConn.callAPI("Examination/"+String.valueOf(id), "GET", null);
    	if(200 <= res.status_code && res.status_code <= 299) {
    		examinationDTO = new ExaminationDTO(res.data);
    	}else {
    		examinationDTO = null;
    	};
        return examinationDTO;
    };
    
    public void insert(ExaminationDTO examination) {
    	ApiConnection apiConn = new ApiConnection();
    	Response res =  apiConn.callAPI("Examination", "POST", examination.toJSONObject().toString());
    	System.out.println(res.status_code);
    };
    
    public void update(ExaminationDTO examination) throws Exception {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Examination", "PUT", examination.toJSONObject().toString());
    };
    
    public void delete(int id) throws Exception {
    	ApiConnection apiConn = new ApiConnection();
    	apiConn.callAPI("Examination/"+String.valueOf(id), "DELETE", null);
    };
    
    public static void main(String args[]) {
		ExaminationDAO examDAO = new ExaminationDAO();
		ExaminationDTO dto = examDAO.getExamination(1);
		if(dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getDate());
		};
	};
   
}
