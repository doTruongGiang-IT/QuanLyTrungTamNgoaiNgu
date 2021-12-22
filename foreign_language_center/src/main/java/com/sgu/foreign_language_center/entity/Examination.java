package com.sgu.foreign_language_center.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "examinations")
public class Examination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long examination_id;
	
	@NotNull
	@NotBlank(message = "Examinations name is required")
	@Size(min = 2, message = "Examinations name should have at least 2 characters")
	@Column(name = "name")
	private String name;
	
	@NotNull
    @NotBlank(message = "Exam date is required")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "exam_date")
	private String examDate;
	
//	@JsonManagedReference
//	@JsonBackReference
	@OneToMany(mappedBy="examination")
    private Set<Room> rooms;
	
	public Examination() {};

	public Examination(
			@NotNull @NotBlank(message = "Examinations name is required") @Size(min = 2, message = "Examinations name should have at least 2 characters") String name,
			@NotNull @NotBlank(message = "Exam date is required") String examDate, Set<Room> rooms) {
		super();
		this.name = name;
		this.examDate = examDate;
		this.rooms = rooms;
	};

	public long getId() {
		return examination_id;
	};

	public void setId(long id) {
		this.examination_id = id;
	};

	public String getName() {
		return name;
	};

	public void setName(String name) {
		this.name = name;
	};

	public String getExamDate() {
		return examDate;
	};

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	};

	public Set<Room> getRooms() {
		return rooms;
	};

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	};
	
}
