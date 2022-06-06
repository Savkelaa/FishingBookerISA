package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.BoatOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.Instructor;
import com.isa.fishingbooker.repository.BoatOwnerRepository;

import javax.transaction.Transactional;

@Service
public class BoatOwnerService {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private BoatOwnerRepository BoatOwnerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<BoatOwner> getAllBoatOwners(){
		return this.BoatOwnerRepository.findAll();
	}
	public List<BoatOwner> getAllBoatOwnersNotDeleted(){
		return this.BoatOwnerRepository.getAllBoatOwnersNotDeleted();
	}

	public List<BoatOwner> getAllBoatOwnerRequests()
	{
		return this.BoatOwnerRepository.getAllBoatOwnerRequests();
	}

	public List<BoatOwner> getAllBoatOwnerDeleteRequests()
	{
		return this.BoatOwnerRepository.getAllBoatOwnerDeleteRequests();
	}

	public ResponseEntity<BoatOwner> getBoatOwnerById(int boatOwnerId)
		throws ResourceNotFoundException{
		BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId).orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));
	 return ResponseEntity.ok().body(boatOwner);
	}
	
	
	public BoatOwner createBoatOwner(BoatOwner boatOwner)  throws Exception {

		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(boatOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		boatOwner.setActivated("false");
		boatOwner.setDeleted("false");
		boatOwner.setPassword(passwordEncoder.encode(boatOwner.getPassword()));
		return BoatOwnerRepository.save(boatOwner);
	}

	@Transactional
	public ResponseEntity<BoatOwner> updateBoatOwner(Integer boatOwnerId,
	 @RequestBody BoatOwner boatOwnerDetails) throws ResourceNotFoundException {
		try{
		BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));
		
		boatOwner.setAddress(boatOwnerDetails.getAddress());
		boatOwner.setCity(boatOwnerDetails.getCity());
		boatOwner.setCountry(boatOwnerDetails.getCountry());
		boatOwner.setEmail(boatOwnerDetails.getEmail());
		boatOwner.setExplanation(boatOwnerDetails.getExplanation());
		boatOwner.setName(boatOwnerDetails.getName());
		boatOwner.setNumber(boatOwnerDetails.getNumber());
		boatOwner.setPassword(boatOwnerDetails.getPassword());
		boatOwner.setSurname(boatOwnerDetails.getSurname());
		boatOwner.setBiography(boatOwnerDetails.getBiography());
		boatOwner.setDeleted(boatOwnerDetails.getDeleted());


		final BoatOwner updatedBoatOwner = BoatOwnerRepository.save(boatOwner);
		return ResponseEntity.ok(updatedBoatOwner);
		}catch(OptimisticLockingFailureException e)
		{
			return null;
		}
	}
	
	public ResponseEntity<BoatOwner> activateBoatOwner(Integer boatOwnerId) throws ResourceNotFoundException {
		BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));
		
		boatOwner.setActivated("true");

		final BoatOwner updatedBoatOwner = BoatOwnerRepository.save(boatOwner);
		
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsyncAccept(boatOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		
		return ResponseEntity.ok(updatedBoatOwner);
	}
	
	public ResponseEntity<BoatOwner> removeBoatOwner(Integer boatOwnerId, 
			@RequestBody BoatOwner boatOwnerDetails) throws ResourceNotFoundException {
		BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));
		
		boatOwner.setRefusalReason(boatOwnerDetails.getRefusalReason());
		boatOwner.setDeleted("true");
		boatOwner.setDeleteRequest("false");

		final BoatOwner updatedBoatOwner = BoatOwnerRepository.save(boatOwner);
		
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsyncRemove(boatOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return ResponseEntity.ok(updatedBoatOwner);
	}


	public ResponseEntity<BoatOwner> removeBoatOwnerDeleteRequest(Integer boatOwnerId,
													 @RequestBody BoatOwner boatOwnerDetails) throws ResourceNotFoundException {
		BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));

		boatOwner.setRefusalReason(boatOwnerDetails.getRefusalReason());
		boatOwner.setDeleteRequest("false");

		final BoatOwner updatedBoatOwner = BoatOwnerRepository.save(boatOwner);

		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsyncRemove(boatOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return ResponseEntity.ok(updatedBoatOwner);
	}



	public ResponseEntity<BoatOwner> boatOwnerSendDeleteRequest(Integer boatOwnerId,
															  @RequestBody BoatOwner boatOwnerDetails) throws ResourceNotFoundException {
		BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));

		boatOwner.setDeleteRequest("true");
		boatOwner.setDeleteReason(boatOwnerDetails.getDeleteReason());

		final BoatOwner updatedBoatOwner = BoatOwnerRepository.save(boatOwner);
		return ResponseEntity.ok(updatedBoatOwner);
	}
	

	public Map<String, Boolean> deleteBoatOwner(int boatOwnerId)
			throws ResourceNotFoundException {
		BoatOwner  boatOwner = BoatOwnerRepository.findById(boatOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));

		BoatOwnerRepository.delete(boatOwner);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public BoatOwner getBoatOwnerByEmailAndPassword(String email, String password) {
		return BoatOwnerRepository.getBoatOwnerByEmailAndPassword(email, password);
	}
	
	public ResponseEntity<BoatOwner> changePasswordBoatOwner(Integer boatOwnerId,
			   @RequestBody BoatOwner boatOwnerDetails) throws ResourceNotFoundException {
			BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId)
			.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));
			
			boatOwner.setPassword(passwordEncoder.encode(boatOwnerDetails.getPassword()));
			
			final BoatOwner updatedBoatOwner = BoatOwnerRepository.save(boatOwner);
			return ResponseEntity.ok(updatedBoatOwner);
	}
}
