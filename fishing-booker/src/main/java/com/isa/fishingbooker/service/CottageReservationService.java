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
import com.isa.fishingbooker.model.CottageReservation;
import com.isa.fishingbooker.repository.CottageReservationRepository;

@Service
public class CottageReservationService {

	@Autowired
	private CottageReservationRepository CottageReservationRepository;
	
	public List<CottageReservation> getAllCottageReservations(){
		return this.CottageReservationRepository.findAll();
	}
		
	public ResponseEntity<CottageReservation> getCottageReservationById(int cottageReservationId)
		throws ResourceNotFoundException{
		CottageReservation cottageReservation = CottageReservationRepository.findById(cottageReservationId).orElseThrow(() -> new ResourceNotFoundException("CottageReservation not found for this id :: " + cottageReservationId));
	 return ResponseEntity.ok().body(cottageReservation);
	}
	
	@PostMapping("/cottageReservations")
	public CottageReservation createCottageReservation(CottageReservation cottageReservation) {
		return CottageReservationRepository.save(cottageReservation);
	}
	
	
	@PutMapping("/cottageReservation/{id}")
	public ResponseEntity<CottageReservation> updateCottageReservation(Integer cottageReservationId,
			 @RequestBody CottageReservation cottageReservationDetails) throws ResourceNotFoundException {
		CottageReservation cottageReservation = CottageReservationRepository.findById(cottageReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageReservation not found for this id :: " + cottageReservationId));
		
		cottageReservation.setStartDate(cottageReservationDetails.getStartDate());
		cottageReservation.setFinishDate(cottageReservationDetails.getFinishDate());
		cottageReservation.setMaxPeople(cottageReservationDetails.getMaxPeople());
		
		final CottageReservation updatedCottageReservation = CottageReservationRepository.save(cottageReservation);
		return ResponseEntity.ok(updatedCottageReservation);
	}
	
	@DeleteMapping("/cottageReservations/{id}")
	public Map<String, Boolean> deleteCottageReservation(int cottageReservationId)
			throws ResourceNotFoundException {
		CottageReservation  cottageReservation = CottageReservationRepository.findById(cottageReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageReservation not found for this id :: " + cottageReservationId));

		CottageReservationRepository.delete(cottageReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
