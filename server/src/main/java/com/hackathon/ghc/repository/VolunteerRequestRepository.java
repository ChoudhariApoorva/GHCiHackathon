package com.hackathon.ghc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hackathon.ghc.model.RequestEntity;

public interface VolunteerRequestRepository extends MongoRepository<RequestEntity, String> {
	public List<RequestEntity> findByContact(String contact);

}
