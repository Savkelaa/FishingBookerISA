package com.isa.fishingbooker.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.CottageQuickReservation;
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

	public List<CottageReservation> getCottageReservationsByCottageOwner(Integer cottageOwnerId)
	{
		return CottageReservationRepository.getCottageReservationsByCottageOwner(cottageOwnerId);
	}

	public CottageReservation createCottageReservation(CottageReservation cottageReservation) {
		return CottageReservationRepository.save(cottageReservation);
	}
	
	
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
	

	public Map<String, Boolean> deleteCottageReservation(int cottageReservationId)
			throws ResourceNotFoundException {
		CottageReservation  cottageReservation = CottageReservationRepository.findById(cottageReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageReservation not found for this id :: " + cottageReservationId));

		CottageReservationRepository.delete(cottageReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public List<CottageReservation> getAllCottageReservationByClient(Integer clientId){
		return CottageReservationRepository.getAllCottageReservationByClient(clientId);
	}
	
	public List<CottageReservation> getAllFinishedCottageReservationByClient(Integer clientId){
		return CottageReservationRepository.getAllFinishedCottageReservationByClient(clientId);
	}
	
	public List<CottageReservation> getAllCottageReservationAtPresentByClient(Integer clientId){
		return CottageReservationRepository.getAllCottageReservationAtPresentByClient(clientId);
	}
	
	public List<CottageReservation> getCottageReservationsByOwner(Integer cottageOwnerId) {
		return CottageReservationRepository.getCottageReservationsByOwner(cottageOwnerId);
	}
	
	public List<CottageReservation> getFinishedCottageReservationsByOwner(Integer cottageOwnerId) {
		return CottageReservationRepository.getFinishedCottageReservationsByOwner(cottageOwnerId);
	}
	public List<CottageReservation> getAllFinishedCottageReservationByClientSortedByDateAsc(Integer clientId){
		return CottageReservationRepository.getAllFinishedCottageReservationByClientSortedByDateAsc(clientId);
	}
	
	
	public List<CottageReservation> getAllFinishedCottageReservationByClientSortedByDateDesc(Integer clientId){
		return CottageReservationRepository.getAllFinishedCottageReservationByClientSortedByDateDesc(clientId);
	}
	
	
	public List<CottageReservation> getAllFinishedCottageReservationByClientSortedByDurationAsc(Integer clientId){
		return CottageReservationRepository.getAllFinishedCottageReservationByClientSortedByDurationAsc(clientId);
	}
	
	
	public List<CottageReservation> getAllFinishedCottageReservationByClientSortedByDurationDesc(Integer clientId){
		return CottageReservationRepository.getAllFinishedCottageReservationByClientSortedByDurationDesc(clientId);
	}
}
