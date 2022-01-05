package DTO;

import org.json.JSONException;
import org.json.JSONObject;

public class SupervisorDTO {

	private int id;
	private String name;
	
	public SupervisorDTO() {};
	
	public SupervisorDTO(JSONObject data) {
		try {
			this.id = data.getInt("id");
			this.name = data.getString("name");
		} catch (JSONException e) {
			System.out.println("Supervisor error convert json -> dto");
		}
	};

	public SupervisorDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SupervisorDTO(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", this.id);
			obj.put("name", this.name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Convert to JSON error" + e);
		}
		return obj;
	}
	
}
