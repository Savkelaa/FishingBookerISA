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
import com.isa.fishingbooker.model.CottageOwnerRate;
import com.isa.fishingbooker.repository.CottageOwnerRateRepository;

@Service
public class CottageOwnerRateService {
	@Autowired
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private CottageOwnerRateRepository CottageOwnerRateRepository;
	
	public List<CottageOwnerRate> getAllCottageOwnerRates(){
		return this.CottageOwnerRateRepository.findAll();
	}
		
	public ResponseEntity<CottageOwnerRate> getCottageOwnerRateById(int cottageOwnerRateId)
		throws ResourceNotFoundException{
		CottageOwnerRate cottageOwnerRate = CottageOwnerRateRepository.findById(cottageOwnerRateId).orElseThrow(() -> new ResourceNotFoundException("CottageOwnerRate not found for this id :: " + cottageOwnerRateId));
	 return ResponseEntity.ok().body(cottageOwnerRate);
	}

	public List<CottageOwnerRate> getAllCottageOwnerRateRequests(){
		return this.CottageOwnerRateRepository.getAllCottageOwnerRateRequests();
	}
	
	public CottageOwnerRate createCottageOwnerRate(CottageOwnerRate cottageOwnerRate) {
		return CottageOwnerRateRepository.save(cottageOwnerRate);
	}
	

	public ResponseEntity<CottageOwnerRate> updateCottageOwnerRate(Integer cottageOwnerRateId,
			 @RequestBody CottageOwnerRate cottageOwnerRateDetails) throws ResourceNotFoundException {
		CottageOwnerRate cottageOwnerRate = CottageOwnerRateRepository.findById(cottageOwnerRateId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwnerRate not found for this id :: " + cottageOwnerRateId));

		cottageOwnerRate.setAccepted(cottageOwnerRateDetails.getAccepted());
		cottageOwnerRate.setRate(cottageOwnerRateDetails.getRate());
		cottageOwnerRate.setRequest(cottageOwnerRateDetails.getRequest());

		if(cottageOwnerRate.getAccepted().toString().equals("true")) {
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionAsyncAcceptRate(cottageOwnerRate.getClient());
			} catch (Exception e) {
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
		}

		final CottageOwnerRate updatedCottageOwnerRate = CottageOwnerRateRepository.save(cottageOwnerRate);
		return ResponseEntity.ok(updatedCottageOwnerRate);
	}
	
	public Map<String, Boolean> deleteCottageOwnerRate(int cottageOwnerRateId)
			throws ResourceNotFoundException {
		CottageOwnerRate  cottageOwnerRate = CottageOwnerRateRepository.findById(cottageOwnerRateId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwnerRate not found for this id :: " + cottageOwnerRateId));

		CottageOwnerRateRepository.delete(cottageOwnerRate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
