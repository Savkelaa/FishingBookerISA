package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.CottageReservation;
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
import com.isa.fishingbooker.model.BoatReservation;
import com.isa.fishingbooker.model.BoatReservation;
import com.isa.fishingbooker.service.BoatReservationService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatReservationController {

	@Autowired
	private BoatReservationService boatReservationService;

	@GetMapping("/boatReservations")
	public List<BoatReservation> getAllBoatReservations() {
		return this.boatReservationService.getAllBoatReservations();
	}

	@GetMapping("/boatReservations/{id}")
	public ResponseEntity<BoatReservation> getBoatReservationById(@PathVariable(value = "id") int boatReservationId)
			throws ResourceNotFoundException {
		return boatReservationService.getBoatReservationById(boatReservationId);
	}

	@GetMapping("/boatReservationBoatOwner")
	public List<BoatReservation> getBoatReservationsByBoatOwner(@RequestParam (value="boatOwnerId")  Integer boatOwnerId)
	{
		return boatReservationService.getBoatReservationsByBoatOwner(boatOwnerId);
	}


	@PostMapping("/boatReservations")
	public BoatReservation createBoatReservation(@RequestBody BoatReservation boatReservation) {
		return boatReservationService.createBoatReservation(boatReservation);
	}

	@PutMapping("/boatReservations/{id}")
	public ResponseEntity<BoatReservation> updateBoatReservation(@PathVariable(value = "id") int boatReservationId,
			@RequestBody BoatReservation boatReservationDetails) throws ResourceNotFoundException {
		return boatReservationService.updateBoatReservation(boatReservationId, boatReservationDetails);
	}

	@DeleteMapping("/boatReservations/{id}")
	public Map<String, Boolean> deleteBoatReservation(@PathVariable(value = "id") int boatReservationId)
			throws ResourceNotFoundException {
		return boatReservationService.deleteBoatReservation(boatReservationId);
	}
	@GetMapping("/allBoatReservationsByClient")
	public List<BoatReservation> getAllBoatReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return boatReservationService.getAllBoatReservationByClient(clientId);
	}
	@GetMapping("/allFinishedBoatReservationsByClient")
	public List<BoatReservation> getAllFinishedBoatReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return boatReservationService.getAllFinishedBoatReservationByClient(clientId);
	}
	
	@GetMapping("/allBoatReservationsAtPresentByClient")
	public List<BoatReservation> getAllBoatReservationAtPresentByClient(@RequestParam (value="clientId")  Integer clientId){
		return boatReservationService.getAllBoatReservationAtPresentByClient(clientId);
	}
	@GetMapping("/allFinishedBoatReservationsByClientSortedByDateAsc")
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDateAsc(@RequestParam (value="clientId")  Integer clientId){
		return boatReservationService.getAllFinishedBoatReservationByClientSortedByDateAsc(clientId);
	}
	@GetMapping("/allFinishedBoatReservationsByClientSortedByDateDesc")
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDateDesc(@RequestParam (value="clientId")  Integer clientId){
		return boatReservationService.getAllFinishedBoatReservationByClientSortedByDateDesc(clientId);
	}
	@GetMapping("/allFinishedBoatReservationsByClientSortedByDurationAsc")
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDurationAsc(@RequestParam (value="clientId")  Integer clientId){
		return boatReservationService.getAllFinishedBoatReservationByClientSortedByDurationAsc(clientId);
	}
	@GetMapping("/allFinishedBoatReservationsByClientSortedByDurationDesc")
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDurationDesc(@RequestParam (value="clientId")  Integer clientId){
		return boatReservationService.getAllFinishedBoatReservationByClientSortedByDurationDesc(clientId);
	}
}
