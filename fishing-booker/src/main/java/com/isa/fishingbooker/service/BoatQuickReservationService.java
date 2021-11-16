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
import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.repository.BoatQuickReservationRepository;

@Service
public class BoatQuickReservationService {

	@Autowired
	private BoatQuickReservationRepository BoatQuickReservationRepository;
	
	public List<BoatQuickReservation> getAllBoatQuickReservations(){
		return this.BoatQuickReservationRepository.findAll();
	}
		
	public ResponseEntity<BoatQuickReservation> getBoatQuickReservationById(int boatQuickReservationId)
		throws ResourceNotFoundException{
		BoatQuickReservation boatQuickReservation = BoatQuickReservationRepository.findById(boatQuickReservationId).orElseThrow(() -> new ResourceNotFoundException("BoatQuickReservation not found for this id :: " + boatQuickReservationId));
	 return ResponseEntity.ok().body(boatQuickReservation);
	}
	
	@PostMapping("/boatQuickReservations")
	public BoatQuickReservation createBoatQuickReservation(BoatQuickReservation boatQuickReservation) {
		return BoatQuickReservationRepository.save(boatQuickReservation);
	}
	
	
	@PutMapping("/boatQuickReservation/{id}")
	public ResponseEntity<BoatQuickReservation> updateBoatQuickReservation(Integer boatQuickReservationId,
			 @RequestBody BoatQuickReservation boatQuickReservationDetails) throws ResourceNotFoundException {
		BoatQuickReservation boatQuickReservation = BoatQuickReservationRepository.findById(boatQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatQuickReservation not found for this id :: " + boatQuickReservationId));
		
		boatQuickReservation.setCancellationCondition(boatQuickReservationDetails.getCancellationCondition());
		boatQuickReservation.setDiscount(boatQuickReservationDetails.getDiscount());
		boatQuickReservation.setStartDate(boatQuickReservationDetails.getStartDate());
		boatQuickReservation.setFinishDate(boatQuickReservationDetails.getFinishDate());
		boatQuickReservation.setMaxPeople(boatQuickReservationDetails.getMaxPeople());
	
		final BoatQuickReservation updatedBoatQuickReservation = BoatQuickReservationRepository.save(boatQuickReservation);
		return ResponseEntity.ok(updatedBoatQuickReservation);
	}
	
	@DeleteMapping("/boatQuickReservations/{id}")
	public Map<String, Boolean> deleteBoatQuickReservation(int boatQuickReservationId)
			throws ResourceNotFoundException {
		BoatQuickReservation  boatQuickReservation = BoatQuickReservationRepository.findById(boatQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatQuickReservation not found for this id :: " + boatQuickReservationId));

		BoatQuickReservationRepository.delete(boatQuickReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
