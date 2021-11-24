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
import com.isa.fishingbooker.model.FishingClassBehavioralRule;
import com.isa.fishingbooker.repository.FishingClassBehavioralRuleRepository;

@Service
public class FishingClassBehavioralRuleService {

	@Autowired
	private FishingClassBehavioralRuleRepository FishingClassBehavioralRuleRepository;
	
	public List<FishingClassBehavioralRule> getBehavioralRuleByFishingClass(Integer fishingClassId)
	{
		return FishingClassBehavioralRuleRepository.getBehavioralRuleByFishingClass(fishingClassId);
	}
	
	public List<FishingClassBehavioralRule> getAllFishingClassBehavioralRules(){
		return this.FishingClassBehavioralRuleRepository.findAll();
	}
		
	public ResponseEntity<FishingClassBehavioralRule> getFishingClassBehavioralRuleById(int fishingClassBehavioralRuleId)
		throws ResourceNotFoundException{
		FishingClassBehavioralRule fishingClassBehavioralRule = FishingClassBehavioralRuleRepository.findById(fishingClassBehavioralRuleId).orElseThrow(() -> new ResourceNotFoundException("FishingClassBehavioralRule not found for this id :: " + fishingClassBehavioralRuleId));
	 return ResponseEntity.ok().body(fishingClassBehavioralRule);
	}
	
	@PostMapping("/fishingClassBehavioralRules")
	public FishingClassBehavioralRule createFishingClassBehavioralRule(FishingClassBehavioralRule fishingClassBehavioralRule) {
		return FishingClassBehavioralRuleRepository.save(fishingClassBehavioralRule);
	}
	
	
	@PutMapping("/fishingClassBehavioralRule/{id}")
	public ResponseEntity<FishingClassBehavioralRule> updateFishingClassBehavioralRule(Integer fishingClassBehavioralRuleId,
			 @RequestBody FishingClassBehavioralRule fishingClassBehavioralRuleDetails) throws ResourceNotFoundException {
		FishingClassBehavioralRule fishingClassBehavioralRule = FishingClassBehavioralRuleRepository.findById(fishingClassBehavioralRuleId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassBehavioralRule not found for this id :: " + fishingClassBehavioralRuleId));
		
		fishingClassBehavioralRule.setName(fishingClassBehavioralRuleDetails.getName());
		fishingClassBehavioralRule.setDescription(fishingClassBehavioralRuleDetails.getDescription());
	
		final FishingClassBehavioralRule updatedFishingClassBehavioralRule = FishingClassBehavioralRuleRepository.save(fishingClassBehavioralRule);
		return ResponseEntity.ok(updatedFishingClassBehavioralRule);
	}
	
	@DeleteMapping("/fishingClassBehavioralRules/{id}")
	public Map<String, Boolean> deleteFishingClassBehavioralRule(int fishingClassBehavioralRuleId)
			throws ResourceNotFoundException {
		FishingClassBehavioralRule  fishingClassBehavioralRule = FishingClassBehavioralRuleRepository.findById(fishingClassBehavioralRuleId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassBehavioralRule not found for this id :: " + fishingClassBehavioralRuleId));

		FishingClassBehavioralRuleRepository.delete(fishingClassBehavioralRule);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
