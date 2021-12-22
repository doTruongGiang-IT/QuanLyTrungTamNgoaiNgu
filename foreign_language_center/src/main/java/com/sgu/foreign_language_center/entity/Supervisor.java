package com.sgu.foreign_language_center.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "supervisors")
public class Supervisor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@JsonBackReference
//	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name="room_id", nullable=false)
    private Room room;

	@NotNull
	@NotBlank(message = "First name is required")
	@Size(min = 2, message = "First name should have at least 2 characters")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@NotBlank(message = "Last name is required")
	@Size(min = 2, message = "Last name should have at least 2 characters")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
    @NotBlank(message = "Gender is required")
    @Column(name = "gender")
    private String gender;

	@NotNull
    @NotBlank(message = "Place provide is required")
    @Size(min = 10, message = "Phone number should have at least 10 characters")
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @NotNull
    @NotEmpty
	@Email
	@Column(name = "email", unique=true)
	private String email;
    
    public Supervisor() {}

	public Supervisor(Room room,
			@NotNull @NotBlank(message = "First name is required") @Size(min = 2, message = "First name should have at least 2 characters") String firstName,
			@NotNull @NotBlank(message = "Last name is required") @Size(min = 2, message = "Last name should have at least 2 characters") String lastName,
			@NotNull @NotBlank(message = "Gender is required") String gender,
			@NotNull @NotBlank(message = "Place provide is required") @Size(min = 10, message = "Phone number should have at least 10 characters") String phoneNumber,
			@NotNull @NotEmpty @Email String email) {
		super();
		this.room = room;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
