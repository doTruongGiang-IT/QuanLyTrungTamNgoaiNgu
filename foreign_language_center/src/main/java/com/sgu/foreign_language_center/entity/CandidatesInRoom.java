package com.sgu.foreign_language_center.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CandidatesInRoom")
public class CandidatesInRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long candidates_in_room_id;

//	@JsonManagedReference
//	@JsonBackReference
	@ManyToOne
//	@PrimaryKeyJoinColumn
    @JoinColumn(name="identity_card", nullable=false)
    private Candidate candidate;

//	@JsonManagedReference
//	@JsonBackReference
	@ManyToOne
//	@PrimaryKeyJoinColumn
    @JoinColumn(name="room_id", nullable=false)
    private Room room;
	
	@NotNull
	@NotBlank(message = "candidate number is required")
	@Column(name="candidate_number")
	private String candidateNumber;
	
	@NotNull
//	@NotBlank(message = "Listening score is required")
	@Column(name="listening_score")
	private float listeningScore;
	
	@NotNull
//	@NotBlank(message = "Reading score is required")
	@Column(name="reading_score")
	private float readingScore;
	
	@NotNull
//	@NotBlank(message = "Speaking score is required")
	@Column(name="speaking_score")
	private float speakingScore;
	
	@NotNull
//	@NotBlank(message = "Writing score is required")
	@Column(name="writing_score")
	private float writingScore;
	
	public CandidatesInRoom() {};

	public CandidatesInRoom(
			Candidate candidate, Room room,
			@NotNull @NotBlank(message = "candidate number is required") String candidateNumber,
			@NotNull @NotBlank(message = "Listening score is required") float listeningScore,
			@NotNull @NotBlank(message = "Reading score is required") float readingScore,
			@NotNull @NotBlank(message = "Speaking score is required") float speakingScore,
			@NotNull @NotBlank(message = "Writing score is required") float writingScore) {
		super();
		this.candidate = candidate;
		this.room = room;
		this.candidateNumber = candidateNumber;
		this.listeningScore = listeningScore;
		this.readingScore = readingScore;
		this.speakingScore = speakingScore;
		this.writingScore = writingScore;
	}

	public long getId() {
		return candidates_in_room_id;
	}

	public void setId(long id) {
		this.candidates_in_room_id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidates(Candidate candidate) {
		this.candidate = candidate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getCandidateNumber() {
		return candidateNumber;
	}

	public void setCandidateNumber(String candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

	public float getListeningScore() {
		return listeningScore;
	}

	public void setListeningScore(float listeningScore) {
		this.listeningScore = listeningScore;
	}

	public float getReadingScore() {
		return readingScore;
	}

	public void setReadingScore(float readingScore) {
		this.readingScore = readingScore;
	}

	public float getSpeakingScore() {
		return speakingScore;
	}

	public void setSpeakingScore(float speakingScore) {
		this.speakingScore = speakingScore;
	}

	public float getWritingScore() {
		return writingScore;
	}

	public void setWritingScore(float writingScore) {
		this.writingScore = writingScore;
	}
	
}
