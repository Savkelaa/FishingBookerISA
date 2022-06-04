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
import com.isa.fishingbooker.model.BoatReservation;
import com.isa.fishingbooker.model.CottageReservation;
import com.isa.fishingbooker.repository.BoatReservationRepository;

@Service
public class BoatReservationService {

	@Autowired
	private BoatReservationRepository BoatReservationRepository;
	
	public List<BoatReservation> getAllBoatReservations(){
		return this.BoatReservationRepository.findAll();
	}
		
	public ResponseEntity<BoatReservation> getBoatReservationById(int boatReservationId)
		throws ResourceNotFoundException{
		BoatReservation boatReservation = BoatReservationRepository.findById(boatReservationId).orElseThrow(() -> new ResourceNotFoundException("BoatReservation not found for this id :: " + boatReservationId));
	 return ResponseEntity.ok().body(boatReservation);
	}

	public List<BoatReservation> getBoatReservationsByBoatOwner(Integer boatOwnerId)
	{
		return BoatReservationRepository.getBoatReservationsByBoatOwner(boatOwnerId);
	}

	
	public BoatReservation createBoatReservation(BoatReservation boatReservation) {
		return BoatReservationRepository.save(boatReservation);
	}
	
	

	public ResponseEntity<BoatReservation> updateBoatReservation(Integer boatReservationId,
			 @RequestBody BoatReservation boatReservationDetails) throws ResourceNotFoundException {
		BoatReservation boatReservation = BoatReservationRepository.findById(boatReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatReservation not found for this id :: " + boatReservationId));
		
		boatReservation.setCancellationCondition(boatReservationDetails.getCancellationCondition());
		boatReservation.setStartDate(boatReservationDetails.getStartDate());
		boatReservation.setFinishDate(boatReservationDetails.getFinishDate());
		boatReservation.setMaxPeople(boatReservationDetails.getMaxPeople());
	
		final BoatReservation updatedBoatReservation = BoatReservationRepository.save(boatReservation);
		return ResponseEntity.ok(updatedBoatReservation);
	}
	

	public Map<String, Boolean> deleteBoatReservation(int boatReservationId)
			throws ResourceNotFoundException {
		BoatReservation  boatReservation = BoatReservationRepository.findById(boatReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatReservation not found for this id :: " + boatReservationId));

		BoatReservationRepository.delete(boatReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public List<BoatReservation> getAllBoatReservationByClient(Integer clientId){
		return BoatReservationRepository.getAllBoatReservationByClient(clientId);
	}
	
	public List<BoatReservation> getAllFinishedBoatReservationByClient(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClient(clientId);
	}
	
	public List<BoatReservation> getAllBoatReservationAtPresentByClient(Integer clientId){
		return BoatReservationRepository.getAllBoatReservationAtPresentByClient(clientId);
	}
	
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDateAsc(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClientSortedByDateAsc(clientId);
	}
	
	
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDateDesc(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClientSortedByDateDesc(clientId);
	}
	
	
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDurationAsc(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClientSortedByDurationAsc(clientId);
	}
	
	
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDurationDesc(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClientSortedByDurationDesc(clientId);
	}
}
