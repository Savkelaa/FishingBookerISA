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
import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.service.BoatOwnerService;

@RestController
@RequestMapping("/api/v1")
public class BoatOwnerController {

	@Autowired
	private BoatOwnerService boatOwnerService;

	@GetMapping("/boatOwners")
	public List<BoatOwner> getAllBoatOwners() {
		return this.boatOwnerService.getAllBoatOwners();
	}

	@GetMapping("/boatOwners/{id}")
	public ResponseEntity<BoatOwner> getBoatOwnerById(@PathVariable(value = "id") int boatOwnerId)
			throws ResourceNotFoundException {
		return boatOwnerService.getBoatOwnerById(boatOwnerId);
	}

	@PostMapping("/boatOwners")
	public BoatOwner createBoatOwner(@RequestBody BoatOwner boatOwner) {
		return boatOwnerService.createBoatOwner(boatOwner);
	}

	@PutMapping("/boatOwners/{id}")
	public ResponseEntity<BoatOwner> updateBoatOwner(@PathVariable(value = "id") int boatOwnerId,
			@RequestBody BoatOwner boatOwnerDetails) throws ResourceNotFoundException {
		return boatOwnerService.updateBoatOwner(boatOwnerId, boatOwnerDetails);
	}

	@DeleteMapping("/boatOwners/{id}")
	public Map<String, Boolean> deleteBoatOwner(@PathVariable(value = "id") int boatOwnerId)
			throws ResourceNotFoundException {
		return boatOwnerService.deleteBoatOwner(boatOwnerId);
	}
}