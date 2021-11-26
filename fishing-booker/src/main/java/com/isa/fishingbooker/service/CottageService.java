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
import com.isa.fishingbooker.model.Cottage;
import com.isa.fishingbooker.model.CottageReservation;
import com.isa.fishingbooker.repository.CottageRepository;

@Service
public class CottageService {

	@Autowired
	private CottageRepository CottageRepository;
	
	public List<Cottage> getAllCottages(){
		return this.CottageRepository.findAll();
	}
		
	public ResponseEntity<Cottage> getCottageById(int cottageId)
		throws ResourceNotFoundException{
		Cottage cottage = CottageRepository.findById(cottageId).orElseThrow(() -> new ResourceNotFoundException("Cottage not found for this id :: " + cottageId));
	 return ResponseEntity.ok().body(cottage);
	}
	
	@PostMapping("/cottages")
	public Cottage createCottage(Cottage cottage) {
		return CottageRepository.save(cottage);
	}
	
	
	@PutMapping("/cottage/{id}")
	public ResponseEntity<Cottage> updateCottage(Integer cottageId,
			 @RequestBody Cottage cottageDetails) throws ResourceNotFoundException {
		Cottage cottage = CottageRepository.findById(cottageId)
				.orElseThrow(() -> new ResourceNotFoundException("Cottage not found for this id :: " + cottageId));
		
		cottage.setName(cottageDetails.getName());
		cottage.setAddress(cottageDetails.getAddress());
		cottage.setPrice(cottageDetails.getPrice());
		cottage.setPromoDescription(cottageDetails.getPromoDescription());
		
		
	
		final Cottage updatedCottage = CottageRepository.save(cottage);
		return ResponseEntity.ok(updatedCottage);
	}
	
	@DeleteMapping("/cottages/{id}")
	public Map<String, Boolean> deleteCottage(int cottageId)
			throws ResourceNotFoundException {
		Cottage  cottage = CottageRepository.findById(cottageId)
				.orElseThrow(() -> new ResourceNotFoundException("Cottage not found for this id :: " + cottageId));

		CottageRepository.delete(cottage);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public List<Cottage> getCottagesByOwner(Integer cottageOwnerId) {
		return CottageRepository.getCottagesByOwner(cottageOwnerId);
	}
}
