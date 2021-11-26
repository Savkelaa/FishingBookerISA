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
import com.isa.fishingbooker.model.BoatNavigationEquipment;
import com.isa.fishingbooker.repository.BoatNavigationEquipmentRepository;

@Service
public class BoatNavigationEquipmentService {

	@Autowired
	private BoatNavigationEquipmentRepository BoatNavigationEquipmentRepository;
	
	public List<BoatNavigationEquipment> getAllBoatNavigationEquipments(){
		return this.BoatNavigationEquipmentRepository.findAll();
	}
		
	public ResponseEntity<BoatNavigationEquipment> getBoatNavigationEquipmentById(int boatNavigationEquipmentId)
		throws ResourceNotFoundException{
		BoatNavigationEquipment boatNavigationEquipment = BoatNavigationEquipmentRepository.findById(boatNavigationEquipmentId).orElseThrow(() -> new ResourceNotFoundException("BoatNavigationEquipment not found for this id :: " + boatNavigationEquipmentId));
	 return ResponseEntity.ok().body(boatNavigationEquipment);
	}
	
	
	public BoatNavigationEquipment createBoatNavigationEquipment(BoatNavigationEquipment boatNavigationEquipment) {
		return BoatNavigationEquipmentRepository.save(boatNavigationEquipment);
	}
	
	
	
	public ResponseEntity<BoatNavigationEquipment> updateBoatNavigationEquipment(Integer boatNavigationEquipmentId,
			 @RequestBody BoatNavigationEquipment boatNavigationEquipmentDetails) throws ResourceNotFoundException {
		BoatNavigationEquipment boatNavigationEquipment = BoatNavigationEquipmentRepository.findById(boatNavigationEquipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatNavigationEquipment not found for this id :: " + boatNavigationEquipmentId));
		
		boatNavigationEquipment.setName(boatNavigationEquipmentDetails.getName());
		boatNavigationEquipment.setDescription(boatNavigationEquipmentDetails.getDescription());
		
		final BoatNavigationEquipment updatedBoatNavigationEquipment = BoatNavigationEquipmentRepository.save(boatNavigationEquipment);
		return ResponseEntity.ok(updatedBoatNavigationEquipment);
	}
	
	
	public Map<String, Boolean> deleteBoatNavigationEquipment(int boatNavigationEquipmentId)
			throws ResourceNotFoundException {
		BoatNavigationEquipment  boatNavigationEquipment = BoatNavigationEquipmentRepository.findById(boatNavigationEquipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatNavigationEquipment not found for this id :: " + boatNavigationEquipmentId));

		BoatNavigationEquipmentRepository.delete(boatNavigationEquipment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
