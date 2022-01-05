package DTO;

import org.json.JSONException;
import org.json.JSONObject;

public class ExaminationDTO {
	private int id;
	private String name;
	private String date;
	
	public ExaminationDTO(){};
	
	public ExaminationDTO(JSONObject data) {
		try {
			this.id = data.getInt("id");
			this.name = data.getString("name");
			this.date = data.getString("date");
		} catch (JSONException e) {
			System.out.println("Examination error convert json -> dto");
		}
	};
	
	public ExaminationDTO(int id, String name, String date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	};

	public ExaminationDTO(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	};

	public int getId() {
		return id;
	};
	
	public void setId(int id) {
		this.id = id;
	};
	
	public String getName() {
		return name;
	};
	
	public void setName(String name) {
		this.name = name;
	};
	
	public String getDate() {
		return date;
	};
	
	public void setDate(String date) {
		this.date = date;
	};
}
