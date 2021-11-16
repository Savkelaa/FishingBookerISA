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
import com.isa.fishingbooker.model.FishingClassComplaint;
import com.isa.fishingbooker.repository.FishingClassComplaintRepository;

@Service
public class FishingClassComplaintService {

	@Autowired
	private FishingClassComplaintRepository FishingClassComplaintRepository;
	
	public List<FishingClassComplaint> getAllFishingClassComplaints(){
		return this.FishingClassComplaintRepository.findAll();
	}
		
	public ResponseEntity<FishingClassComplaint> getFishingClassComplaintById(int fishingClassComplaintId)
		throws ResourceNotFoundException{
		FishingClassComplaint fishingClassComplaint = FishingClassComplaintRepository.findById(fishingClassComplaintId).orElseThrow(() -> new ResourceNotFoundException("FishingClassComplaint not found for this id :: " + fishingClassComplaintId));
	 return ResponseEntity.ok().body(fishingClassComplaint);
	}
	
	@PostMapping("/fishingClassComplaints")
	public FishingClassComplaint createFishingClassComplaint(FishingClassComplaint fishingClassComplaint) {
		return FishingClassComplaintRepository.save(fishingClassComplaint);
	}
	
	
	@PutMapping("/fishingClassComplaint/{id}")
	public ResponseEntity<FishingClassComplaint> updateFishingClassComplaint(Integer fishingClassComplaintId,
			 @RequestBody FishingClassComplaint fishingClassComplaintDetails) throws ResourceNotFoundException {
		FishingClassComplaint fishingClassComplaint = FishingClassComplaintRepository.findById(fishingClassComplaintId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassComplaint not found for this id :: " + fishingClassComplaintId));
		
		fishingClassComplaint.setDescription(fishingClassComplaintDetails.getDescription());
	
		final FishingClassComplaint updatedFishingClassComplaint = FishingClassComplaintRepository.save(fishingClassComplaint);
		return ResponseEntity.ok(updatedFishingClassComplaint);
	}
	
	@DeleteMapping("/fishingClassComplaints/{id}")
	public Map<String, Boolean> deleteFishingClassComplaint(int fishingClassComplaintId)
			throws ResourceNotFoundException {
		FishingClassComplaint  fishingClassComplaint = FishingClassComplaintRepository.findById(fishingClassComplaintId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassComplaint not found for this id :: " + fishingClassComplaintId));

		FishingClassComplaintRepository.delete(fishingClassComplaint);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
