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
import com.isa.fishingbooker.model.BoatComplaint;
import com.isa.fishingbooker.service.BoatComplaintService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatComplaintController {

	@Autowired
	private BoatComplaintService boatComplaintService;

	@GetMapping("/boatComplaints")
	public List<BoatComplaint> getAllBoatComplaints() {
		return this.boatComplaintService.getAllBoatComplaints();
	}

	@GetMapping("/boatComplaints/{id}")
	public ResponseEntity<BoatComplaint> getBoatComplaintById(@PathVariable(value = "id") int boatComplaintId)
			throws ResourceNotFoundException {
		return boatComplaintService.getBoatComplaintById(boatComplaintId);
	}

	@PostMapping("/boatComplaints")
	public BoatComplaint createBoatComplaint(@RequestBody BoatComplaint boatComplaint) {
		return boatComplaintService.createBoatComplaint(boatComplaint);
	}

	@PutMapping("/boatComplaints/{id}")
	public ResponseEntity<BoatComplaint> updateBoatComplaint(@PathVariable(value = "id") int boatComplaintId,
			@RequestBody BoatComplaint boatComplaintDetails) throws ResourceNotFoundException {
		return boatComplaintService.updateBoatComplaint(boatComplaintId, boatComplaintDetails);
	}

	@DeleteMapping("/boatComplaints/{id}")
	public Map<String, Boolean> deleteBoatComplaint(@PathVariable(value = "id") int boatComplaintId)
			throws ResourceNotFoundException {
		return boatComplaintService.deleteBoatComplaint(boatComplaintId);
	}
}
