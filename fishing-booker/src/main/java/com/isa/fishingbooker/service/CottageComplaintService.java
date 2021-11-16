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
import com.isa.fishingbooker.model.CottageComplaint;
import com.isa.fishingbooker.repository.CottageComplaintRepository;

@Service
public class CottageComplaintService {

	@Autowired
	private CottageComplaintRepository CottageComplaintRepository;
	
	public List<CottageComplaint> getAllCottageComplaints(){
		return this.CottageComplaintRepository.findAll();
	}
		
	public ResponseEntity<CottageComplaint> getCottageComplaintById(int cottageComplaintId)
		throws ResourceNotFoundException{
		CottageComplaint cottageComplaint = CottageComplaintRepository.findById(cottageComplaintId).orElseThrow(() -> new ResourceNotFoundException("CottageComplaint not found for this id :: " + cottageComplaintId));
	 return ResponseEntity.ok().body(cottageComplaint);
	}
	
	@PostMapping("/cottageComplaints")
	public CottageComplaint createCottageComplaint(CottageComplaint cottageComplaint) {
		return CottageComplaintRepository.save(cottageComplaint);
	}
	
	
	@PutMapping("/cottageComplaint/{id}")
	public ResponseEntity<CottageComplaint> updateCottageComplaint(Integer cottageComplaintId,
			 @RequestBody CottageComplaint cottageComplaintDetails) throws ResourceNotFoundException {
		CottageComplaint cottageComplaint = CottageComplaintRepository.findById(cottageComplaintId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageComplaint not found for this id :: " + cottageComplaintId));
		
		cottageComplaint.setDescription(cottageComplaintDetails.getDescription());
	
		final CottageComplaint updatedCottageComplaint = CottageComplaintRepository.save(cottageComplaint);
		return ResponseEntity.ok(updatedCottageComplaint);
	}
	
	@DeleteMapping("/cottageComplaints/{id}")
	public Map<String, Boolean> deleteCottageComplaint(int cottageComplaintId)
			throws ResourceNotFoundException {
		CottageComplaint  cottageComplaint = CottageComplaintRepository.findById(cottageComplaintId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageComplaint not found for this id :: " + cottageComplaintId));

		CottageComplaintRepository.delete(cottageComplaint);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
