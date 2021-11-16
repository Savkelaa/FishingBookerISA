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
import com.isa.fishingbooker.model.CottageOwnerRate;
import com.isa.fishingbooker.repository.CottageOwnerRateRepository;

@Service
public class CottageOwnerRateService {

	@Autowired
	private CottageOwnerRateRepository CottageOwnerRateRepository;
	
	public List<CottageOwnerRate> getAllCottageOwnerRates(){
		return this.CottageOwnerRateRepository.findAll();
	}
		
	public ResponseEntity<CottageOwnerRate> getCottageOwnerRateById(int cottageOwnerRateId)
		throws ResourceNotFoundException{
		CottageOwnerRate cottageOwnerRate = CottageOwnerRateRepository.findById(cottageOwnerRateId).orElseThrow(() -> new ResourceNotFoundException("CottageOwnerRate not found for this id :: " + cottageOwnerRateId));
	 return ResponseEntity.ok().body(cottageOwnerRate);
	}
	
	@PostMapping("/cottageOwnerRates")
	public CottageOwnerRate createCottageOwnerRate(CottageOwnerRate cottageOwnerRate) {
		return CottageOwnerRateRepository.save(cottageOwnerRate);
	}
	
	
	@PutMapping("/cottageOwnerRate/{id}")
	public ResponseEntity<CottageOwnerRate> updateCottageOwnerRate(Integer cottageOwnerRateId,
			 @RequestBody CottageOwnerRate cottageOwnerRateDetails) throws ResourceNotFoundException {
		CottageOwnerRate cottageOwnerRate = CottageOwnerRateRepository.findById(cottageOwnerRateId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwnerRate not found for this id :: " + cottageOwnerRateId));
		
		cottageOwnerRate.setRate(cottageOwnerRateDetails.getRate());
	
		final CottageOwnerRate updatedCottageOwnerRate = CottageOwnerRateRepository.save(cottageOwnerRate);
		return ResponseEntity.ok(updatedCottageOwnerRate);
	}
	
	@DeleteMapping("/cottageOwnerRates/{id}")
	public Map<String, Boolean> deleteCottageOwnerRate(int cottageOwnerRateId)
			throws ResourceNotFoundException {
		CottageOwnerRate  cottageOwnerRate = CottageOwnerRateRepository.findById(cottageOwnerRateId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwnerRate not found for this id :: " + cottageOwnerRateId));

		CottageOwnerRateRepository.delete(cottageOwnerRate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
