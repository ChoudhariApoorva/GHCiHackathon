package com.hackathon.ghc.model;

import org.springframework.data.annotation.Id;

public class RequestEntity {
	@Id
	private String id;

	private int typeId;
	private String condition;
	private String requestName;
	private long requiredBy;

	public RequestEntity() {

	}

	public RequestEntity(int type, String condition, String requestName, long requiredBy) {
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

}
