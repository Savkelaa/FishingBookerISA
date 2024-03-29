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
import com.isa.fishingbooker.model.InstructorRate;
import com.isa.fishingbooker.repository.InstructorRateRepository;
import com.isa.fishingbooker.service.InstructorRateService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class InstructorRateController {

	@Autowired
	private InstructorRateService instructorRateService;
	private InstructorRateRepository instructorRepository;

	@GetMapping("/instructorRates")
	public List<InstructorRate> getAllInstructorRates() {
		return this.instructorRateService.getAllInstructorRates();
	}

	@GetMapping("/instructorRateRequests")
	public List<InstructorRate> getAllInstructorRateRequests() {
		return this.instructorRateService.getAllInstructorRateRequests();
	}

	@GetMapping("/instructorRates/{id}")
	public ResponseEntity<InstructorRate> getInstructorRateById(@PathVariable(value = "id") int instructorRateId)
			throws ResourceNotFoundException {
		return instructorRateService.getInstructorRateById(instructorRateId);
	}

	@GetMapping("/instructorAvgRate")
	public Double getCottageAvgRate(@RequestParam(value="cottageId")  Integer cottageId)
	{
		return instructorRateService.getCottageAvgRate(cottageId);
	}


	@PostMapping("/instructorRates")
	public InstructorRate createInstructorRate(@RequestBody InstructorRate instructorRate) {
		return instructorRateService.createInstructorRate(instructorRate);
	}

	@PutMapping("/instructorRates/{id}")
	public ResponseEntity<InstructorRate> updateInstructorRate(@PathVariable(value = "id") int instructorRateId,
			@RequestBody InstructorRate instructorRateDetails) throws ResourceNotFoundException {
		return instructorRateService.updateInstructorRate(instructorRateId, instructorRateDetails);
	}

	@DeleteMapping("/instructorRates/{id}")
	public Map<String, Boolean> deleteInstructorRate(@PathVariable(value = "id") int instructorRateId)
			throws ResourceNotFoundException {
		return instructorRateService.deleteInstructorRate(instructorRateId);
	}
}
