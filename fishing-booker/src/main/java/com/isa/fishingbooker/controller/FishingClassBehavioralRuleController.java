package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.FishingClassBehavioralRule;
import com.isa.fishingbooker.service.FishingClassBehavioralRuleService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FishingClassBehavioralRuleController {

	@Autowired
	private FishingClassBehavioralRuleService fishingClassBehavioralRuleService;

	@GetMapping("/behavioralRule")
	public List<FishingClassBehavioralRule> getBehavioralRuleByFishingClass(@RequestParam (value="fishingClassId")  Integer fishingClassId) {
		return fishingClassBehavioralRuleService.getBehavioralRuleByFishingClass(fishingClassId);
	}
	
	@GetMapping("/fishingClassBehavioralRules")
	public List<FishingClassBehavioralRule> getAllFishingClassBehavioralRules() {
		return this.fishingClassBehavioralRuleService.getAllFishingClassBehavioralRules();
	}

	@GetMapping("/fishingClassBehavioralRules/{id}")
	public ResponseEntity<FishingClassBehavioralRule> getFishingClassBehavioralRuleById(@PathVariable(value = "id") int fishingClassBehavioralRuleId)
			throws ResourceNotFoundException {
		return fishingClassBehavioralRuleService.getFishingClassBehavioralRuleById(fishingClassBehavioralRuleId);
	}

	@PostMapping("/fishingClassBehavioralRules")
	public FishingClassBehavioralRule createFishingClassBehavioralRule(@RequestBody FishingClassBehavioralRule fishingClassBehavioralRule) {
		return fishingClassBehavioralRuleService.createFishingClassBehavioralRule(fishingClassBehavioralRule);
	}

	@PutMapping("/fishingClassBehavioralRules/{id}")
	public ResponseEntity<FishingClassBehavioralRule> updateFishingClassBehavioralRule(@PathVariable(value = "id") int fishingClassBehavioralRuleId,
			@RequestBody FishingClassBehavioralRule fishingClassBehavioralRuleDetails) throws ResourceNotFoundException {
		return fishingClassBehavioralRuleService.updateFishingClassBehavioralRule(fishingClassBehavioralRuleId, fishingClassBehavioralRuleDetails);
	}

	@DeleteMapping("/fishingClassBehavioralRules/{id}")
	public Map<String, Boolean> deleteFishingClassBehavioralRule(@PathVariable(value = "id") int fishingClassBehavioralRuleId)
			throws ResourceNotFoundException {
		return fishingClassBehavioralRuleService.deleteFishingClassBehavioralRule(fishingClassBehavioralRuleId);
	}
}
