package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.BoatReservation;
import com.isa.fishingbooker.repository.BoatQuickReservationRepository;
import com.isa.fishingbooker.model.BoatQuickReservation;

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
import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.service.BoatQuickReservationService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatQuickReservationController {

	@Autowired
	private BoatQuickReservationService boatQuickReservationService;
	private BoatQuickReservationRepository boatQuickReservationREPOSITORY;

	@GetMapping("/boatQuickReservations")
	public List<BoatQuickReservation> getAllBoatQuickReservations() {
		return this.boatQuickReservationService.getAllBoatQuickReservations();
	}
	
	@GetMapping("/boatQuickReservations2")
	public List<BoatQuickReservation> getAllBoatQuickReservations2() {
		return this.boatQuickReservationService.getAllBoatQuickReservations2();
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
	@GetMapping("/boatQuickReservationBoatOwner")
	public List<BoatQuickReservation> getBoatQuickReservationsByBoatOwner(@RequestParam (value="boatOwnerId")  Integer boatOwnerId)
	{
		return boatQuickReservationService.getBoatQuickReservationsByBoatOwner(boatOwnerId);
	}

	@GetMapping("/priceCompletedBoatQuickReservation")
	public Double getTotalPriceCompletedBoatQuickReservations()
	{
		return this.boatQuickReservationService.getTotalPriceCompletedBoatQuickReservations();
	}

	@DeleteMapping("/boatQuickReservations/{id}")
	public Map<String, Boolean> deleteBoatQuickReservation(@PathVariable(value = "id") int boatQuickReservationId)
			throws ResourceNotFoundException {
		return boatQuickReservationService.deleteBoatQuickReservation(boatQuickReservationId);
	}
	@GetMapping("/allBoatQuickReservationsByClient")
	public List<BoatQuickReservation> getAllBoatQuickReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return boatQuickReservationService.getAllBoatQuickReservationByClient(clientId);
	}
	@GetMapping("/allFinishedBoatQuickReservationsByClient")
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return boatQuickReservationService.getAllFinishedBoatQuickReservationByClient(clientId);
	}
	
	@GetMapping("/allBoatQuickReservationsAtPresentByClient")
	public List<BoatQuickReservation> getAllBoatQuickReservationAtPresentByClient(@RequestParam (value="clientId")  Integer clientId){
		return boatQuickReservationService.getAllBoatQuickReservationAtPresentByClient(clientId);
	}
	@GetMapping("/allFinishedBoatQuickReservationsByClientSortedByDateAsc")
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDateAsc(@RequestParam (value="clientId")  Integer clientId){
		return boatQuickReservationService.getAllFinishedBoatQuickReservationByClientSortedByDateAsc(clientId);
	}
	@GetMapping("/allFinishedBoatQuickReservationsByClientSortedByDateDesc")
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDateDesc(@RequestParam (value="clientId")  Integer clientId){
		return boatQuickReservationService.getAllFinishedBoatQuickReservationByClientSortedByDateDesc(clientId);
	}
	@GetMapping("/allFinishedBoatQuickReservationsByClientSortedByDurationAsc")
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDurationAsc(@RequestParam (value="clientId")  Integer clientId){
		return boatQuickReservationService.getAllFinishedBoatQuickReservationByClientSortedByDurationAsc(clientId);
	}
	@GetMapping("/allFinishedBoatQuickReservationsByClientSortedByDurationDesc")
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDurationDesc(@RequestParam (value="clientId")  Integer clientId){
		return boatQuickReservationService.getAllFinishedBoatQuickReservationByClientSortedByDurationDesc(clientId);
	}
	
	@GetMapping("/boatQuickReservationsByOwner")
	public List<BoatQuickReservation> getBoatQuickReservationsByOwner(@RequestParam (value = "boatOwnerId") Integer boatOwnerId){
		return boatQuickReservationService.getBoatQuickReservationsByOwner(boatOwnerId);
	}
	
	@GetMapping("/freeBoatQuickReservationsByBoat")
	public List<BoatQuickReservation> getFreeBoatQuickReservationsByBoat(@RequestParam (value = "boatId") Integer boatId){
		return boatQuickReservationService.getFreeBoatQuickReservationsByBoat(boatId);
	}
	
	@GetMapping("/BoatQuickReservationsByBoat")
	public List<BoatQuickReservation> getBoatQuickReservationsByBoat(@RequestParam (value = "boatId") Integer boatId){
		return boatQuickReservationService.getBoatQuickReservationsByBoat(boatId);
	}
	
}
