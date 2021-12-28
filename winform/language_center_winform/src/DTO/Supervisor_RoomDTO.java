package DTO;

public class Supervisor_RoomDTO {

	private int id;
	private int supervisor_id;
	private int room_id;
	
	public Supervisor_RoomDTO() {}

	public Supervisor_RoomDTO(int id, int supervisor_id, int room_id) {
		super();
		this.id = id;
		this.supervisor_id = supervisor_id;
		this.room_id = room_id;
	}

	public Supervisor_RoomDTO(int supervisor_id, int room_id) {
		super();
		this.supervisor_id = supervisor_id;
		this.room_id = room_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	
}
