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
import com.isa.fishingbooker.model.BoatOwnerRate;
import com.isa.fishingbooker.service.BoatOwnerRateService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatOwnerRateController {

	@Autowired
	private BoatOwnerRateService boatOwnerRateService;

	@GetMapping("/boatOwnerRates")
	public List<BoatOwnerRate> getAllBoatOwnerRates() {
		return this.boatOwnerRateService.getAllBoatOwnerRates();
	}

	@GetMapping("/boatOwnerRates/{id}")
	public ResponseEntity<BoatOwnerRate> getBoatOwnerRateById(@PathVariable(value = "id") int boatOwnerRateId)
			throws ResourceNotFoundException {
		return boatOwnerRateService.getBoatOwnerRateById(boatOwnerRateId);
	}

	@GetMapping("/boatOwnerRateRequests")
	public List<BoatOwnerRate> getAllBoatOwnerRateRequests() {
		return this.boatOwnerRateService.getAllBoatOwnerRateRequests();
	}

	@PostMapping("/boatOwnerRates")
	public BoatOwnerRate createBoatOwnerRate(@RequestBody BoatOwnerRate boatOwnerRate) {
		return boatOwnerRateService.createBoatOwnerRate(boatOwnerRate);
	}

	@PutMapping("/boatOwnerRates/{id}")
	public ResponseEntity<BoatOwnerRate> updateBoatOwnerRate(@PathVariable(value = "id") int boatOwnerRateId,
			@RequestBody BoatOwnerRate boatOwnerRateDetails) throws ResourceNotFoundException {
		return boatOwnerRateService.updateBoatOwnerRate(boatOwnerRateId, boatOwnerRateDetails);
	}

	@DeleteMapping("/boatOwnerRates/{id}")
	public Map<String, Boolean> deleteBoatOwnerRate(@PathVariable(value = "id") int boatOwnerRateId)
			throws ResourceNotFoundException {
		return boatOwnerRateService.deleteBoatOwnerRate(boatOwnerRateId);
	}
}
