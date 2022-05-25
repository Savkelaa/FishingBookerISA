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

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.FishingClassRate;
import com.isa.fishingbooker.repository.FishingClassRateRepository;

@Service
public class FishingClassRateService {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;


	@Autowired
	private FishingClassRateRepository FishingClassRateRepository;
	
	public List<FishingClassRate> getAllFishingClassRates(){
		return this.FishingClassRateRepository.findAll();
	}

	public List<FishingClassRate> getAllFishingClassRateRequests(){
		return this.FishingClassRateRepository.getAllFishingClassRateRequests();
	}

	public ResponseEntity<FishingClassRate> getFishingClassRateById(int fishingClassRateId)
		throws ResourceNotFoundException{
		FishingClassRate fishingClassRate = FishingClassRateRepository.findById(fishingClassRateId).orElseThrow(() -> new ResourceNotFoundException("FishingClassRate not found for this id :: " + fishingClassRateId));
	 return ResponseEntity.ok().body(fishingClassRate);
	}
	

	public FishingClassRate createFishingClassRate(FishingClassRate fishingClassRate) {
		return FishingClassRateRepository.save(fishingClassRate);
	}
	

	public ResponseEntity<FishingClassRate> updateFishingClassRate(Integer fishingClassRateId,
			 @RequestBody FishingClassRate fishingClassRateDetails) throws ResourceNotFoundException {
		FishingClassRate fishingClassRate = FishingClassRateRepository.findById(fishingClassRateId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassRate not found for this id :: " + fishingClassRateId));

		fishingClassRate.setAccepted(fishingClassRateDetails.getAccepted());
		fishingClassRate.setRate(fishingClassRateDetails.getRate());
		fishingClassRate.setRequest(fishingClassRateDetails.getRequest());


		System.out.print(fishingClassRateDetails.getAccepted().toString());


		if(fishingClassRateDetails.getAccepted().toString().equals("true")) {
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionAsyncAcceptRate(fishingClassRate.getClient());
			} catch (Exception e) {
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
		}

		final FishingClassRate updatedFishingClassRate = FishingClassRateRepository.save(fishingClassRate);
		return ResponseEntity.ok(updatedFishingClassRate);
	}
	

	public Map<String, Boolean> deleteFishingClassRate(int fishingClassRateId)
			throws ResourceNotFoundException {
		FishingClassRate  fishingClassRate = FishingClassRateRepository.findById(fishingClassRateId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassRate not found for this id :: " + fishingClassRateId));

		FishingClassRateRepository.delete(fishingClassRate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
