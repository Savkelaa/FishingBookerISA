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
	
	@PostMapping("/boatReservations")
	public BoatReservation createBoatReservation(BoatReservation boatReservation) {
		return BoatReservationRepository.save(boatReservation);
	}
	
	
	@PutMapping("/boatReservation/{id}")
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
	
	@DeleteMapping("/boatReservations/{id}")
	public Map<String, Boolean> deleteBoatReservation(int boatReservationId)
			throws ResourceNotFoundException {
		BoatReservation  boatReservation = BoatReservationRepository.findById(boatReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatReservation not found for this id :: " + boatReservationId));

		BoatReservationRepository.delete(boatReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}