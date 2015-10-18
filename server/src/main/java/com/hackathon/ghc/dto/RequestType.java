package com.hackathon.ghc.dto;

public enum RequestType {
	SEEKER(1), //
	VOLUNTEER(2);

	private int id;

	public int getId() {
		return id;
	}

	private RequestType(int id) {
		this.id = id;
	}

	public static RequestType fromTypeId(int id) {
		for (RequestType type : RequestType.values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		return null;
	}
}
