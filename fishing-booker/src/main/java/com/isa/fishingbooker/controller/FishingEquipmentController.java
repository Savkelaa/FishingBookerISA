package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.FishingEquipment;
import com.isa.fishingbooker.service.FishingEquipmentService;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FishingEquipmentController {

	@Autowired
	private FishingEquipmentService fishingEquipmentService;

	@GetMapping("/fishingEquipment")
	public List<String> getFishingEquipmentByFishingClassReservation(@RequestParam (value="fishingClassReservationId")  Integer fishingClassReservationId) {
		return this.fishingEquipmentService.getFishingEquipmentByFishingClassReservation(fishingClassReservationId);
	}
	
	@GetMapping("/fishingEquipments")
	public List<FishingEquipment> getAllFishingEquipments() {
		return this.fishingEquipmentService.getAllFishingEquipments();
	}

	@GetMapping("/fishingEquipmentsFishingClass")
	public List<FishingEquipment> getAllFishingEquipmentsFishingClass() {
		return this.fishingEquipmentService.getAllFishingEquipmentsFishingClass();
	}
	
	@GetMapping("/fishingEquipmentsBoat")
	public List<FishingEquipment> getAllFishingEquipmentsBoat() {
		return this.fishingEquipmentService.getAllFishingEquipmentsBoat();
	}

	@GetMapping("/fishingEquipment/{id}")
	public ResponseEntity<FishingEquipment> getFishingEquipmentById(@PathVariable(value = "id") int fishingEquipmentId)
			throws ResourceNotFoundException {
		return fishingEquipmentService.getFishingEquipmentById(fishingEquipmentId);
	}




	@PostMapping("/fishingEquipment")
	public FishingEquipment createFishingEquipment(@RequestBody FishingEquipment fishingEquipment) {
		return fishingEquipmentService.createFishingEquipment(fishingEquipment);
	}

	@PutMapping("/fishingEquipment/{id}")
	public ResponseEntity<FishingEquipment> updateFishingEquipment(@PathVariable(value = "id") int fishingEquipmentId,
			@RequestBody FishingEquipment fishingEquipmentDetails) throws ResourceNotFoundException {
		return fishingEquipmentService.updateFishingEquipment(fishingEquipmentId, fishingEquipmentDetails);
	}

	@DeleteMapping("/fishingEquipment/{id}")
	public Map<String, Boolean> deleteFishingEquipment(@PathVariable(value = "id") int fishingEquipmentId)
			throws ResourceNotFoundException {
		return fishingEquipmentService.deleteFishingEquipment(fishingEquipmentId);
	}
}
