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
import com.isa.fishingbooker.model.BoatBehavioralRule;
import com.isa.fishingbooker.model.BoatBehavioralRule;
import com.isa.fishingbooker.repository.BoatBehavioralRuleRepository;

@Service
public class BoatBehavioralRuleService {

	@Autowired
	private BoatBehavioralRuleRepository BoatBehavioralRuleRepository;
	
	public List<BoatBehavioralRule> getAllBoatBehavioralRules(){
		return this.BoatBehavioralRuleRepository.findAll();
	}
		
	public ResponseEntity<BoatBehavioralRule> getBoatBehavioralRuleById(int boatBehavioralRuleId)
		throws ResourceNotFoundException{
		BoatBehavioralRule boatBehavioralRule = BoatBehavioralRuleRepository.findById(boatBehavioralRuleId).orElseThrow(() -> new ResourceNotFoundException("BoatBehavioralRule not found for this id :: " + boatBehavioralRuleId));
	 return ResponseEntity.ok().body(boatBehavioralRule);
	}
	
	
	public BoatBehavioralRule createBoatBehavioralRule(BoatBehavioralRule boatBehavioralRule) {
		return BoatBehavioralRuleRepository.save(boatBehavioralRule);
	}
	
	
	
	public ResponseEntity<BoatBehavioralRule> updateBoatBehavioralRule(Integer boatBehavioralRuleId,
			 @RequestBody BoatBehavioralRule boatBehavioralRuleDetails) throws ResourceNotFoundException {
		BoatBehavioralRule boatBehavioralRule = BoatBehavioralRuleRepository.findById(boatBehavioralRuleId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatBehavioralRule not found for this id :: " + boatBehavioralRuleId));
		
		boatBehavioralRule.setName(boatBehavioralRuleDetails.getName());
		boatBehavioralRule.setDescription(boatBehavioralRuleDetails.getDescription());
		
		final BoatBehavioralRule updatedBoatBehavioralRule = BoatBehavioralRuleRepository.save(boatBehavioralRule);
		return ResponseEntity.ok(updatedBoatBehavioralRule);
	}
	
	public Map<String, Boolean> deleteBoatBehavioralRule(int boatBehavioralRuleId)
			throws ResourceNotFoundException {
		BoatBehavioralRule  boatBehavioralRule = BoatBehavioralRuleRepository.findById(boatBehavioralRuleId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatBehavioralRule not found for this id :: " + boatBehavioralRuleId));

		BoatBehavioralRuleRepository.delete(boatBehavioralRule);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public List<BoatBehavioralRule> getBoatBehavioralRulesByBoat(Integer boatId) {
		return BoatBehavioralRuleRepository.getBoatBehavioralRulesByBoat(boatId);
	}
	
}
