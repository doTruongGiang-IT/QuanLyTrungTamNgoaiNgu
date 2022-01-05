package DAO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiConnection {
	
	private String API_URL = "http://localhost:8079/api/";
	// method: GET - POST - PUT - DELETE
	public Response callAPI(String endpoint, String method, String body) {
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = null;
	    Response obj = null;
		try {
			switch(method) {
				case "GET":
					request = HttpRequest.newBuilder()
			        .uri(new URI(API_URL+endpoint))
			        .headers("Content-Type", "application/json;charset=UTF-8")
			        .GET()
			        .build();
					break;
				case "POST":
					request = HttpRequest.newBuilder()
			        .uri(new URI(API_URL+endpoint))
			        .headers("Content-Type", "application/json;charset=UTF-8")
			        .POST(HttpRequest.BodyPublishers.ofString(body))
			        .build();
					break;
				case "PUT":
					request = HttpRequest.newBuilder()
			        .uri(new URI(API_URL+endpoint))
			        .headers("Content-Type", "application/json;charset=UTF-8")
			        .PUT(HttpRequest.BodyPublishers.ofString(body))
			        .build();
					break;
				case "DELETE":
					request = HttpRequest.newBuilder()
			        .uri(new URI(API_URL+endpoint))
			        .headers("Content-Type", "application/json;charset=UTF-8")
			        .DELETE()
			        .build();
					break;
				default:
					break;
			};
			HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
		    int status_code = response.statusCode();
		    JSONObject data = new JSONObject(response.body().toString());
		    obj = new Response(status_code, data);
		} catch (URISyntaxException e) {
			obj = new Response(404, null);
			return obj;
		} catch (IOException e) {
			obj = new Response(400, null);
			return obj;
		} catch (InterruptedException e) {
			obj = new Response(400, null);
			return obj;
		} catch (JSONException e) {
			obj = new Response(404, null);
			return obj;
		}
		return obj;
		
	};
	
	public static void main(String args[]) {
		ApiConnection conn = new ApiConnection();
		Response res = conn.callAPI("Examination", "POST", "{\"id\": 0,\"name\": \"B1 1\",\"date\": \"2022-11-17\"}");
		System.out.println(res.status_code);
		System.out.println(res.data != null ? res.data.toString() : "Not found");
	};
	
}
