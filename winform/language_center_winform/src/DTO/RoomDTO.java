package DTO;

import org.json.JSONException;
import org.json.JSONObject;

public class RoomDTO {
	private int id;
	private int examination_id;
	private String name;
	private String level;
	private boolean time;
	
	public RoomDTO() {};
	
	public RoomDTO(JSONObject data) {
		try {
			this.id = data.getInt("id");
			this.examination_id = data.getInt("examination_id");
			this.name = data.getString("name");
			this.level = data.getString("level");
			this.time = data.getBoolean("time");
		} catch (JSONException e) {
			System.out.println("Room error convert json -> dto");
		}
	};

	public RoomDTO(int id, int examination_id, String name, String level, boolean time) {
		super();
		this.id = id;
		this.examination_id = examination_id;
		this.name = name;
		this.level = level;
		this.time = time;
	};

	public RoomDTO(int examination_id, String name, String level, boolean time) {
		super();
		this.examination_id = examination_id;
		this.name = name;
		this.level = level;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExamination_id() {
		return examination_id;
	}

	public void setExamination_id(int examination_id) {
		this.examination_id = examination_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public boolean getTime() {
		return time;
	}

	public void setTime(boolean time) {
		this.time = time;
	};
	
}
