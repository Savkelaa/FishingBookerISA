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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatRate;
import com.isa.fishingbooker.service.BoatRateService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatRateController {

	@Autowired
	private BoatRateService boatRateService;

	@GetMapping("/boatRates")
	public List<BoatRate> getAllBoatRates() {
		return this.boatRateService.getAllBoatRates();
	}

	@GetMapping("/boatRates/{id}")
	public ResponseEntity<BoatRate> getBoatRateById(@PathVariable(value = "id") int boatRateId)
			throws ResourceNotFoundException {
		return boatRateService.getBoatRateById(boatRateId);
	}
	@GetMapping("/boatRateRequests")
	public List<BoatRate> getAllBoatRateRequests() {
		return this.boatRateService.getAllBoatRateRequests();
	}

	@PostMapping("/boatRates")
	public BoatRate createBoatRate(@RequestBody BoatRate boatRate) {
		return boatRateService.createBoatRate(boatRate);
	}

	@PutMapping("/boatRates/{id}")
	public ResponseEntity<BoatRate> updateBoatRate(@PathVariable(value = "id") int boatRateId,
			@RequestBody BoatRate boatRateDetails) throws ResourceNotFoundException {
		return boatRateService.updateBoatRate(boatRateId, boatRateDetails);
	}

	@DeleteMapping("/boatRates/{id}")
	public Map<String, Boolean> deleteBoatRate(@PathVariable(value = "id") int boatRateId)
			throws ResourceNotFoundException {
		return boatRateService.deleteBoatRate(boatRateId);
	}
	
	@GetMapping("/boatAvgRate")
	public Double getBoatAvgRate(@RequestParam(value="boatId")  Integer boatId)
	{
		return boatRateService.getBoatAvgRate(boatId);
	}
	
}
