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
import com.isa.fishingbooker.model.InstructorRate;
import com.isa.fishingbooker.repository.InstructorRateRepository;

@Service
public class InstructorRateService {

	@Autowired
	private InstructorRateRepository InstructorRateRepository;
	
	public List<InstructorRate> getAllInstructorRates(){
		return this.InstructorRateRepository.findAll();
	}
		
	public ResponseEntity<InstructorRate> getInstructorRateById(int instructorRateId)
		throws ResourceNotFoundException{
		InstructorRate instructorRate = InstructorRateRepository.findById(instructorRateId).orElseThrow(() -> new ResourceNotFoundException("InstructorRate not found for this id :: " + instructorRateId));
	 return ResponseEntity.ok().body(instructorRate);
	}
	
	@PostMapping("/instructorRates")
	public InstructorRate createInstructorRate(InstructorRate instructorRate) {
		return InstructorRateRepository.save(instructorRate);
	}
	
	
	@PutMapping("/instructorRate/{id}")
	public ResponseEntity<InstructorRate> updateInstructorRate(Integer instructorRateId,
			 @RequestBody InstructorRate instructorRateDetails) throws ResourceNotFoundException {
		InstructorRate instructorRate = InstructorRateRepository.findById(instructorRateId)
				.orElseThrow(() -> new ResourceNotFoundException("InstructorRate not found for this id :: " + instructorRateId));
		
		instructorRate.setRate(instructorRateDetails.getRate());
	
		final InstructorRate updatedInstructorRate = InstructorRateRepository.save(instructorRate);
		return ResponseEntity.ok(updatedInstructorRate);
	}
	
	@DeleteMapping("/instructorRates/{id}")
	public Map<String, Boolean> deleteInstructorRate(int instructorRateId)
			throws ResourceNotFoundException {
		InstructorRate  instructorRate = InstructorRateRepository.findById(instructorRateId)
				.orElseThrow(() -> new ResourceNotFoundException("InstructorRate not found for this id :: " + instructorRateId));

		InstructorRateRepository.delete(instructorRate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}