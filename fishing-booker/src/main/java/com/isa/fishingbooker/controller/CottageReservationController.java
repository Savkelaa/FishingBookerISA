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
import com.isa.fishingbooker.model.CottageReservation;
import com.isa.fishingbooker.service.CottageReservationService;

@RestController
@RequestMapping("/api/v1")
public class CottageReservationController {

	@Autowired
	private CottageReservationService cottageReservationService;

	@GetMapping("/cottageReservations")
	public List<CottageReservation> getAllCottageReservations() {
		return this.cottageReservationService.getAllCottageReservations();
	}

	@GetMapping("/cottageReservations/{id}")
	public ResponseEntity<CottageReservation> getCottageReservationById(@PathVariable(value = "id") int cottageReservationId)
			throws ResourceNotFoundException {
		return cottageReservationService.getCottageReservationById(cottageReservationId);
	}

	@PostMapping("/cottageReservations")
	public CottageReservation createCottageReservation(@RequestBody CottageReservation cottageReservation) {
		return cottageReservationService.createCottageReservation(cottageReservation);
	}

	@PutMapping("/cottageReservations/{id}")
	public ResponseEntity<CottageReservation> updateCottageReservation(@PathVariable(value = "id") int cottageReservationId,
			@RequestBody CottageReservation cottageReservationDetails) throws ResourceNotFoundException {
		return cottageReservationService.updateCottageReservation(cottageReservationId, cottageReservationDetails);
	}

	@DeleteMapping("/cottageReservations/{id}")
	public Map<String, Boolean> deleteCottageReservation(@PathVariable(value = "id") int cottageReservationId)
			throws ResourceNotFoundException {
		return cottageReservationService.deleteCottageReservation(cottageReservationId);
	}
}
