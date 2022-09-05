package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.repository.FishingClassRateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
	private InstructorRateRepository InstructorRateRepository;
	
	public List<InstructorRate> getAllInstructorRates(){
		return this.InstructorRateRepository.findAll();
	}

	public List<InstructorRate> getAllInstructorRateRequests(){
		return this.InstructorRateRepository.getAllInstructorRateRequests();
	}
		
	public ResponseEntity<InstructorRate> getInstructorRateById(int instructorRateId)
		throws ResourceNotFoundException{
		InstructorRate instructorRate = InstructorRateRepository.findById(instructorRateId).orElseThrow(() -> new ResourceNotFoundException("InstructorRate not found for this id :: " + instructorRateId));
	 return ResponseEntity.ok().body(instructorRate);
	}
	

	public InstructorRate createInstructorRate(InstructorRate instructorRate) {
		return InstructorRateRepository.save(instructorRate);
	}
	
	public Double getCottageAvgRate( Integer cottageId){
		return this.InstructorRateRepository.getInstructorAvgRate(cottageId);
	}
		
	
	public ResponseEntity<InstructorRate> updateInstructorRate(Integer instructorRateId,
			 @RequestBody InstructorRate instructorRateDetails) throws ResourceNotFoundException {
		InstructorRate instructorRate = InstructorRateRepository.findById(instructorRateId)
				.orElseThrow(() -> new ResourceNotFoundException("InstructorRate not found for this id :: " + instructorRateId));

		instructorRate.setAccepted(instructorRateDetails.getAccepted());
		instructorRate.setRequest(instructorRateDetails.getRequest());
		instructorRate.setRate(instructorRateDetails.getRate());
		instructorRate.setClient(instructorRateDetails.getClient());
		instructorRate.setInstructor(instructorRateDetails.getInstructor());

		if(instructorRate.getAccepted().toString().equals("true")) {
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionAsyncAcceptRate(instructorRate.getClient());
			} catch (Exception e) {
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
		}

		final InstructorRate updatedInstructorRate = InstructorRateRepository.save(instructorRate);
		return ResponseEntity.ok(updatedInstructorRate);
	}
	
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
