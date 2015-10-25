package com.hackathon.ghc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hackathon.ghc.model.ContactEntity;

public interface ContactRepository extends MongoRepository<ContactEntity, String> {
	public ContactEntity findByEmailId(String emailId);
}
