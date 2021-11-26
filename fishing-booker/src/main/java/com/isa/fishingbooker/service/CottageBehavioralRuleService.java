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
import com.isa.fishingbooker.model.CottageBehavioralRule;
import com.isa.fishingbooker.repository.CottageBehavioralRuleRepository;

@Service
public class CottageBehavioralRuleService {

	@Autowired
	private CottageBehavioralRuleRepository CottageBehavioralRuleRepository;
	
	public List<CottageBehavioralRule> getAllCottageBehavioralRules(){
		return this.CottageBehavioralRuleRepository.findAll();
	}
		
	public ResponseEntity<CottageBehavioralRule> getCottageBehavioralRuleById(int cottageBehavioralRuleId)
		throws ResourceNotFoundException{
		CottageBehavioralRule cottageBehavioralRule = CottageBehavioralRuleRepository.findById(cottageBehavioralRuleId).orElseThrow(() -> new ResourceNotFoundException("CottageBehavioralRule not found for this id :: " + cottageBehavioralRuleId));
	 return ResponseEntity.ok().body(cottageBehavioralRule);
	}
	

	public CottageBehavioralRule createCottageBehavioralRule(CottageBehavioralRule cottageBehavioralRule) {
		return CottageBehavioralRuleRepository.save(cottageBehavioralRule);
	}
	
	
	
	public ResponseEntity<CottageBehavioralRule> updateCottageBehavioralRule(Integer cottageBehavioralRuleId,
			 @RequestBody CottageBehavioralRule cottageBehavioralRuleDetails) throws ResourceNotFoundException {
		CottageBehavioralRule cottageBehavioralRule = CottageBehavioralRuleRepository.findById(cottageBehavioralRuleId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageBehavioralRule not found for this id :: " + cottageBehavioralRuleId));
		
		cottageBehavioralRule.setName(cottageBehavioralRuleDetails.getName());
		cottageBehavioralRule.setDescription(cottageBehavioralRuleDetails.getDescription());
	
		final CottageBehavioralRule updatedCottageBehavioralRule = CottageBehavioralRuleRepository.save(cottageBehavioralRule);
		return ResponseEntity.ok(updatedCottageBehavioralRule);
	}
	

	public Map<String, Boolean> deleteCottageBehavioralRule(int cottageBehavioralRuleId)
			throws ResourceNotFoundException {
		CottageBehavioralRule  cottageBehavioralRule = CottageBehavioralRuleRepository.findById(cottageBehavioralRuleId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageBehavioralRule not found for this id :: " + cottageBehavioralRuleId));

		CottageBehavioralRuleRepository.delete(cottageBehavioralRule);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
