package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.model.InstructorRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatOwnerRate;
import com.isa.fishingbooker.repository.BoatOwnerRateRepository;

@Service
public class BoatOwnerRateService {
	@Autowired
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
	private BoatOwnerRateRepository BoatOwnerRateRepository;
	
	public List<BoatOwnerRate> getAllBoatOwnerRates(){
		return this.BoatOwnerRateRepository.findAll();
	}
		
	public ResponseEntity<BoatOwnerRate> getBoatOwnerRateById(int boatOwnerRateId)
		throws ResourceNotFoundException{
		BoatOwnerRate boatOwnerRate = BoatOwnerRateRepository.findById(boatOwnerRateId).orElseThrow(() -> new ResourceNotFoundException("BoatOwnerRate not found for this id :: " + boatOwnerRateId));
	 return ResponseEntity.ok().body(boatOwnerRate);
	}
	public List<BoatOwnerRate> getAllBoatOwnerRateRequests(){
		return this.BoatOwnerRateRepository.getAllBoatOwnerRateRequests();
	}
	
	public BoatOwnerRate createBoatOwnerRate(BoatOwnerRate boatOwnerRate) {
		return BoatOwnerRateRepository.save(boatOwnerRate);
	}
	
	
	
	public ResponseEntity<BoatOwnerRate> updateBoatOwnerRate(Integer boatOwnerRateId,
			 @RequestBody BoatOwnerRate boatOwnerRateDetails) throws ResourceNotFoundException {
		BoatOwnerRate boatOwnerRate = BoatOwnerRateRepository.findById(boatOwnerRateId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwnerRate not found for this id :: " + boatOwnerRateId));

		boatOwnerRate.setAccepted(boatOwnerRateDetails.getAccepted());
		boatOwnerRate.setRate(boatOwnerRateDetails.getRate());
		boatOwnerRate.setRequest(boatOwnerRateDetails.getRequest());

		if(boatOwnerRate.getAccepted().toString().equals("true")) {
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionAsyncAcceptRate(boatOwnerRate.getClient());
			} catch (Exception e) {
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
		}

		final BoatOwnerRate updatedBoatOwnerRate = BoatOwnerRateRepository.save(boatOwnerRate);
		return ResponseEntity.ok(updatedBoatOwnerRate);
	}
	
	
	public Map<String, Boolean> deleteBoatOwnerRate(int boatOwnerRateId)
			throws ResourceNotFoundException {
		BoatOwnerRate  boatOwnerRate = BoatOwnerRateRepository.findById(boatOwnerRateId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwnerRate not found for this id :: " + boatOwnerRateId));

		BoatOwnerRateRepository.delete(boatOwnerRate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
