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
import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.service.FishingClassReservationService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FishingClassReservationController {

	@Autowired
	private FishingClassReservationService fishingClassReservationService;

	
	@GetMapping("/fishingClassReservations")
	public List<FishingClassReservation> getAllFishingClassReservations() {
		return this.fishingClassReservationService.getAllFishingClassReservations();
	}

	@GetMapping("/fishingClassReservations/{id}")
	public ResponseEntity<FishingClassReservation> getFishingClassReservationById(@PathVariable(value = "id") int fishingClassReservationId)
			throws ResourceNotFoundException {
		return fishingClassReservationService.getFishingClassReservationById(fishingClassReservationId);
	}

	@PostMapping("/fishingClassReservations")
	public FishingClassReservation createFishingClassReservation(@RequestBody FishingClassReservation fishingClassReservation) {
		return fishingClassReservationService.createFishingClassReservation(fishingClassReservation);
	}

	@PutMapping("/fishingClassReservations/{id}")
	public ResponseEntity<FishingClassReservation> updateFishingClassReservation(@PathVariable(value = "id") int fishingClassReservationId,
			@RequestBody FishingClassReservation fishingClassReservationDetails) throws ResourceNotFoundException {
		return fishingClassReservationService.updateFishingClassReservation(fishingClassReservationId, fishingClassReservationDetails);
	}

	@DeleteMapping("/fishingClassReservations/{id}")
	public Map<String, Boolean> deleteFishingClassReservation(@PathVariable(value = "id") int fishingClassReservationId)
			throws ResourceNotFoundException {
		return fishingClassReservationService.deleteFishingClassReservation(fishingClassReservationId);
	}
	
	@GetMapping("/allFishingClassReservationsByClient")
	public List<FishingClassReservation> getAllFishingClassReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassReservationService.getAllFishingClassReservationByClient(clientId);
	}
	@GetMapping("/allFinishedFishingClassReservationsByClient")
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassReservationService.getAllFinishedFishingClassReservationByClient(clientId);
	}
	
	@GetMapping("/allFishingClassReservationsAtPresentByClient")
	public List<FishingClassReservation> getAllFishingClassReservationAtPresentByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassReservationService.getAllFishingClassReservationAtPresentByClient(clientId);
	}
	@GetMapping("/allFinishedFishingClassReservationsByClientSortedByDateAsc")
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDateAsc(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassReservationService.getAllFinishedFishingClassReservationByClientSortedByDateAsc(clientId);
	}
	@GetMapping("/allFinishedFishingClassReservationsByClientSortedByDateDesc")
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDateDesc(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassReservationService.getAllFinishedFishingClassReservationByClientSortedByDateDesc(clientId);
	}
	@GetMapping("/allFinishedFishingClassReservationsByClientSortedByDurationAsc")
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDurationAsc(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassReservationService.getAllFinishedFishingClassReservationByClientSortedByDurationAsc(clientId);
	}
	@GetMapping("/allFinishedFishingClassReservationsByClientSortedByDurationDesc")
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDurationDesc(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassReservationService.getAllFinishedFishingClassReservationByClientSortedByDurationDesc(clientId);
	}
}
