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
import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.service.BoatQuickReservationService;

@RestController
@RequestMapping("/api/v1")
public class BoatQuickReservationController {

	@Autowired
	private BoatQuickReservationService boatQuickReservationService;

	@GetMapping("/boatQuickReservations")
	public List<BoatQuickReservation> getAllBoatQuickReservations() {
		return this.boatQuickReservationService.getAllBoatQuickReservations();
	}

	@GetMapping("/boatQuickReservations/{id}")
	public ResponseEntity<BoatQuickReservation> getBoatQuickReservationById(@PathVariable(value = "id") int boatQuickReservationId)
			throws ResourceNotFoundException {
		return boatQuickReservationService.getBoatQuickReservationById(boatQuickReservationId);
	}

	@PostMapping("/boatQuickReservations")
	public BoatQuickReservation createBoatQuickReservation(@RequestBody BoatQuickReservation boatQuickReservation) {
		return boatQuickReservationService.createBoatQuickReservation(boatQuickReservation);
	}

	@PutMapping("/boatQuickReservations/{id}")
	public ResponseEntity<BoatQuickReservation> updateBoatQuickReservation(@PathVariable(value = "id") int boatQuickReservationId,
			@RequestBody BoatQuickReservation boatQuickReservationDetails) throws ResourceNotFoundException {
		return boatQuickReservationService.updateBoatQuickReservation(boatQuickReservationId, boatQuickReservationDetails);
	}

	@DeleteMapping("/boatQuickReservations/{id}")
	public Map<String, Boolean> deleteBoatQuickReservation(@PathVariable(value = "id") int boatQuickReservationId)
			throws ResourceNotFoundException {
		return boatQuickReservationService.deleteBoatQuickReservation(boatQuickReservationId);
	}
}
