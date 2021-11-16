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
import com.isa.fishingbooker.model.BoatReport;
import com.isa.fishingbooker.repository.BoatReportRepository;

@Service
public class BoatReportService {

	@Autowired
	private BoatReportRepository BoatReportRepository;
	
	public List<BoatReport> getAllBoatReports(){
		return this.BoatReportRepository.findAll();
	}
		
	public ResponseEntity<BoatReport> getBoatReportById(int boatReportId)
		throws ResourceNotFoundException{
		BoatReport boatReport = BoatReportRepository.findById(boatReportId).orElseThrow(() -> new ResourceNotFoundException("BoatReport not found for this id :: " + boatReportId));
	 return ResponseEntity.ok().body(boatReport);
	}
	
	@PostMapping("/boatReports")
	public BoatReport createBoatReport(BoatReport boatReport) {
		return BoatReportRepository.save(boatReport);
	}
	
	
	@PutMapping("/boatReport/{id}")
	public ResponseEntity<BoatReport> updateBoatReport(Integer boatReportId,
			 @RequestBody BoatReport boatReportDetails) throws ResourceNotFoundException {
		BoatReport boatReport = BoatReportRepository.findById(boatReportId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatReport not found for this id :: " + boatReportId));
	
		boatReport.setDescription(boatReportDetails.getDescription());
		
		final BoatReport updatedBoatReport = BoatReportRepository.save(boatReport);
		return ResponseEntity.ok(updatedBoatReport);
	}
	
	@DeleteMapping("/boatReports/{id}")
	public Map<String, Boolean> deleteBoatReport(int boatReportId)
			throws ResourceNotFoundException {
		BoatReport  boatReport = BoatReportRepository.findById(boatReportId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatReport not found for this id :: " + boatReportId));

		BoatReportRepository.delete(boatReport);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
