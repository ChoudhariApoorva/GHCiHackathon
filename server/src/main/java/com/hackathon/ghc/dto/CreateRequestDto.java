package com.hackathon.ghc.dto;

public class CreateRequestDto {
	private Contact contact;
	private Request request;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
