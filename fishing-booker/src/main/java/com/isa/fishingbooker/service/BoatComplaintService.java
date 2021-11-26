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
import com.isa.fishingbooker.model.BoatComplaint;
import com.isa.fishingbooker.repository.BoatComplaintRepository;

@Service
public class BoatComplaintService {

	@Autowired
	private BoatComplaintRepository BoatComplaintRepository;
	
	public List<BoatComplaint> getAllBoatComplaints(){
		return this.BoatComplaintRepository.findAll();
	}
		
	public ResponseEntity<BoatComplaint> getBoatComplaintById(int boatComplaintId)
		throws ResourceNotFoundException{
		BoatComplaint boatComplaint = BoatComplaintRepository.findById(boatComplaintId).orElseThrow(() -> new ResourceNotFoundException("BoatComplaint not found for this id :: " + boatComplaintId));
	 return ResponseEntity.ok().body(boatComplaint);
	}
	
	
	public BoatComplaint createBoatComplaint(BoatComplaint boatComplaint) {
		return BoatComplaintRepository.save(boatComplaint);
	}
	
	
	
	public ResponseEntity<BoatComplaint> updateBoatComplaint(Integer boatComplaintId,
			 @RequestBody BoatComplaint boatComplaintDetails) throws ResourceNotFoundException {
		BoatComplaint boatComplaint = BoatComplaintRepository.findById(boatComplaintId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatComplaint not found for this id :: " + boatComplaintId));
		
		boatComplaint.setDescription(boatComplaintDetails.getDescription());
		
		final BoatComplaint updatedBoatComplaint = BoatComplaintRepository.save(boatComplaint);
		return ResponseEntity.ok(updatedBoatComplaint);
	}
	

	public Map<String, Boolean> deleteBoatComplaint(int boatComplaintId)
			throws ResourceNotFoundException {
		BoatComplaint  boatComplaint = BoatComplaintRepository.findById(boatComplaintId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatComplaint not found for this id :: " + boatComplaintId));

		BoatComplaintRepository.delete(boatComplaint);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
