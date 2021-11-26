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
import com.isa.fishingbooker.model.CottageBehavioralRule;
import com.isa.fishingbooker.service.CottageBehavioralRuleService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageBehavioralRuleController {

	@Autowired
	private CottageBehavioralRuleService cottageBehavioralRuleService;

	@GetMapping("/cottageBehavioralRules")
	public List<CottageBehavioralRule> getAllCottageBehavioralRules() {
		return this.cottageBehavioralRuleService.getAllCottageBehavioralRules();
	}

	@GetMapping("/cottageBehavioralRules/{id}")
	public ResponseEntity<CottageBehavioralRule> getCottageBehavioralRuleById(@PathVariable(value = "id") int cottageBehavioralRuleId)
			throws ResourceNotFoundException {
		return cottageBehavioralRuleService.getCottageBehavioralRuleById(cottageBehavioralRuleId);
	}

	@PostMapping("/cottageBehavioralRules")
	public CottageBehavioralRule createCottageBehavioralRule(@RequestBody CottageBehavioralRule cottageBehavioralRule) {
		return cottageBehavioralRuleService.createCottageBehavioralRule(cottageBehavioralRule);
	}

	@PutMapping("/cottageBehavioralRules/{id}")
	public ResponseEntity<CottageBehavioralRule> updateCottageBehavioralRule(@PathVariable(value = "id") int cottageBehavioralRuleId,
			@RequestBody CottageBehavioralRule cottageBehavioralRuleDetails) throws ResourceNotFoundException {
		return cottageBehavioralRuleService.updateCottageBehavioralRule(cottageBehavioralRuleId, cottageBehavioralRuleDetails);
	}

	@DeleteMapping("/cottageBehavioralRules/{id}")
	public Map<String, Boolean> deleteCottageBehavioralRule(@PathVariable(value = "id") int cottageBehavioralRuleId)
			throws ResourceNotFoundException {
		return cottageBehavioralRuleService.deleteCottageBehavioralRule(cottageBehavioralRuleId);
	}
}
