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
import com.isa.fishingbooker.model.FishingEquipment;
import com.isa.fishingbooker.repository.FishingEquipmentRepository;

@Service
public class FishingEquipmentService {

	@Autowired
	private FishingEquipmentRepository FishingEquipmentRepository;
	
	public List<String> getFishingEquipmentByFishingClassReservation(Integer fishingClassReservationId)
	{
		return FishingEquipmentRepository.getFishingEquipmentByFishingClassReservation(fishingClassReservationId);
	}
	
	
	public List<FishingEquipment> getAllFishingEquipments(){
		return this.FishingEquipmentRepository.findAll();
	}
		
	public ResponseEntity<FishingEquipment> getFishingEquipmentById(int fishingEquipmentId)
		throws ResourceNotFoundException{
		FishingEquipment fishingEquipment = FishingEquipmentRepository.findById(fishingEquipmentId).orElseThrow(() -> new ResourceNotFoundException("FishingEquipment not found for this id :: " + fishingEquipmentId));
	 return ResponseEntity.ok().body(fishingEquipment);
	}
	
	@PostMapping("/fishingEquipment")
	public FishingEquipment createFishingEquipment(FishingEquipment fishingEquipment) {
		return FishingEquipmentRepository.save(fishingEquipment);
	}
	
	
	@PutMapping("/fishingEquipment/{id}")
	public ResponseEntity<FishingEquipment> updateFishingEquipment(Integer fishingEquipmentId,
			 @RequestBody FishingEquipment fishingEquipmentDetails) throws ResourceNotFoundException {
		FishingEquipment fishingEquipment = FishingEquipmentRepository.findById(fishingEquipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingEquipment not found for this id :: " + fishingEquipmentId));
		
		fishingEquipment.setName(fishingEquipmentDetails.getName());
		fishingEquipment.setDescription(fishingEquipmentDetails.getDescription());
	
		final FishingEquipment updatedFishingEquipment = FishingEquipmentRepository.save(fishingEquipment);
		return ResponseEntity.ok(updatedFishingEquipment);
	}
	
	@DeleteMapping("/fishingEquipment/{id}")
	public Map<String, Boolean> deleteFishingEquipment(int fishingEquipmentId)
			throws ResourceNotFoundException {
		FishingEquipment  fishingEquipment = FishingEquipmentRepository.findById(fishingEquipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingEquipment not found for this id :: " + fishingEquipmentId));

		FishingEquipmentRepository.delete(fishingEquipment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
