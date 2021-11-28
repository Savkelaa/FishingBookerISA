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
		
		fishingClassQuickReservation.setDiscount(fishingClassQuickReservationDetails.getDiscount());
		fishingClassQuickReservation.setStartDate(fishingClassQuickReservationDetails.getStartDate());
		fishingClassQuickReservation.setFinishDate(fishingClassQuickReservationDetails.getFinishDate());
		fishingClassQuickReservation.setMaxPeople(fishingClassQuickReservationDetails.getMaxPeople());
	    fishingClassQuickReservation.setStatus(fishingClassQuickReservationDetails.getStatus());
		
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
}
