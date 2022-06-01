package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.InstructorRate;
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
import com.isa.fishingbooker.model.CottageOwnerRate;
import com.isa.fishingbooker.service.CottageOwnerRateService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageOwnerRateController {

	@Autowired
	private CottageOwnerRateService cottageOwnerRateService;

	@GetMapping("/cottageOwnerRates")
	public List<CottageOwnerRate> getAllCottageOwnerRates() {
		return this.cottageOwnerRateService.getAllCottageOwnerRates();
	}

	@GetMapping("/cottageOwnerRateRequests")
	public List<CottageOwnerRate> getAllCottageOwnerRateRequests() {
		return this.cottageOwnerRateService.getAllCottageOwnerRateRequests();
	}

	@GetMapping("/cottageOwnerRates/{id}")
	public ResponseEntity<CottageOwnerRate> getCottageOwnerRateById(@PathVariable(value = "id") int cottageOwnerRateId)
			throws ResourceNotFoundException {
		return cottageOwnerRateService.getCottageOwnerRateById(cottageOwnerRateId);
	}

	@PostMapping("/cottageOwnerRates")
	public CottageOwnerRate createCottageOwnerRate(@RequestBody CottageOwnerRate cottageOwnerRate) {
		return cottageOwnerRateService.createCottageOwnerRate(cottageOwnerRate);
	}

	@PutMapping("/cottageOwnerRates/{id}")
	public ResponseEntity<CottageOwnerRate> updateCottageOwnerRate(@PathVariable(value = "id") int cottageOwnerRateId,
			@RequestBody CottageOwnerRate cottageOwnerRateDetails) throws ResourceNotFoundException {
		return cottageOwnerRateService.updateCottageOwnerRate(cottageOwnerRateId, cottageOwnerRateDetails);
	}

	@DeleteMapping("/cottageOwnerRates/{id}")
	public Map<String, Boolean> deleteCottageOwnerRate(@PathVariable(value = "id") int cottageOwnerRateId)
			throws ResourceNotFoundException {
		return cottageOwnerRateService.deleteCottageOwnerRate(cottageOwnerRateId);
	}
}
