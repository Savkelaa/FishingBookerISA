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
import com.isa.fishingbooker.model.FishingClassRate;
import com.isa.fishingbooker.repository.FishingClassRateRepository;

@Service
public class FishingClassRateService {

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
		
		fishingClassRate.setRate(fishingClassRateDetails.getRate());
	
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
