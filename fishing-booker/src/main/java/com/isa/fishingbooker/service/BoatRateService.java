package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatRate;
import com.isa.fishingbooker.repository.BoatRateRepository;

@Service
public class BoatRateService {

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
	
	@PostMapping("/boatRates")
	public BoatRate createBoatRate(BoatRate boatRate) {
		return BoatRateRepository.save(boatRate);
	}
	
	
	@PutMapping("/boatRate/{id}")
	public ResponseEntity<BoatRate> updateBoatRate(Integer boatRateId,
			 @RequestBody BoatRate boatRateDetails) throws ResourceNotFoundException {
		BoatRate boatRate = BoatRateRepository.findById(boatRateId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatRate not found for this id :: " + boatRateId));
		
		boatRate.setRate(boatRateDetails.getRate());
		
		final BoatRate updatedBoatRate = BoatRateRepository.save(boatRate);
		return ResponseEntity.ok(updatedBoatRate);
	}
	
	@DeleteMapping("/boatRates/{id}")
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
