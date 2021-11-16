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
import com.isa.fishingbooker.model.CottageQuickReservation;
import com.isa.fishingbooker.repository.CottageQuickReservationRepository;

@Service
public class CottageQuickReservationService {

	@Autowired
	private CottageQuickReservationRepository CottageQuickReservationRepository;
	
	public List<CottageQuickReservation> getAllCottageQuickReservations(){
		return this.CottageQuickReservationRepository.findAll();
	}
		
	public ResponseEntity<CottageQuickReservation> getCottageQuickReservationById(int cottageQuickReservationId)
		throws ResourceNotFoundException{
		CottageQuickReservation cottageQuickReservation = CottageQuickReservationRepository.findById(cottageQuickReservationId).orElseThrow(() -> new ResourceNotFoundException("CottageQuickReservation not found for this id :: " + cottageQuickReservationId));
	 return ResponseEntity.ok().body(cottageQuickReservation);
	}
	
	@PostMapping("/cottageQuickReservations")
	public CottageQuickReservation createCottageQuickReservation(CottageQuickReservation cottageQuickReservation) {
		return CottageQuickReservationRepository.save(cottageQuickReservation);
	}
	
	
	@PutMapping("/cottageQuickReservation/{id}")
	public ResponseEntity<CottageQuickReservation> updateCottageQuickReservation(Integer cottageQuickReservationId,
			 @RequestBody CottageQuickReservation cottageQuickReservationDetails) throws ResourceNotFoundException {
		CottageQuickReservation cottageQuickReservation = CottageQuickReservationRepository.findById(cottageQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageQuickReservation not found for this id :: " + cottageQuickReservationId));
		
		cottageQuickReservation.setDiscount(cottageQuickReservationDetails.getDiscount());
		cottageQuickReservation.setStartDate(cottageQuickReservationDetails.getStartDate());
		cottageQuickReservation.setFinishDate(cottageQuickReservationDetails.getFinishDate());
		cottageQuickReservation.setMaxPeople(cottageQuickReservationDetails.getMaxPeople());
	
		final CottageQuickReservation updatedCottageQuickReservation = CottageQuickReservationRepository.save(cottageQuickReservation);
		return ResponseEntity.ok(updatedCottageQuickReservation);
	}
	
	@DeleteMapping("/cottageQuickReservations/{id}")
	public Map<String, Boolean> deleteCottageQuickReservation(int cottageQuickReservationId)
			throws ResourceNotFoundException {
		CottageQuickReservation  cottageQuickReservation = CottageQuickReservationRepository.findById(cottageQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageQuickReservation not found for this id :: " + cottageQuickReservationId));

		CottageQuickReservationRepository.delete(cottageQuickReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
