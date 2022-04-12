package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.FishingClassQuickReservation;
import com.isa.fishingbooker.model.FishingClassQuickReservation;
import com.isa.fishingbooker.repository.FishingClassQuickReservationRepository;

@Service
public class FishingClassQuickReservationService {

	@Autowired
	private FishingClassQuickReservationRepository FishingClassQuickReservationRepository;
	
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservations(){
		return this.FishingClassQuickReservationRepository.findAll();
	}
	
	public Integer getPriceWithDiscountQuickReservationByFishingClass(Integer fishingClassId)
	{
		return FishingClassQuickReservationRepository.getPriceWithDiscountQuickReservationByFishingClass(fishingClassId);
	}
	
	
	public Integer getPriceQuickReservationByFishingClass(Integer fishingClassId)
	{
		return FishingClassQuickReservationRepository.getPriceQuickReservationByFishingClass(fishingClassId);
	}
	
	public List<FishingClassQuickReservation> getAllFreeFishingClassQuickReservation(Integer fishingClassId)
	{
		return FishingClassQuickReservationRepository.getAllFreeFishingClassQuickReservation(fishingClassId);
	}
		
	public List<FishingClassQuickReservation> getUnavailableFishingClassQuickReservationsByInstructor(Integer instructorId)
	{
		return FishingClassQuickReservationRepository.getUnavailableFishingClassQuickReservationsByInstructor(instructorId);
	}
	
	public List<FishingClassQuickReservation> getFinishedFishingClassQuickReservationsByInstructor(Integer instructorId)
	{
		return FishingClassQuickReservationRepository.getFinishedFishingClassQuickReservationsByInstructor(instructorId);
	}
	
	public ResponseEntity<FishingClassQuickReservation> getFishingClassQuickReservationById(int fishingClassQuickReservationId)
		throws ResourceNotFoundException{
		FishingClassQuickReservation fishingClassQuickReservation = FishingClassQuickReservationRepository.findById(fishingClassQuickReservationId).orElseThrow(() -> new ResourceNotFoundException("FishingClassQuickReservation not found for this id :: " + fishingClassQuickReservationId));
	 return ResponseEntity.ok().body(fishingClassQuickReservation);
	}
	
	
	public FishingClassQuickReservation createFishingClassQuickReservation(FishingClassQuickReservation fishingClassQuickReservation) {
		return FishingClassQuickReservationRepository.save(fishingClassQuickReservation);
	}
	

	public ResponseEntity<FishingClassQuickReservation> updateFishingClassQuickReservation(Integer fishingClassQuickReservationId,
			 @RequestBody FishingClassQuickReservation fishingClassQuickReservationDetails) throws ResourceNotFoundException {
		FishingClassQuickReservation fishingClassQuickReservation = FishingClassQuickReservationRepository.findById(fishingClassQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassQuickReservation not found for this id :: " + fishingClassQuickReservationId));


		fishingClassQuickReservation.setStartDate(fishingClassQuickReservationDetails.getStartDate());
		fishingClassQuickReservation.setFinishDate(fishingClassQuickReservationDetails.getFinishDate());
	    fishingClassQuickReservation.setStatus(fishingClassQuickReservationDetails.getStatus());
	    fishingClassQuickReservation.setPlace(fishingClassQuickReservationDetails.getPlace());
	    fishingClassQuickReservation.setPrice(fishingClassQuickReservationDetails.getPrice());
	    
		final FishingClassQuickReservation updatedFishingClassQuickReservation = FishingClassQuickReservationRepository.save(fishingClassQuickReservation);
		return ResponseEntity.ok(updatedFishingClassQuickReservation);
	}
	

	public Map<String, Boolean> deleteFishingClassQuickReservation(int fishingClassQuickReservationId)
			throws ResourceNotFoundException {
		FishingClassQuickReservation  fishingClassQuickReservation = FishingClassQuickReservationRepository.findById(fishingClassQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassQuickReservation not found for this id :: " + fishingClassQuickReservationId));

		FishingClassQuickReservationRepository.delete(fishingClassQuickReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservationByClient(Integer clientId){
		return FishingClassQuickReservationRepository.getAllFishingClassQuickReservationByClient(clientId);
	}
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClient(Integer clientId){
		return FishingClassQuickReservationRepository.getAllFinishedFishingClassQuickReservationByClient(clientId);
	}
	
	public List<FishingClassQuickReservation> getAllFishingClassQuickReservationAtPresentByClient(Integer clientId){
		return FishingClassQuickReservationRepository.getAllFishingClassQuickReservationAtPresentByClient(clientId);
	}
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDateAsc(Integer clientId){
		return FishingClassQuickReservationRepository.getAllFinishedFishingClassQuickReservationByClientSortedByDateAsc(clientId);
	}
	
	
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDateDesc(Integer clientId){
		return FishingClassQuickReservationRepository.getAllFinishedFishingClassQuickReservationByClientSortedByDateDesc(clientId);
	}
	
	
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDurationAsc(Integer clientId){
		return FishingClassQuickReservationRepository.getAllFinishedFishingClassQuickReservationByClientSortedByDurationAsc(clientId);
	}
	
	
	public List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDurationDesc(Integer clientId){
		return FishingClassQuickReservationRepository.getAllFinishedFishingClassQuickReservationByClientSortedByDurationDesc(clientId);
	}
}
