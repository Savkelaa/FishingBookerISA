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
import com.isa.fishingbooker.model.BoatOwnerRate;
import com.isa.fishingbooker.repository.BoatOwnerRateRepository;

@Service
public class BoatOwnerRateService {

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
	
	@PostMapping("/boatOwnerRates")
	public BoatOwnerRate createBoatOwnerRate(BoatOwnerRate boatOwnerRate) {
		return BoatOwnerRateRepository.save(boatOwnerRate);
	}
	
	
	@PutMapping("/boatOwnerRate/{id}")
	public ResponseEntity<BoatOwnerRate> updateBoatOwnerRate(Integer boatOwnerRateId,
			 @RequestBody BoatOwnerRate boatOwnerRateDetails) throws ResourceNotFoundException {
		BoatOwnerRate boatOwnerRate = BoatOwnerRateRepository.findById(boatOwnerRateId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwnerRate not found for this id :: " + boatOwnerRateId));
		
		boatOwnerRate.setRate(boatOwnerRateDetails.getRate());
		
		final BoatOwnerRate updatedBoatOwnerRate = BoatOwnerRateRepository.save(boatOwnerRate);
		return ResponseEntity.ok(updatedBoatOwnerRate);
	}
	
	@DeleteMapping("/boatOwnerRates/{id}")
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
