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
import com.isa.fishingbooker.model.CottageComplaint;
import com.isa.fishingbooker.service.CottageComplaintService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageComplaintController {

	@Autowired
	private CottageComplaintService cottageComplaintService;

	@GetMapping("/cottageComplaints")
	public List<CottageComplaint> getAllCottageComplaints() {
		return this.cottageComplaintService.getAllCottageComplaints();
	}

	@GetMapping("/cottageComplaints/{id}")
	public ResponseEntity<CottageComplaint> getCottageComplaintById(@PathVariable(value = "id") int cottageComplaintId)
			throws ResourceNotFoundException {
		return cottageComplaintService.getCottageComplaintById(cottageComplaintId);
	}

	@PostMapping("/cottageComplaints")
	public CottageComplaint createCottageComplaint(@RequestBody CottageComplaint cottageComplaint) {
		return cottageComplaintService.createCottageComplaint(cottageComplaint);
	}

	@PutMapping("/cottageComplaints/{id}")
	public ResponseEntity<CottageComplaint> updateCottageComplaint(@PathVariable(value = "id") int cottageComplaintId,
			@RequestBody CottageComplaint cottageComplaintDetails) throws ResourceNotFoundException {
		return cottageComplaintService.updateCottageComplaint(cottageComplaintId, cottageComplaintDetails);
	}

	@DeleteMapping("/cottageComplaints/{id}")
	public Map<String, Boolean> deleteCottageComplaint(@PathVariable(value = "id") int cottageComplaintId)
			throws ResourceNotFoundException {
		return cottageComplaintService.deleteCottageComplaint(cottageComplaintId);
	}
}
