package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.FishingClassRate;
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
import com.isa.fishingbooker.model.CottageRate;
import com.isa.fishingbooker.service.CottageRateService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageRateController {

	@Autowired
	private CottageRateService cottageRateService;

	@GetMapping("/cottageRates")
	public List<CottageRate> getAllCottageRates() {
		return this.cottageRateService.getAllCottageRates();
	}

	@GetMapping("/cottageRateRequests")
	public List<CottageRate> getAllCottageRateRequests() {
		return this.cottageRateService.getAllCottageRateRequests();
	}

	@GetMapping("/cottageRates/{id}")
	public ResponseEntity<CottageRate> getCottageRateById(@PathVariable(value = "id") int cottageRateId)
			throws ResourceNotFoundException {
		return cottageRateService.getCottageRateById(cottageRateId);
	}

	@PostMapping("/cottageRates")
	public CottageRate createCottageRate(@RequestBody CottageRate cottageRate) {
		return cottageRateService.createCottageRate(cottageRate);
	}

	@PutMapping("/cottageRates/{id}")
	public ResponseEntity<CottageRate> updateCottageRate(@PathVariable(value = "id") int cottageRateId,
			@RequestBody CottageRate cottageRateDetails) throws ResourceNotFoundException {
		return cottageRateService.updateCottageRate(cottageRateId, cottageRateDetails);
	}

	@DeleteMapping("/cottageRates/{id}")
	public Map<String, Boolean> deleteCottageRate(@PathVariable(value = "id") int cottageRateId)
			throws ResourceNotFoundException {
		return cottageRateService.deleteCottageRate(cottageRateId);
	}
}
