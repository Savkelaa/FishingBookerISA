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
import com.isa.fishingbooker.model.CottageReport;
import com.isa.fishingbooker.repository.CottageReportRepository;

@Service
public class CottageReportService {

	@Autowired
	private CottageReportRepository CottageReportRepository;
	
	public List<CottageReport> getAllCottageReports(){
		return this.CottageReportRepository.findAll();
	}
		
	public ResponseEntity<CottageReport> getCottageReportById(int cottageReportId)
		throws ResourceNotFoundException{
		CottageReport cottageReport = CottageReportRepository.findById(cottageReportId).orElseThrow(() -> new ResourceNotFoundException("CottageReport not found for this id :: " + cottageReportId));
	 return ResponseEntity.ok().body(cottageReport);
	}
	
	@PostMapping("/cottageReports")
	public CottageReport createCottageReport(CottageReport cottageReport) {
		return CottageReportRepository.save(cottageReport);
	}
	
	
	@PutMapping("/cottageReport/{id}")
	public ResponseEntity<CottageReport> updateCottageReport(Integer cottageReportId,
			 @RequestBody CottageReport cottageReportDetails) throws ResourceNotFoundException {
		CottageReport cottageReport = CottageReportRepository.findById(cottageReportId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageReport not found for this id :: " + cottageReportId));
		
		cottageReport.setDescription(cottageReportDetails.getDescription());
	
		final CottageReport updatedCottageReport = CottageReportRepository.save(cottageReport);
		return ResponseEntity.ok(updatedCottageReport);
	}
	
	@DeleteMapping("/cottageReports/{id}")
	public Map<String, Boolean> deleteCottageReport(int cottageReportId)
			throws ResourceNotFoundException {
		CottageReport  cottageReport = CottageReportRepository.findById(cottageReportId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageReport not found for this id :: " + cottageReportId));

		CottageReportRepository.delete(cottageReport);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
