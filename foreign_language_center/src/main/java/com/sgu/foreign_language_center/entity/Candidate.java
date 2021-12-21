package com.sgu.foreign_language_center.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "candidates")
public class Candidate {
	
	@Id
	private long identityCard;
	
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
    @NotBlank(message = "Day of birth is required")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "day_of_birth")
    private String dayOfBirth;
    
    @NotNull
    @NotBlank(message = "Place of birth is required")
    @Size(min = 4, message = "Place of birth should have at least 4 characters")
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    
    @NotNull
    @NotBlank(message = "Day provide is required")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "day_provide")
    private String dayProvide;
    
    @NotNull
    @NotBlank(message = "Place provide is required")
    @Size(min = 4, message = "Place provide should have at least 4 characters")
    @Column(name = "place_provide")
    private String placeProvide;
    
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
    
    @OneToOne(mappedBy="candidate")
    private CandidatesInRoom candidatesInRoom;
    
    public Candidate() {};

	public Candidate(
			@NotNull @NotBlank(message = "Identity card is required") @Size(min = 10, message = "Identity card should have at least 10 characters") long identityCard,
			@NotNull @NotBlank(message = "First name is required") @Size(min = 2, message = "First name should have at least 2 characters") String firstName,
			@NotNull @NotBlank(message = "Last name is required") @Size(min = 2, message = "Last name should have at least 2 characters") String lastName,
			@NotNull @NotBlank(message = "Gender is required") String gender,
			@NotNull @NotBlank(message = "Day of birth is required") String dayOfBirth,
			@NotNull @NotBlank(message = "Place of birth is required") @Size(min = 4, message = "Place of birth should have at least 4 characters") String placeOfBirth,
			@NotNull @NotBlank(message = "Day provide is required") String dayProvide,
			@NotNull @NotBlank(message = "Place provide is required") @Size(min = 4, message = "Place provide should have at least 4 characters") String placeProvide,
			@NotNull @NotBlank(message = "Place provide is required") @Size(min = 10, message = "Phone number should have at least 10 characters") String phoneNumber,
			@NotNull @NotEmpty @Email String email, CandidatesInRoom candidatesInRoom) {
		super();
		this.identityCard = identityCard;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.dayProvide = dayProvide;
		this.placeProvide = placeProvide;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.candidatesInRoom = candidatesInRoom;
	}

	public long getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(long identityCard) {
		this.identityCard = identityCard;
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

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getDayProvide() {
		return dayProvide;
	}

	public void setDayProvide(String dayProvide) {
		this.dayProvide = dayProvide;
	}

	public String getPlaceProvide() {
		return placeProvide;
	}

	public void setPlaceProvide(String placeProvide) {
		this.placeProvide = placeProvide;
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

	public CandidatesInRoom getCandidatesInRoom() {
		return candidatesInRoom;
	}

	public void setCandidatesInRoom(CandidatesInRoom candidatesInRoom) {
		this.candidatesInRoom = candidatesInRoom;
	}
	
}
