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
import com.isa.fishingbooker.model.FishingClassReport;
import com.isa.fishingbooker.repository.FishingClassReportRepository;

@Service
public class FishingClassReportService {

	@Autowired
	private FishingClassReportRepository FishingClassReportRepository;
	
	public List<FishingClassReport> getAllFishingClassReports(){
		return this.FishingClassReportRepository.findAll();
	}
		
	public ResponseEntity<FishingClassReport> getFishingClassReportById(int fishingClassReportId)
		throws ResourceNotFoundException{
		FishingClassReport fishingClassReport = FishingClassReportRepository.findById(fishingClassReportId).orElseThrow(() -> new ResourceNotFoundException("FishingClassReport not found for this id :: " + fishingClassReportId));
	 return ResponseEntity.ok().body(fishingClassReport);
	}
	
	@PostMapping("/fishingClassReports")
	public FishingClassReport createFishingClassReport(FishingClassReport fishingClassReport) {
		return FishingClassReportRepository.save(fishingClassReport);
	}
	
	
	@PutMapping("/fishingClassReport/{id}")
	public ResponseEntity<FishingClassReport> updateFishingClassReport(Integer fishingClassReportId,
			 @RequestBody FishingClassReport fishingClassReportDetails) throws ResourceNotFoundException {
		FishingClassReport fishingClassReport = FishingClassReportRepository.findById(fishingClassReportId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassReport not found for this id :: " + fishingClassReportId));
		
		fishingClassReport.setDescription(fishingClassReportDetails.getDescription());
	
		final FishingClassReport updatedFishingClassReport = FishingClassReportRepository.save(fishingClassReport);
		return ResponseEntity.ok(updatedFishingClassReport);
	}
	
	@DeleteMapping("/fishingClassReports/{id}")
	public Map<String, Boolean> deleteFishingClassReport(int fishingClassReportId)
			throws ResourceNotFoundException {
		FishingClassReport  fishingClassReport = FishingClassReportRepository.findById(fishingClassReportId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClassReport not found for this id :: " + fishingClassReportId));

		FishingClassReportRepository.delete(fishingClassReport);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
