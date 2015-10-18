package com.hackathon.ghc.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ghc.dto.CreateRequestDto;
import com.hackathon.ghc.model.RequestEntity;
import com.hackathon.ghc.repository.RequestRepository;

@RestController
@RequestMapping("/antardrishti")
public class RequestManager {
	@Autowired
	private RequestRepository requestRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createRequest(@RequestBody CreateRequestDto createRequest) {
		RequestEntity entity = requestRepository
				.save(new RequestEntity(createRequest.getRequest().getType(), createRequest.getRequest().getCondition(),
						createRequest.getRequest().getRequestName(), createRequest.getRequest().getRequiredBy()));
		return entity.getId();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/requests")
	public List<RequestEntity> findRequests() {
		List<RequestEntity> entities = requestRepository.findAll();
		return entities;
	}
}
