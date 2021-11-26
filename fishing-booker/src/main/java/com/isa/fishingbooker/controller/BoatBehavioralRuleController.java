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
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatBehavioralRule;
import com.isa.fishingbooker.service.BoatBehavioralRuleService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatBehavioralRuleController {

	@Autowired
	private BoatBehavioralRuleService boatBehavioralRuleService;

	@GetMapping("/boatBehavioralRules")
	public List<BoatBehavioralRule> getAllBoatBehavioralRules() {
		return this.boatBehavioralRuleService.getAllBoatBehavioralRules();
	}

	@GetMapping("/boatBehavioralRules/{id}")
	public ResponseEntity<BoatBehavioralRule> getBoatBehavioralRuleById(@PathVariable(value = "id") int boatBehavioralRuleId)
			throws ResourceNotFoundException {
		return boatBehavioralRuleService.getBoatBehavioralRuleById(boatBehavioralRuleId);
	}

	@PostMapping("/boatBehavioralRules")
	public BoatBehavioralRule createBoatBehavioralRule(@RequestBody BoatBehavioralRule boatBehavioralRule) {
		return boatBehavioralRuleService.createBoatBehavioralRule(boatBehavioralRule);
	}

	@PutMapping("/boatBehavioralRules/{id}")
	public ResponseEntity<BoatBehavioralRule> updateBoatBehavioralRule(@PathVariable(value = "id") int boatBehavioralRuleId,
			@RequestBody BoatBehavioralRule boatBehavioralRuleDetails) throws ResourceNotFoundException {
		return boatBehavioralRuleService.updateBoatBehavioralRule(boatBehavioralRuleId, boatBehavioralRuleDetails);
	}

	@DeleteMapping("/boatBehavioralRules/{id}")
	public Map<String, Boolean> deleteBoatBehavioralRule(@PathVariable(value = "id") int boatBehavioralRuleId)
			throws ResourceNotFoundException {
		return boatBehavioralRuleService.deleteBoatBehavioralRule(boatBehavioralRuleId);
	}
}
