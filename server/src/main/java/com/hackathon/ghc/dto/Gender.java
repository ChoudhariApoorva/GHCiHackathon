package com.hackathon.ghc.dto;

public enum Gender {
	MALE(1, "male"), //
	FEMALE(2, "female"), //
	NEUTRAL(3, "neutral");
	private int id;
	private String description;

	private Gender(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static Gender fromId(int id) {
		for (Gender gender : Gender.values()) {
			if (gender.getId() == id) {
				return gender;
			}
		}
		return null;
	}
}
