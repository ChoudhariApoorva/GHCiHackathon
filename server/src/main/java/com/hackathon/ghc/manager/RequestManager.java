package com.hackathon.ghc.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ghc.dto.Contact;
import com.hackathon.ghc.dto.CreateRequestDto;
import com.hackathon.ghc.model.ContactEntity;
import com.hackathon.ghc.model.RequestEntity;
import com.hackathon.ghc.repository.ContactRepository;
import com.hackathon.ghc.repository.SeekerRequestRepository;
import com.hackathon.ghc.repository.VolunteerRequestRepository;

@RestController
@RequestMapping("/antardrishti")
@Configuration
@ComponentScan("com.hackathon.ghc")
public class RequestManager {
	@Autowired
	private SeekerRequestRepository seekerRequestRepository;

	@Autowired
	private VolunteerRequestRepository volRequestRepository;

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createRequest(@RequestBody CreateRequestDto createRequest) {
		ContactEntity contactEntity = new ContactEntity(createRequest.getContact().getName(),
				createRequest.getContact().getEmailId(), createRequest.getContact().getMobileNumber(),
				createRequest.getContact().getGender(), createRequest.getContact().getDateOfBirth(),
				createRequest.getContact().getCity(), createRequest.getContact().getState());
		ContactEntity existingContact = contactRepository.findByEmailId(contactEntity.getEmailId());
		if (existingContact != null) {
			contactRepository.delete(existingContact.getId());
		}
		contactRepository.save(contactEntity);
		RequestEntity requestEntity = new RequestEntity(contactEntity.getEmailId(),
				createRequest.getRequest().getType(), createRequest.getRequest().getCondition(),
				createRequest.getRequest().getRequestName(), createRequest.getRequest().getRequiredBy());
		if (requestEntity.getTypeId() == 1) {
			seekerRequestRepository.save(requestEntity);
		} else {
			volRequestRepository.save(requestEntity);
		}
		return requestEntity.getRequestName();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createProfil(@RequestBody Contact contact) {
		ContactEntity contactEntity = new ContactEntity(contact.getName(), contact.getEmailId(),
				contact.getMobileNumber(), contact.getGender(), contact.getDateOfBirth(), contact.getCity(),
				contact.getState());
		ContactEntity existingContact = contactRepository.findByEmailId(contactEntity.getEmailId());
		if (existingContact != null) {
			contactRepository.delete(existingContact.getId());
		}
		contactRepository.save(contactEntity);

		return contactEntity.getEmailId();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/requests", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RequestEntity> findRequests() {
		List<RequestEntity> entities = seekerRequestRepository.findAll();
		entities.addAll(volRequestRepository.findAll());
		return entities;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ContactEntity> findProfiles() {
		List<ContactEntity> entities = contactRepository.findAll();
		return entities;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/requests/{contact}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RequestEntity> findByContact(@PathVariable(value = "contact") String contact) {
		List<RequestEntity> entities = seekerRequestRepository.findByContact(contact);
		entities.addAll(volRequestRepository.findByContact(contact));
		return entities;
	}
}
