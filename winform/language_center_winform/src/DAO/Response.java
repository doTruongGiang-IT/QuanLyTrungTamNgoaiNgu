package DAO;

import org.json.JSONObject;

public class Response {
	
	public int status_code;
	public JSONObject data;
	
	public Response(int status_code, JSONObject data) {
		this.status_code = status_code;
		this.data = data;
	};
	
}
