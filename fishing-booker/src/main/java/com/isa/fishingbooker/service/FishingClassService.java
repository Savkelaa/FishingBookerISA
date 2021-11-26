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
import com.isa.fishingbooker.model.FishingClass;
import com.isa.fishingbooker.model.FishingClassBehavioralRule;
import com.isa.fishingbooker.repository.FishingClassRepository;

@Service
public class FishingClassService {

	@Autowired
	private FishingClassRepository fishingClassRepository;
	
	public List<String> getShortBiographyByFishingClass(Integer fishingClassId)
	{
		return fishingClassRepository.getShortBiographyByFishingClass(fishingClassId);
	}
	

	public List<FishingClass> getAllFishingClasss(){
		return this.fishingClassRepository.findAll();
	}
		
	public ResponseEntity<FishingClass> getFishingClassById(int fishingClassId)
		throws ResourceNotFoundException{
		FishingClass fishingClass = fishingClassRepository.findById(fishingClassId).orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));
	 return ResponseEntity.ok().body(fishingClass);
	}
	

	public FishingClass createFishingClass(FishingClass fishingClass) {
		return fishingClassRepository.save(fishingClass);
	}
	
	
	public ResponseEntity<FishingClass> updateFishingClass(Integer fishingClassId,
			 @RequestBody FishingClass fishingClassDetails) throws ResourceNotFoundException {
		FishingClass fishingClass = fishingClassRepository.findById(fishingClassId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));
		
				
		fishingClass.setName(fishingClassDetails.getName());
		fishingClass.setAddress(fishingClassDetails.getAddress());
		fishingClass.setPrice(fishingClassDetails.getPrice());
		fishingClass.setPromoDescription(fishingClassDetails.getPromoDescription());
		fishingClass.setStatus(fishingClassDetails.getStatus());
		fishingClass.setCancellationCondition(fishingClassDetails.getCancellationCondition());
	
		final FishingClass updatedFishingClass = fishingClassRepository.save(fishingClass);
		return ResponseEntity.ok(updatedFishingClass);
	}
	

	public Map<String, Boolean> deleteFishingClass(int fishingClassId)
			throws ResourceNotFoundException {
		FishingClass  fishingClass = fishingClassRepository.findById(fishingClassId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));

		fishingClassRepository.delete(fishingClass);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
