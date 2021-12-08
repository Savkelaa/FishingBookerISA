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
import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.repository.FishingClassReservationRepository;

@Service
public class FishingClassReservationService {

	@Autowired
	private FishingClassReservationRepository FishingClassReservationRepository;
	
	
	
	public List<FishingClassReservation> getAllFishingClassReservations(){
		return this.FishingClassReservationRepository.findAll();
	}
	
	public List<FishingClassReservation> getUnavailableFishingClassReservationsByInstructor(Integer instructorId)
	{
		return FishingClassReservationRepository.getUnavailableFishingClassReservationsByInstructor(instructorId);
	}
	
	
	public List<FishingClassReservation> getFinishedFishingClassReservationsByInstructor(Integer instructorId)
	{
		return FishingClassReservationRepository.getFinishedFishingClassReservationsByInstructor(instructorId);
	}
	
	public ResponseEntity<FishingClassReservation> getFishingClassReservationById(int fishingClassReservationId)
		throws ResourceNotFoundException{
		FishingClassReservation fishingClassReservation = FishingClassReservationRepository.findById(fishingClassReservationId).orElseThrow(() -> new ResourceNotFoundException("FishingClassReservation not found for this id :: " + fishingClassReservationId));
	 return ResponseEntity.ok().body(fishingClassReservation);
	}
	

	public FishingClassReservation createFishingClassReservation(FishingClassReservation fishingClassReservation) {
		return FishingClassReservationRepository.save(fishingClassReservation);
	}
	

	public ResponseEntity<FishingClassReservation> updateFishingClassReservation(Integer fishingClassReservationId,
			 @RequestBody FishingClassReservation fishingClassReservationDetails) throws ResourceNotFoundException {
		FishingClassReservation fishingClassReservation = FishingClassReservationRepository.findById(fishingClassReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassReservation not found for this id :: " + fishingClassReservationId));
		
		fishingClassReservation.setStartDate(fishingClassReservationDetails.getStartDate());
		fishingClassReservation.setFinishDate(fishingClassReservationDetails.getFinishDate());
		fishingClassReservation.setPrice(fishingClassReservationDetails.getPrice());
		fishingClassReservation.setStatus(fishingClassReservationDetails.getStatus());
		fishingClassReservation.setPlace(fishingClassReservationDetails.getPlace());
		
		final FishingClassReservation updatedFishingClassReservation = FishingClassReservationRepository.save(fishingClassReservation);
		return ResponseEntity.ok(updatedFishingClassReservation);
	}
	

	public Map<String, Boolean> deleteFishingClassReservation(int fishingClassReservationId)
			throws ResourceNotFoundException {
		FishingClassReservation  fishingClassReservation = FishingClassReservationRepository.findById(fishingClassReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassReservation not found for this id :: " + fishingClassReservationId));

		FishingClassReservationRepository.delete(fishingClassReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public List<FishingClassReservation> getAllFishingClassReservationByClient(Integer clientId){
		return FishingClassReservationRepository.getAllFishingClassReservationByClient(clientId);
	}
	
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClient(Integer clientId){
		return FishingClassReservationRepository.getAllFinishedFishingClassReservationByClient(clientId);
	}
	
	public List<FishingClassReservation> getAllFishingClassReservationAtPresentByClient(Integer clientId){
		return FishingClassReservationRepository.getAllFishingClassReservationAtPresentByClient(clientId);
	}
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDateAsc(Integer clientId){
		return FishingClassReservationRepository.getAllFinishedFishingClassReservationByClientSortedByDateAsc(clientId);
	}
	
	
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDateDesc(Integer clientId){
		return FishingClassReservationRepository.getAllFinishedFishingClassReservationByClientSortedByDateDesc(clientId);
	}
	
	
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDurationAsc(Integer clientId){
		return FishingClassReservationRepository.getAllFinishedFishingClassReservationByClientSortedByDurationAsc(clientId);
	}
	
	
	public List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDurationDesc(Integer clientId){
		return FishingClassReservationRepository.getAllFinishedFishingClassReservationByClientSortedByDurationDesc(clientId);
	}
}
