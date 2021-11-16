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
import com.isa.fishingbooker.repository.FishingClassRepository;

@Service
public class FishingClassService {

	@Autowired
	private FishingClassRepository FishingClassRepository;
	
	public List<FishingClass> getAllFishingClasss(){
		return this.FishingClassRepository.findAll();
	}
		
	public ResponseEntity<FishingClass> getFishingClassById(int fishingClassId)
		throws ResourceNotFoundException{
		FishingClass fishingClass = FishingClassRepository.findById(fishingClassId).orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));
	 return ResponseEntity.ok().body(fishingClass);
	}
	
	@PostMapping("/fishingClasss")
	public FishingClass createFishingClass(FishingClass fishingClass) {
		return FishingClassRepository.save(fishingClass);
	}
	
	
	@PutMapping("/fishingClass/{id}")
	public ResponseEntity<FishingClass> updateFishingClass(Integer fishingClassId,
			 @RequestBody FishingClass fishingClassDetails) throws ResourceNotFoundException {
		FishingClass fishingClass = FishingClassRepository.findById(fishingClassId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));
		
				
		fishingClass.setName(fishingClassDetails.getName());
		fishingClass.setAddress(fishingClassDetails.getAddress());
		fishingClass.setPrice(fishingClassDetails.getPrice());
		fishingClass.setPromoDescription(fishingClassDetails.getPromoDescription());
		fishingClass.setStatus(fishingClassDetails.getStatus());
		fishingClass.setCancellationCondition(fishingClassDetails.getCancellationCondition());
	
		final FishingClass updatedFishingClass = FishingClassRepository.save(fishingClass);
		return ResponseEntity.ok(updatedFishingClass);
	}
	
	@DeleteMapping("/fishingClasss/{id}")
	public Map<String, Boolean> deleteFishingClass(int fishingClassId)
			throws ResourceNotFoundException {
		FishingClass  fishingClass = FishingClassRepository.findById(fishingClassId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));

		FishingClassRepository.delete(fishingClass);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
