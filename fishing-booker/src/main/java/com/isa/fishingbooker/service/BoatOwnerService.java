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
import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.repository.BoatOwnerRepository;

@Service
public class BoatOwnerService {

	@Autowired
	private BoatOwnerRepository BoatOwnerRepository;
	
	public List<BoatOwner> getAllBoatOwners(){
		return this.BoatOwnerRepository.findAll();
	}
		
	public ResponseEntity<BoatOwner> getBoatOwnerById(int boatOwnerId)
		throws ResourceNotFoundException{
		BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId).orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));
	 return ResponseEntity.ok().body(boatOwner);
	}
	
	@PostMapping("/boatOwners")
	public BoatOwner createBoatOwner(BoatOwner boatOwner) {
		return BoatOwnerRepository.save(boatOwner);
	}
	
	
	@PutMapping("/boatOwner/{id}")
	public ResponseEntity<BoatOwner> updateBoatOwner(Integer boatOwnerId,
			 @RequestBody BoatOwner boatOwnerDetails) throws ResourceNotFoundException {
		BoatOwner boatOwner = BoatOwnerRepository.findById(boatOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));
		
		boatOwner.setAddress(boatOwnerDetails.getAddress());
		boatOwner.setCity(boatOwnerDetails.getCity());
		boatOwner.setCountry(boatOwnerDetails.getCountry());
		boatOwner.setEmail(boatOwnerDetails.getEmail());
		boatOwner.setExplanation(boatOwnerDetails.getExplanation());
		boatOwner.setName(boatOwnerDetails.getName());
		boatOwner.setNumber(boatOwnerDetails.getNumber());
		boatOwner.setPassword(boatOwnerDetails.getPassword());
		boatOwner.setSurname(boatOwnerDetails.getSurname());
		boatOwner.setBiography(boatOwnerDetails.getBiography());
		
		final BoatOwner updatedBoatOwner = BoatOwnerRepository.save(boatOwner);
		return ResponseEntity.ok(updatedBoatOwner);
	}
	
	@DeleteMapping("/boatOwners/{id}")
	public Map<String, Boolean> deleteBoatOwner(int boatOwnerId)
			throws ResourceNotFoundException {
		BoatOwner  boatOwner = BoatOwnerRepository.findById(boatOwnerId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatOwner not found for this id :: " + boatOwnerId));

		BoatOwnerRepository.delete(boatOwner);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public BoatOwner getBoatOwnerByEmailAndPassword(String email, String password) {
		return BoatOwnerRepository.getBoatOwnerByEmailAndPassword(email, password);
	}
}
