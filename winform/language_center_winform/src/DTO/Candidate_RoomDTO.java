package DTO;

public class Candidate_RoomDTO {

	private int id;
	private int candidate_id;
	private int room_id;
	private String candidate_no;
	private float score_listening;
	private float score_writing;
	private float score_speaking;
	private float score_reading;
	
	public Candidate_RoomDTO() {}

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
	
}
