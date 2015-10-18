package com.hackathon.ghc.dto;

public class Request {
	private int type;
	private String condition;
	private String requestName;
	private long requiredBy;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
