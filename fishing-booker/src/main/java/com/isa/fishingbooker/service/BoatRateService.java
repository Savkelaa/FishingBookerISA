package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatRate;
import com.isa.fishingbooker.repository.BoatRateRepository;

@Service
public class BoatRateService {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	@Autowired
	private BoatRateRepository BoatRateRepository;
	
	public List<BoatRate> getAllBoatRates(){
		return this.BoatRateRepository.findAll();
	}
		
	public ResponseEntity<BoatRate> getBoatRateById(int boatRateId)
		throws ResourceNotFoundException{
		BoatRate boatRate = BoatRateRepository.findById(boatRateId).orElseThrow(() -> new ResourceNotFoundException("BoatRate not found for this id :: " + boatRateId));
	 return ResponseEntity.ok().body(boatRate);
	}

	public Double getRatesByBoat(Integer boatId){
		return BoatRateRepository.getBoatRates(boatId);
	}

	public List<BoatRate> getAllBoatRateRequests(){
		return this.BoatRateRepository.getAllBoatRateRequests();
	}

	public BoatRate createBoatRate(BoatRate boatRate) {
		return BoatRateRepository.save(boatRate);
	}
	
	public Double getBoatAvgRate( Integer boatId){
		return this.BoatRateRepository.getBoatAvgRate(boatId);
	}
	
	public ResponseEntity<BoatRate> updateBoatRate(Integer boatRateId,
			 @RequestBody BoatRate boatRateDetails) throws ResourceNotFoundException {
		BoatRate boatRate = BoatRateRepository.findById(boatRateId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatRate not found for this id :: " + boatRateId));

		boatRate.setAccepted(boatRateDetails.getAccepted());
		boatRate.setRequest(boatRateDetails.getRequest());
		boatRate.setRate(boatRateDetails.getRate());

		if(boatRateDetails.getAccepted().toString().equals("true")) {
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionAsyncAcceptRate(boatRate.getClient());
			} catch (Exception e) {
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
		}

		final BoatRate updatedBoatRate = BoatRateRepository.save(boatRate);
		return ResponseEntity.ok(updatedBoatRate);
	}
	
	
	public Map<String, Boolean> deleteBoatRate(int boatRateId)
			throws ResourceNotFoundException {
		BoatRate  boatRate = BoatRateRepository.findById(boatRateId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatRate not found for this id :: " + boatRateId));

		BoatRateRepository.delete(boatRate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
