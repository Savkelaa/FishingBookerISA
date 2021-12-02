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
import com.isa.fishingbooker.model.FishingClassQuickReservation;
import com.isa.fishingbooker.model.FishingClassQuickReservation;
import com.isa.fishingbooker.service.FishingClassQuickReservationService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FishingClassQuickReservationController {

	@Autowired
	private FishingClassQuickReservationService fishingClassQuickReservationService;

	@GetMapping("/fishingClassQuickReservations")
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservations() {
		return this.fishingClassQuickReservationService.getAllFishingClassQuickReservations();
	}
	
	@GetMapping("/fishingClassUnavailableQuickReservation")
	public List<FishingClassQuickReservation> getUnavailableFishingClassQuickReservationsByInstructor(@RequestParam (value="instructorId")  Integer instructorId)
	{
		return fishingClassQuickReservationService.getUnavailableFishingClassQuickReservationsByInstructor(instructorId);
	}
	
	@GetMapping("/fishingClassFinishedQuickReservation")
	public List<FishingClassQuickReservation> getFinishedFishingClassQuickReservationsByInstructor(@RequestParam (value="instructorId")  Integer instructorId)
	{
		return fishingClassQuickReservationService.getFinishedFishingClassQuickReservationsByInstructor(instructorId);
	}

	@GetMapping("/fishingClassQuickReservations/{id}")
	public ResponseEntity<FishingClassQuickReservation> getFishingClassQuickReservationById(@PathVariable(value = "id") int fishingClassQuickReservationId)
			throws ResourceNotFoundException {
		return fishingClassQuickReservationService.getFishingClassQuickReservationById(fishingClassQuickReservationId);
	}

	@PostMapping("/fishingClassQuickReservations")
	public FishingClassQuickReservation createFishingClassQuickReservation(@RequestBody FishingClassQuickReservation fishingClassQuickReservation) {
		return fishingClassQuickReservationService.createFishingClassQuickReservation(fishingClassQuickReservation);
	}

	@PutMapping("/fishingClassQuickReservations/{id}")
	public ResponseEntity<FishingClassQuickReservation> updateFishingClassQuickReservation(@PathVariable(value = "id") int fishingClassQuickReservationId,
			@RequestBody FishingClassQuickReservation fishingClassQuickReservationDetails) throws ResourceNotFoundException {
		return fishingClassQuickReservationService.updateFishingClassQuickReservation(fishingClassQuickReservationId, fishingClassQuickReservationDetails);
	}

	@DeleteMapping("/fishingClassQuickReservations/{id}")
	public Map<String, Boolean> deleteFishingClassQuickReservation(@PathVariable(value = "id") int fishingClassQuickReservationId)
			throws ResourceNotFoundException {
		return fishingClassQuickReservationService.deleteFishingClassQuickReservation(fishingClassQuickReservationId);
	}
	@GetMapping("/allFishingClassQuickReservationsByClient")
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFishingClassQuickReservationByClient(clientId);
	}
	@GetMapping("/allFinishedFishingClassQuickReservationsByClient")
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFinishedFishingClassQuickReservationByClient(clientId);
	}
	
	@GetMapping("/allFishingClassQuickReservationsAtPresentByClient")
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservationAtPresentByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFishingClassQuickReservationAtPresentByClient(clientId);
	}
}
