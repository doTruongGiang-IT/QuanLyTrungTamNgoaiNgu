package com.sgu.foreign_language_center.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "examinations")
public class Examination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	
	
	public Examination() {};


	public Examination(
			@NotNull @NotBlank(message = "Examinations name is required") @Size(min = 2, message = "Examinations name should have at least 2 characters") String name,
			@NotNull @NotBlank(message = "Exam date is required") String examDate) {
		super();
		this.name = name;
		this.examDate = examDate;
	};


	public long getId() {
		return id;
	};


	public void setId(long id) {
		this.id = id;
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
	
}
