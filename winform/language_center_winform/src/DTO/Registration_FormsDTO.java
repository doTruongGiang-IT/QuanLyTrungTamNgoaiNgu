package DTO;

import org.json.JSONException;
import org.json.JSONObject;

public class Registration_FormsDTO {

	private int id;
	private int candidate_id;
	private int examination_id;
	private String level;
	private boolean status;
	
	public Registration_FormsDTO() {};
	
	public Registration_FormsDTO(JSONObject data) {
		try {
			this.id = data.getInt("id");
			this.candidate_id = data.getInt("candidate_id");
			this.examination_id = data.getInt("examination_id");
			this.level = data.getString("level");
			this.status = data.getBoolean("status");
		} catch (JSONException e) {
			System.out.println("Supervisor error convert json -> dto");
		}
	};

	public Registration_FormsDTO(int id, int candidate_id, int examination_id, String level, boolean status) {
		super();
		this.id = id;
		this.candidate_id = candidate_id;
		this.examination_id = examination_id;
		this.level = level;
		this.status = status;
	}

	public Registration_FormsDTO(int candidate_id, int examination_id, String level, boolean status) {
		super();
		this.candidate_id = candidate_id;
		this.examination_id = examination_id;
		this.level = level;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public int getExamination_id() {
		return examination_id;
	}

	public void setExamination_id(int examination_id) {
		this.examination_id = examination_id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
