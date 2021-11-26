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
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.CottageOwner;
import com.isa.fishingbooker.repository.CottageOwnerRepository;

@Service
public class CottageOwnerService {

	@Autowired
	private CottageOwnerRepository CottageOwnerRepository;
	
	public List<CottageOwner> getAllCottageOwners(){
		return this.CottageOwnerRepository.findAll();
	}
		
	public ResponseEntity<CottageOwner> getCottageOwnerById(int cottageOwnerId)
		throws ResourceNotFoundException{
		CottageOwner cottageOwner = CottageOwnerRepository.findById(cottageOwnerId).orElseThrow(() -> new ResourceNotFoundException("CottageOwner not found for this id :: " + cottageOwnerId));
	 return ResponseEntity.ok().body(cottageOwner);
	}
	
	@PostMapping("/cottageOwners")
	public CottageOwner createCottageOwner(CottageOwner cottageOwner) {
		return CottageOwnerRepository.save(cottageOwner);
	}
	
	
	@PutMapping("/cottageOwner/{id}")
	public ResponseEntity<CottageOwner> updateCottageOwner(Integer cottageOwnerId,
			 @RequestBody CottageOwner cottageOwnerDetails) throws ResourceNotFoundException {
		CottageOwner cottageOwner = CottageOwnerRepository.findById(cottageOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwner not found for this id :: " + cottageOwnerId));
		
		cottageOwner.setAddress(cottageOwnerDetails.getAddress());
		cottageOwner.setCity(cottageOwnerDetails.getCity());
		cottageOwner.setCountry(cottageOwnerDetails.getCountry());
		cottageOwner.setEmail(cottageOwnerDetails.getEmail());
		cottageOwner.setExplanation(cottageOwnerDetails.getExplanation());
		cottageOwner.setName(cottageOwnerDetails.getName());
		cottageOwner.setNumber(cottageOwnerDetails.getNumber());
		cottageOwner.setPassword(cottageOwnerDetails.getPassword());
		cottageOwner.setSurname(cottageOwnerDetails.getSurname());
		
		final CottageOwner updatedCottageOwner = CottageOwnerRepository.save(cottageOwner);
		return ResponseEntity.ok(updatedCottageOwner);
	}
	
	@DeleteMapping("/cottageOwners/{id}")
	public Map<String, Boolean> deleteCottageOwner(int cottageOwnerId)
			throws ResourceNotFoundException {
		CottageOwner  cottageOwner = CottageOwnerRepository.findById(cottageOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageOwner not found for this id :: " + cottageOwnerId));

		CottageOwnerRepository.delete(cottageOwner);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public CottageOwner getCottageOwnerByEmailAndPassword(String email, String password) {
		return CottageOwnerRepository.getCottageOwnerByEmailAndPassword(email, password);
	}
}
