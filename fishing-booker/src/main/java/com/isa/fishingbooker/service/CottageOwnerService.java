package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.repository.CottageOwnerRepository;

@Service
public class CottageOwnerService {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;	
	
	@Autowired
	private CottageOwnerRepository CottageOwnerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<CottageOwner> getAllCottageOwners(){
		return this.CottageOwnerRepository.findAll();
	}
	
	
	public  List<CottageOwner> getAllCottageOwnerRequests()	
	{
	return this.CottageOwnerRepository.getAllCottageOwnerRequests();
	}
	
	public ResponseEntity<CottageOwner> getCottageOwnerById(int cottageOwnerId)
		throws ResourceNotFoundException{
		CottageOwner cottageOwner = CottageOwnerRepository.findById(cottageOwnerId).orElseThrow(() -> new ResourceNotFoundException("CottageOwner not found for this id :: " + cottageOwnerId));
	 return ResponseEntity.ok().body(cottageOwner);
	}
	

	public CottageOwner createCottageOwner(CottageOwner cottageOwner) throws Exception {

		CottageOwner existUser = this.CottageOwnerRepository.getCottageOwnerByEmail(cottageOwner.getEmail());

		if (existUser != null) {
			throw new Exception("Email already exists");
		}


		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(cottageOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		cottageOwner.setPassword(passwordEncoder.encode(cottageOwner.getPassword()));
		return CottageOwnerRepository.save(cottageOwner);
	}
	
	public ResponseEntity<CottageOwner> activateCottageOwner(Integer cottageOwnerId) throws ResourceNotFoundException {
		CottageOwner cottageOwner = CottageOwnerRepository.findById(cottageOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("Cottage ownre not found for this id :: " + cottageOwnerId));
		
		cottageOwner.setActivated("true");
		
		final CottageOwner updatedCottageOwner = CottageOwnerRepository.save(cottageOwner);
		
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsyncAccept(cottageOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		return ResponseEntity.ok(updatedCottageOwner);
	}
	
	public ResponseEntity<CottageOwner> removeCottageOwner(Integer cottageOwnerId,
			 @RequestBody CottageOwner cottageOwnerDetails) throws ResourceNotFoundException {
		CottageOwner cottageOwner = CottageOwnerRepository.findById(cottageOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + cottageOwnerId));
		
		cottageOwner.setRefusalReason(cottageOwnerDetails.getRefusalReason());
		cottageOwner.setDeleted("true");
		
		final CottageOwner updatedCottageOwner = CottageOwnerRepository.save(cottageOwner);
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsyncRemove(cottageOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		return ResponseEntity.ok(updatedCottageOwner);
	}
	
	public ResponseEntity<CottageOwner> setCottageOwnerReason(Integer cottageOwnerId,
			 @RequestBody String cottageOwnerDetails) throws ResourceNotFoundException {
		CottageOwner cottageOwner = CottageOwnerRepository.findById(cottageOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwner not found for this id :: " + cottageOwnerId));
		
		cottageOwner.setRefusalReason(cottageOwnerDetails);
		
		
		final CottageOwner updatedCottageOwner = CottageOwnerRepository.save(cottageOwner);
		return ResponseEntity.ok(updatedCottageOwner);
	}

	public ResponseEntity<CottageOwner> cottageOwnerSendDeleteRequest(Integer cottageOwnerId,
															  @RequestBody CottageOwner cottageOwnerDetails) throws ResourceNotFoundException {
		CottageOwner cottageOwner = CottageOwnerRepository.findById(cottageOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwner not found for this id :: " + cottageOwnerId));

		cottageOwner.setDeleteRequest("true");
		cottageOwner.setDeleteReason(cottageOwnerDetails.getDeleteReason());

		final CottageOwner updatedCottageOwner = CottageOwnerRepository.save(cottageOwner);
		return ResponseEntity.ok(updatedCottageOwner);
	}
	public List<CottageOwner> getAllCottageOwnerDeleteRequests() {
		return CottageOwnerRepository.getAllCottageOwnerDeleteRequests();
	}


	public ResponseEntity<CottageOwner> updateCottageOwner(Integer cottageOwnerId,
			 @RequestBody CottageOwner cottageOwnerDetails) throws ResourceNotFoundException {
		CottageOwner cottageOwner = CottageOwnerRepository.findById(cottageOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwner not found for this id :: " + cottageOwnerId));
		
		cottageOwner.setAddress(cottageOwnerDetails.getAddress());
		cottageOwner.setCity(cottageOwnerDetails.getCity());
		cottageOwner.setCountry(cottageOwnerDetails.getCountry());
		cottageOwner.setEmail(cottageOwnerDetails.getEmail());
		cottageOwner.setExplanation(cottageOwnerDetails.getExplanation());
		cottageOwner.setName(cottageOwnerDetails.getName());
		cottageOwner.setNumber(cottageOwnerDetails.getNumber());
		cottageOwner.setPassword(cottageOwnerDetails.getPassword());
		cottageOwner.setSurname(cottageOwnerDetails.getSurname());
		
		final CottageOwner updatedCottageOwner = CottageOwnerRepository.save(cottageOwner);
		return ResponseEntity.ok(updatedCottageOwner);
	}
	

	public Map<String, Boolean> deleteCottageOwner(int cottageOwnerId)
			throws ResourceNotFoundException {
		CottageOwner  cottageOwner = CottageOwnerRepository.findById(cottageOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwner not found for this id :: " + cottageOwnerId));

		CottageOwnerRepository.delete(cottageOwner);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public CottageOwner getCottageOwnerByEmailAndPassword(String email, String password) {
		return CottageOwnerRepository.getCottageOwnerByEmailAndPassword(email, password);
	}
}
