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
import com.isa.fishingbooker.model.CottageQuickReservation;
import com.isa.fishingbooker.service.CottageQuickReservationService;

@RestController
@RequestMapping("/api/v1")
public class CottageQuickReservationController {

	@Autowired
	private CottageQuickReservationService cottageQuickReservationService;

	@GetMapping("/cottageQuickReservations")
	public List<CottageQuickReservation> getAllCottageQuickReservations() {
		return this.cottageQuickReservationService.getAllCottageQuickReservations();
	}

	@GetMapping("/cottageQuickReservations/{id}")
	public ResponseEntity<CottageQuickReservation> getCottageQuickReservationById(@PathVariable(value = "id") int cottageQuickReservationId)
			throws ResourceNotFoundException {
		return cottageQuickReservationService.getCottageQuickReservationById(cottageQuickReservationId);
	}

	@PostMapping("/cottageQuickReservations")
	public CottageQuickReservation createCottageQuickReservation(@RequestBody CottageQuickReservation cottageQuickReservation) {
		return cottageQuickReservationService.createCottageQuickReservation(cottageQuickReservation);
	}

	@PutMapping("/cottageQuickReservations/{id}")
	public ResponseEntity<CottageQuickReservation> updateCottageQuickReservation(@PathVariable(value = "id") int cottageQuickReservationId,
			@RequestBody CottageQuickReservation cottageQuickReservationDetails) throws ResourceNotFoundException {
		return cottageQuickReservationService.updateCottageQuickReservation(cottageQuickReservationId, cottageQuickReservationDetails);
	}

	@DeleteMapping("/cottageQuickReservations/{id}")
	public Map<String, Boolean> deleteCottageQuickReservation(@PathVariable(value = "id") int cottageQuickReservationId)
			throws ResourceNotFoundException {
		return cottageQuickReservationService.deleteCottageQuickReservation(cottageQuickReservationId);
	}
}