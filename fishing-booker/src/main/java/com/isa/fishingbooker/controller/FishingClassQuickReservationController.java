package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.dto.FishingClassQuickReservationAdditionalServices;
import com.isa.fishingbooker.model.CottageRate;
import com.isa.fishingbooker.model.FishingClassReservation;
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

	@GetMapping("/fishingClassQuickReservationInstructor")
	public List<FishingClassQuickReservation> getFishingClassQuickReservationsByInstructor(@RequestParam (value="instructorId")  Integer instructorId)
	{
		return fishingClassQuickReservationService.getFishingClassQuickReservationsByInstructor(instructorId);
	}

	@GetMapping("/priceCompletedFishingClassQuickReservation")
	public Double getTotalPriceCompletedFishingClassQuickReservations()
	{
		return fishingClassQuickReservationService.getTotalPriceCompletedFishingClassQuickReservations();
	}

	@GetMapping("/fishingClassFreeQuickReservation")
	public List<FishingClassQuickReservation> getAllFreeFishingClassQuickReservation(@RequestParam (value="fishingClassId")  Integer fishingClassId)
	{
		return fishingClassQuickReservationService.getAllFreeFishingClassQuickReservation(fishingClassId);
	}

	@GetMapping("/fishingClassQuickReservationFC")
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservationByFishingClass(@RequestParam (value="fishingClassId")  Integer fishingClassId)
	{
		return fishingClassQuickReservationService.getAllFishingClassQuickReservationByFishingClass(fishingClassId);
	}
	
	@GetMapping("/fishingClassDiscPrice")
	public Integer getPriceWithDiscountQuickReservationByFishingClass(@RequestParam (value="fishingClassId")  Integer fishingClassId)
	{
		return fishingClassQuickReservationService.getPriceWithDiscountQuickReservationByFishingClass(fishingClassId);
	}
	
	@GetMapping("/fishingClassPrice")
	public Integer getPriceQuickReservationByFishingClass(@RequestParam (value="fishingClassId")  Integer fishingClassId)
	{
		return fishingClassQuickReservationService.getPriceQuickReservationByFishingClass(fishingClassId);
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





	@PostMapping("/fishingClassQuickReservations")
	public FishingClassQuickReservation createFishingClassQuickReservation(@RequestBody FishingClassQuickReservation fishingClassQuickReservation) {
		return fishingClassQuickReservationService.createFishingClassQuickReservation(fishingClassQuickReservation);
	}

	@PostMapping("/fishingClassQuickReservations/{id}/additionalServices")	public ResponseEntity<FishingClassQuickReservation> addNewAdditionalService(@PathVariable(value = "id") int fishingClassQuickReservationId, @RequestBody FishingClassQuickReservationAdditionalServices additionalServices)
			throws ResourceNotFoundException {
		return fishingClassQuickReservationService.addNewAdditionalService(fishingClassQuickReservationId,additionalServices);
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
	@GetMapping("/fishingClassQuickReservationsByClient")
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFishingClassQuickReservationByClient(clientId);
	}
	@GetMapping("/finishedFishingClassQuickReservationsByClient")
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFinishedFishingClassQuickReservationByClient(clientId);
	}
	
	@GetMapping("/fishingClassQuickReservationsAtPresentByClient")
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservationAtPresentByClient(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFishingClassQuickReservationAtPresentByClient(clientId);
	}
	@GetMapping("/finishedFishingClassQuickReservationsByClientSortedByDateAsc")
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDateAsc(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFinishedFishingClassQuickReservationByClientSortedByDateAsc(clientId);
	}
	@GetMapping("/finishedFishingClassQuickReservationsByClientSortedByDateDesc")
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDateDesc(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFinishedFishingClassQuickReservationByClientSortedByDateDesc(clientId);
	}
	@GetMapping("/finishedFishingClassQuickReservationsByClientSortedByDurationAsc")
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDurationAsc(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFinishedFishingClassQuickReservationByClientSortedByDurationAsc(clientId);
	}
	@GetMapping("/finishedFishingClassQuickReservationsByClientSortedByDurationDesc")
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDurationDesc(@RequestParam (value="clientId")  Integer clientId){
		return fishingClassQuickReservationService.getAllFinishedFishingClassQuickReservationByClientSortedByDurationDesc(clientId);
	}
}
