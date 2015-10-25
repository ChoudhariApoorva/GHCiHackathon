package com.hackathon.ghc.model;

import org.springframework.data.annotation.Id;

public class RequestEntity {
	@Id
	private String id;

	private String contact;
	private int typeId;
	private String condition;
	private String requestName;
	private long requiredBy;

	public RequestEntity() {

	}

	public RequestEntity(String contact, int type, String condition, String requestName, long requiredBy) {
		this.contact = contact;
		this.typeId = type;
		this.condition = condition;
		this.requestName = requestName;
		this.requiredBy = requiredBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public long getRequiredBy() {
		return requiredBy;
	}

	public void setRequiredBy(long requiredBy) {
		this.requiredBy = requiredBy;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
