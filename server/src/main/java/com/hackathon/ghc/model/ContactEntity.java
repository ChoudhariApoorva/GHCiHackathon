package com.hackathon.ghc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profile")
@CompoundIndex(name="email_constraint", def="{'emailId':1}", unique=true)

public class ContactEntity {

	@Id
	private String id;
	private String name;
	private String emailId;
	private String mobileNumber;
	private String gender;
	private long dateOfBirth;
	private String city;
	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ContactEntity() {

	}

	public ContactEntity(String name, String emailId, String mobileNumber, String gender, long dateOfBirth, String city,
			String state) {
		this.name = name;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
