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
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.FishingClassComplaint;
import com.isa.fishingbooker.service.FishingClassComplaintService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FishingClassComplaintController {

	@Autowired
	private FishingClassComplaintService fishingClassComplaintService;

	@GetMapping("/fishingClassComplaints")
	public List<FishingClassComplaint> getAllFishingClassComplaints() {
		return this.fishingClassComplaintService.getAllFishingClassComplaints();
	}

	@GetMapping("/fishingClassComplaints/{id}")
	public ResponseEntity<FishingClassComplaint> getFishingClassComplaintById(@PathVariable(value = "id") int fishingClassComplaintId)
			throws ResourceNotFoundException {
		return fishingClassComplaintService.getFishingClassComplaintById(fishingClassComplaintId);
	}

	@PostMapping("/fishingClassComplaints")
	public FishingClassComplaint createFishingClassComplaint(@RequestBody FishingClassComplaint fishingClassComplaint) {
		return fishingClassComplaintService.createFishingClassComplaint(fishingClassComplaint);
	}

	@PutMapping("/fishingClassComplaints/{id}")
	public ResponseEntity<FishingClassComplaint> updateFishingClassComplaint(@PathVariable(value = "id") int fishingClassComplaintId,
			@RequestBody FishingClassComplaint fishingClassComplaintDetails) throws ResourceNotFoundException {
		return fishingClassComplaintService.updateFishingClassComplaint(fishingClassComplaintId, fishingClassComplaintDetails);
	}

	@DeleteMapping("/fishingClassComplaints/{id}")
	public Map<String, Boolean> deleteFishingClassComplaint(@PathVariable(value = "id") int fishingClassComplaintId)
			throws ResourceNotFoundException {
		return fishingClassComplaintService.deleteFishingClassComplaint(fishingClassComplaintId);
	}
}
