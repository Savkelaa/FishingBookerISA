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
import com.isa.fishingbooker.model.FishingClass;
import com.isa.fishingbooker.service.FishingClassService;

@RestController
@RequestMapping("/api/v1")
public class FishingClassController {

	@Autowired
	private FishingClassService fishingClassService;

	@GetMapping("/fishingClass")
	public List<FishingClass> getAllFishingClasss() {
		return this.fishingClassService.getAllFishingClasss();
	}

	@GetMapping("/fishingClass/{id}")
	public ResponseEntity<FishingClass> getFishingClassById(@PathVariable(value = "id") int fishingClassId)
			throws ResourceNotFoundException {
		return fishingClassService.getFishingClassById(fishingClassId);
	}

	@PostMapping("/fishingClass")
	public FishingClass createFishingClass(@RequestBody FishingClass fishingClass) {
		return fishingClassService.createFishingClass(fishingClass);
	}

	@PutMapping("/fishingClass/{id}")
	public ResponseEntity<FishingClass> updateFishingClass(@PathVariable(value = "id") int fishingClassId,
			@RequestBody FishingClass fishingClassDetails) throws ResourceNotFoundException {
		return fishingClassService.updateFishingClass(fishingClassId, fishingClassDetails);
	}

	@DeleteMapping("/fishingClass/{id}")
	public Map<String, Boolean> deleteFishingClass(@PathVariable(value = "id") int fishingClassId)
			throws ResourceNotFoundException {
		return fishingClassService.deleteFishingClass(fishingClassId);
	}
}
