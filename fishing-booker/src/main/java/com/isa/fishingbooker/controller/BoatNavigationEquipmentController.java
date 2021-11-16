package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatNavigationEquipment;
import com.isa.fishingbooker.service.BoatNavigationEquipmentService;

@RestController
@RequestMapping("/api/v1")
public class BoatNavigationEquipmentController {

	@Autowired
	private BoatNavigationEquipmentService boatNavigationEquipmentService;

	@GetMapping("/boatNavigationEquipment")
	public List<BoatNavigationEquipment> getAllBoatNavigationEquipments() {
		return this.boatNavigationEquipmentService.getAllBoatNavigationEquipments();
	}

	@GetMapping("/boatNavigationEquipment/{id}")
	public ResponseEntity<BoatNavigationEquipment> getBoatNavigationEquipmentById(@PathVariable(value = "id") int boatNavigationEquipmentId)
			throws ResourceNotFoundException {
		return boatNavigationEquipmentService.getBoatNavigationEquipmentById(boatNavigationEquipmentId);
	}

	@PostMapping("/boatNavigationEquipment")
	public BoatNavigationEquipment createBoatNavigationEquipment(@RequestBody BoatNavigationEquipment boatNavigationEquipment) {
		return boatNavigationEquipmentService.createBoatNavigationEquipment(boatNavigationEquipment);
	}

	@PutMapping("/boatNavigationEquipment/{id}")
	public ResponseEntity<BoatNavigationEquipment> updateBoatNavigationEquipment(@PathVariable(value = "id") int boatNavigationEquipmentId,
			@RequestBody BoatNavigationEquipment boatNavigationEquipmentDetails) throws ResourceNotFoundException {
		return boatNavigationEquipmentService.updateBoatNavigationEquipment(boatNavigationEquipmentId, boatNavigationEquipmentDetails);
	}

	@DeleteMapping("/boatNavigationEquipment/{id}")
	public Map<String, Boolean> deleteBoatNavigationEquipment(@PathVariable(value = "id") int boatNavigationEquipmentId)
			throws ResourceNotFoundException {
		return boatNavigationEquipmentService.deleteBoatNavigationEquipment(boatNavigationEquipmentId);
	}
}
