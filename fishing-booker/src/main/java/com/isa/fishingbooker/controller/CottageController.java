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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Cottage;
import com.isa.fishingbooker.model.CottageReservation;
import com.isa.fishingbooker.service.CottageService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageController {

	@Autowired
	private CottageService cottageService;

	@GetMapping("/cottages")
	public List<Cottage> getAllCottages() {
		return this.cottageService.getAllCottages();
	}

	@GetMapping("/cottages/{id}")
	public ResponseEntity<Cottage> getCottageById(@PathVariable(value = "id") int cottageId)
			throws ResourceNotFoundException {
		return cottageService.getCottageById(cottageId);
	}

	@PostMapping("/cottages")
	public Cottage createCottage(@RequestBody Cottage cottage) {
		return cottageService.createCottage(cottage);
	}

	@PutMapping("/cottages/{id}")
	public ResponseEntity<Cottage> updateCottage(@PathVariable(value = "id") int cottageId,
			@RequestBody Cottage cottageDetails) throws ResourceNotFoundException {
		return cottageService.updateCottage(cottageId, cottageDetails);
	}

	@DeleteMapping("/cottages/{id}")
	public Map<String, Boolean> deleteCottage(@PathVariable(value = "id") int cottageId)
			throws ResourceNotFoundException {
		return cottageService.deleteCottage(cottageId);
	}
	
	@GetMapping("/cottagesByOwner")
	public List<Cottage> getCottagesByOwner(@RequestParam (value = "cottageOwnerId") Integer cottageOwnerId){
		return cottageService.getCottagesByOwner(cottageOwnerId);
	}
}
