package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.FishingClassQuickReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



	@GetMapping("/fishingClassAvgRate")
	public Double getFishingClassAvgRate(@RequestParam(value="fishingClassId")  Integer fishingClassId)
	{
		return fishingClassRateService.getFishingClassAvgRate(fishingClassId);
	}


	@GetMapping("/fishingClassRateRequests")
	public List<FishingClassRate> getAllFishingClassRateRequests() {
		return this.fishingClassRateService.getAllFishingClassRateRequests();
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
