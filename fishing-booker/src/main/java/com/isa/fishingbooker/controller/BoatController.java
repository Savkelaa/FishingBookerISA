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
import com.isa.fishingbooker.model.Boat;
import com.isa.fishingbooker.service.BoatService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatController {

	@Autowired
	private BoatService boatService;

	@GetMapping("/boats")
	public List<Boat> getAllBoats() {
		return this.boatService.getAllBoats();
	}

	@GetMapping("/boats/{id}")
	public ResponseEntity<Boat> getBoatById(@PathVariable(value = "id") int boatId)
			throws ResourceNotFoundException {
		return boatService.getBoatById(boatId);
	}

	@PostMapping("/boats")
	public Boat createBoat(@RequestBody Boat boat) {
		return boatService.createBoat(boat);
	}

	@PutMapping("/boats/{id}")
	public ResponseEntity<Boat> updateBoat(@PathVariable(value = "id") int boatId,
			@RequestBody Boat boatDetails) throws ResourceNotFoundException {
		return boatService.updateBoat(boatId, boatDetails);
	}

	@DeleteMapping("/boats/{id}")
	public Map<String, Boolean> deleteBoat(@PathVariable(value = "id") int boatId)
			throws ResourceNotFoundException {
		return boatService.deleteBoat(boatId);
	}
}
