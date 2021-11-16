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
import com.isa.fishingbooker.model.Boat;
import com.isa.fishingbooker.repository.BoatRepository;

@Service
public class BoatService {

	@Autowired
	private BoatRepository BoatRepository;
	
	public List<Boat> getAllBoats(){
		return this.BoatRepository.findAll();
	}
		
	public ResponseEntity<Boat> getBoatById(int boatId)
		throws ResourceNotFoundException{
		Boat boat = BoatRepository.findById(boatId).orElseThrow(() -> new ResourceNotFoundException("Boat not found for this id :: " + boatId));
	 return ResponseEntity.ok().body(boat);
	}
	
	@PostMapping("/boats")
	public Boat createBoat(Boat boat) {
		return BoatRepository.save(boat);
	}
	
	
	@PutMapping("/boat/{id}")
	public ResponseEntity<Boat> updateBoat(Integer boatId,
			 @RequestBody Boat boatDetails) throws ResourceNotFoundException {
		Boat boat = BoatRepository.findById(boatId)
				.orElseThrow(() -> new ResourceNotFoundException("Boat not found for this id :: " + boatId));
		
		boat.setName(boatDetails.getName());
		boat.setAddress(boatDetails.getAddress());
		boat.setCapacity(boatDetails.getCapacity());
		boat.setLength(boatDetails.getLength());
		boat.setMaxSpeed(boatDetails.getMaxSpeed());
		boat.setMotorPower(boatDetails.getMotorPower());
		boat.setNum_motors(boatDetails.getNum_motors());
		boat.setPrice(boatDetails.getPrice());
		boat.setPromoDescription(boatDetails.getPromoDescription());
		boat.setStatus(boatDetails.getStatus());
		boat.setType(boatDetails.getType());
		boat.setCancellationCondition(boatDetails.getCancellationCondition());
		
		final Boat updatedBoat = BoatRepository.save(boat);
		return ResponseEntity.ok(updatedBoat);
	}
	
	@DeleteMapping("/boats/{id}")
	public Map<String, Boolean> deleteBoat(int boatId)
			throws ResourceNotFoundException {
		Boat  boat = BoatRepository.findById(boatId)
				.orElseThrow(() -> new ResourceNotFoundException("Boat not found for this id :: " + boatId));

		BoatRepository.delete(boat);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
