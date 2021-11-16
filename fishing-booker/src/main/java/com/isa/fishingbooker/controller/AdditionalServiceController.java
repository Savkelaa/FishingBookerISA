package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.AdditionalService;
import com.isa.fishingbooker.service.AdditionalServiceService;

@RestController
@RequestMapping("/api/v1")
public class AdditionalServiceController {

	@Autowired
	private AdditionalServiceService additionalServiceService;

	@GetMapping("/additionalServices")
	public List<AdditionalService> getAllAdditionalServices() {
		return this.additionalServiceService.getAllAdditionalServices();
	}

	@GetMapping("/additionalServices/{id}")
	public ResponseEntity<AdditionalService> getAdditionalServiceById(@PathVariable(value = "id") int additionalServiceId)
			throws ResourceNotFoundException {
		return additionalServiceService.getAdditionalServiceById(additionalServiceId);
	}

	@PostMapping("/additionalServices")
	public AdditionalService createAdditionalService(@RequestBody AdditionalService additionalService) {
		return additionalServiceService.createAdditionalService(additionalService);
	}

	@PutMapping("/additionalServices/{id}")
	public ResponseEntity<AdditionalService> updateAdditionalService(@PathVariable(value = "id") int additionalServiceId,
			@RequestBody AdditionalService additionalServiceDetails) throws ResourceNotFoundException {
		return additionalServiceService.updateAdditionalService(additionalServiceId, additionalServiceDetails);
	}

	@DeleteMapping("/additionalServices/{id}")
	public Map<String, Boolean> deleteAdditionalService(@PathVariable(value = "id") int additionalServiceId)
			throws ResourceNotFoundException {
		return additionalServiceService.deleteAdditionalService(additionalServiceId);
	}
}