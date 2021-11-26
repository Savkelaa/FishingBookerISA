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
import com.isa.fishingbooker.model.FishingClassRate;
import com.isa.fishingbooker.service.FishingClassRateService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FishingClassRateController {

	@Autowired
	private FishingClassRateService fishingClassRateService;

	@GetMapping("/fishingClassRates")
	public List<FishingClassRate> getAllFishingClassRates() {
		return this.fishingClassRateService.getAllFishingClassRates();
	}

	@GetMapping("/fishingClassRates/{id}")
	public ResponseEntity<FishingClassRate> getFishingClassRateById(@PathVariable(value = "id") int fishingClassRateId)
			throws ResourceNotFoundException {
		return fishingClassRateService.getFishingClassRateById(fishingClassRateId);
	}

	@PostMapping("/fishingClassRates")
	public FishingClassRate createFishingClassRate(@RequestBody FishingClassRate fishingClassRate) {
		return fishingClassRateService.createFishingClassRate(fishingClassRate);
	}

	@PutMapping("/fishingClassRates/{id}")
	public ResponseEntity<FishingClassRate> updateFishingClassRate(@PathVariable(value = "id") int fishingClassRateId,
			@RequestBody FishingClassRate fishingClassRateDetails) throws ResourceNotFoundException {
		return fishingClassRateService.updateFishingClassRate(fishingClassRateId, fishingClassRateDetails);
	}

	@DeleteMapping("/fishingClassRates/{id}")
	public Map<String, Boolean> deleteFishingClassRate(@PathVariable(value = "id") int fishingClassRateId)
			throws ResourceNotFoundException {
		return fishingClassRateService.deleteFishingClassRate(fishingClassRateId);
	}
}
