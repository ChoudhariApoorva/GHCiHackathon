package com.hackathon.ghc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hackathon.ghc.model.RequestEntity;

public interface RequestRepository extends MongoRepository<RequestEntity, String> {
	
}