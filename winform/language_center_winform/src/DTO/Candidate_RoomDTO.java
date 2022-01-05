package DTO;

import org.json.JSONException;
import org.json.JSONObject;

public class Candidate_RoomDTO {

	private int id;
	private int candidate_id;
	private int room_id;
	private String candidate_no;
	private float score_listening;
	private float score_writing;
	private float score_speaking;
	private float score_reading;
	
	public Candidate_RoomDTO() {};
	
	public Candidate_RoomDTO(JSONObject data) {
		try {
			this.id = data.getInt("id");
			this.candidate_id = data.getInt("candidate_id");
			this.room_id = data.getInt("room_id");
			this.candidate_no = data.getString("candidate_no");
			this.score_listening = (float) data.getDouble("score_listening");
			this.score_writing = (float) data.getDouble("score_writing");
			this.score_speaking = (float) data.getDouble("score_speaking");
			this.score_reading = (float) data.getDouble("score_reading");
		} catch (JSONException e) {
			System.out.println("Supervisor_room error convert json -> dto");
		}
	};

	public Candidate_RoomDTO(int id, int candidate_id, int room_id, String candidate_no, float score_listening,
			float score_writing, float score_speaking, float score_reading) {
		super();
		this.id = id;
		this.candidate_id = candidate_id;
		this.room_id = room_id;
		this.candidate_no = candidate_no;
		this.score_listening = score_listening;
		this.score_writing = score_writing;
		this.score_speaking = score_speaking;
		this.score_reading = score_reading;
	}

	public Candidate_RoomDTO(int candidate_id, int room_id, String candidate_no, float score_listening,
			float score_writing, float score_speaking, float score_reading) {
		super();
		this.candidate_id = candidate_id;
		this.room_id = room_id;
		this.candidate_no = candidate_no;
		this.score_listening = score_listening;
		this.score_writing = score_writing;
		this.score_speaking = score_speaking;
		this.score_reading = score_reading;
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

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getCandidate_no() {
		return candidate_no;
	}

	public void setCandidate_no(String candidate_no) {
		this.candidate_no = candidate_no;
	}

	public float getScore_listening() {
		return score_listening;
	}

	public void setScore_listening(float score_listening) {
		this.score_listening = score_listening;
	}

	public float getScore_writing() {
		return score_writing;
	}

	public void setScore_writing(float score_writing) {
		this.score_writing = score_writing;
	}

	public float getScore_speaking() {
		return score_speaking;
	}

	public void setScore_speaking(float score_speaking) {
		this.score_speaking = score_speaking;
	}

	public float getScore_reading() {
		return score_reading;
	}

	public void setScore_reading(float score_reading) {
		this.score_reading = score_reading;
	}
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", this.id);
			obj.put("canidadate_id",candidate_id);
			obj.put("room_id",room_id);
			obj.put("candidate_no",candidate_no);
			obj.put("score_listening",score_listening);
			obj.put("score_writing",score_writing);
			obj.put("score_speaking",score_speaking);
			obj.put("score_reading",score_reading);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Convert to JSON error" + e);
		}
		return obj;
	}
	
}
