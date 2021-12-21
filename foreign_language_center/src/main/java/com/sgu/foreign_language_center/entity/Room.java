package com.sgu.foreign_language_center.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long room_id;
	
	@JsonManagedReference
	@OneToMany(mappedBy="room")
    private Set<Supervisor> supervisors;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name="examination_id", nullable=false)
    private Examination examination;
	
	@OneToOne(mappedBy="room")
    private CandidatesInRoom candidatesInRoom;
	
	@NotNull
	@NotBlank(message = "Exam time is required")
	@Column(name="exam_time")
	private String examTime;
	
	@NotNull
	@NotBlank(message = "Level is required")
	@Column(name="level")
	private String level;
	
	@NotNull
	@NotBlank(message = "Room identify is required")
	@Column(name="room_identify")
	private String roomIdentify;
	
	public Room() {}

	public Room(Set<Supervisor> supervisors, Examination examination, CandidatesInRoom candidatesInRoom,
			@NotNull @NotBlank(message = "Exam time is required") String examTime,
			@NotNull @NotBlank(message = "Level is required") String level,
			@NotNull @NotBlank(message = "Room identify is required") String roomIdentify) {
		super();
		this.supervisors = supervisors;
		this.examination = examination;
		this.candidatesInRoom = candidatesInRoom;
		this.examTime = examTime;
		this.level = level;
		this.roomIdentify = roomIdentify;
	}

	public long getId() {
		return room_id;
	}

	public void setId(long id) {
		this.room_id = id;
	}

	public Set<Supervisor> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(Set<Supervisor> supervisors) {
		this.supervisors = supervisors;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public CandidatesInRoom getCandidatesInRoom() {
		return candidatesInRoom;
	}

	public void setCandidatesInRoom(CandidatesInRoom candidatesInRoom) {
		this.candidatesInRoom = candidatesInRoom;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRoomIdentify() {
		return roomIdentify;
	}

	public void setRoomIdentify(String roomIdentify) {
		this.roomIdentify = roomIdentify;
	}
}
