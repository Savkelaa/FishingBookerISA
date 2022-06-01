package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.model.Cottage;
import com.isa.fishingbooker.model.FishingClassRate;
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
import com.isa.fishingbooker.model.CottageRate;
import com.isa.fishingbooker.repository.CottageRateRepository;

@Service
public class CottageRateService {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;



	@Autowired
	private CottageRateRepository CottageRateRepository;
	
	public List<CottageRate> getAllCottageRates(){
		return this.CottageRateRepository.findAll();
	}
		
	public ResponseEntity<CottageRate> getCottageRateById(int cottageRateId)
		throws ResourceNotFoundException{
		CottageRate cottageRate = CottageRateRepository.findById(cottageRateId).orElseThrow(() -> new ResourceNotFoundException("CottageRate not found for this id :: " + cottageRateId));
	 return ResponseEntity.ok().body(cottageRate);
	}

	public List<CottageRate> getAllCottageRateRequests(){
		return this.CottageRateRepository.getAllCottageRateRequests();
	}

	public CottageRate createCottageRate(CottageRate cottageRate) {
		return CottageRateRepository.save(cottageRate);
	}
	
	

	public ResponseEntity<CottageRate> updateCottageRate(Integer cottageRateId,
			 @RequestBody CottageRate cottageRateDetails) throws ResourceNotFoundException {
		CottageRate cottageRate = CottageRateRepository.findById(cottageRateId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageRate not found for this id :: " + cottageRateId));

		cottageRate.setRequest(cottageRateDetails.getRequest());
		cottageRate.setAccepted(cottageRateDetails.getAccepted());
		cottageRate.setRate(cottageRateDetails.getRate());


		if(cottageRateDetails.getAccepted().toString().equals("true")) {
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionAsyncAcceptRate(cottageRate.getClient());
			} catch (Exception e) {
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
		}

		final CottageRate updatedCottageRate = CottageRateRepository.save(cottageRate);
		return ResponseEntity.ok(updatedCottageRate);
	}
	

	public Map<String, Boolean> deleteCottageRate(int cottageRateId)
			throws ResourceNotFoundException {
		CottageRate  cottageRate = CottageRateRepository.findById(cottageRateId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageRate not found for this id :: " + cottageRateId));

		CottageRateRepository.delete(cottageRate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
