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
import com.isa.fishingbooker.model.CottageReservation;
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
	

	public CottageQuickReservation createCottageQuickReservation(CottageQuickReservation cottageQuickReservation) {
		return CottageQuickReservationRepository.save(cottageQuickReservation);
	}
	
	
	
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
	

	public Map<String, Boolean> deleteCottageQuickReservation(int cottageQuickReservationId)
			throws ResourceNotFoundException {
		CottageQuickReservation  cottageQuickReservation = CottageQuickReservationRepository.findById(cottageQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageQuickReservation not found for this id :: " + cottageQuickReservationId));

		CottageQuickReservationRepository.delete(cottageQuickReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public List<CottageQuickReservation> getAllCottageQuickReservationByClient(Integer clientId){
		return CottageQuickReservationRepository.getAllCottageQuickReservationByClient(clientId);
	}
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClient(Integer clientId){
		return CottageQuickReservationRepository.getAllFinishedCottageQuickReservationByClient(clientId);
	}
	
	public List<CottageQuickReservation> getAllCottageQuickReservationAtPresentByClient(Integer clientId){
		return CottageQuickReservationRepository.getAllCottageQuickReservationAtPresentByClient(clientId);
	}
	
	public List<CottageQuickReservation> getCottageQuickReservationsByOwner(Integer cottageOwnerId) {
		return CottageQuickReservationRepository.getCottageQuickReservationsByOwner(cottageOwnerId);
	}
	
	public List<CottageQuickReservation> getFinishedCottageQuickReservationsByOwner(Integer cottageOwnerId) {
		return CottageQuickReservationRepository.getFinishedCottageQuickReservationsByOwner(cottageOwnerId);
	}
	
	public List<CottageQuickReservation> getFreeCottageQuickReservationsByCottage(Integer cottageId) {
		return CottageQuickReservationRepository.getFreeCottageQuickReservationsByCottage(cottageId);
	}
	
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDateAsc(Integer clientId){
		return CottageQuickReservationRepository.getAllFinishedCottageQuickReservationByClientSortedByDateAsc(clientId);
	}
	
	
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDateDesc(Integer clientId){
		return CottageQuickReservationRepository.getAllFinishedCottageQuickReservationByClientSortedByDateDesc(clientId);
	}
	
	
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDurationAsc(Integer clientId){
		return CottageQuickReservationRepository.getAllFinishedCottageQuickReservationByClientSortedByDurationAsc(clientId);
	}
	
	
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDurationDesc(Integer clientId){
		return CottageQuickReservationRepository.getAllFinishedCottageQuickReservationByClientSortedByDurationDesc(clientId);
	}
}
