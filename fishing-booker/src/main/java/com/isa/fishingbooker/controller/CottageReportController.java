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
import com.isa.fishingbooker.model.CottageReport;
import com.isa.fishingbooker.service.CottageReportService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageReportController {

	@Autowired
	private CottageReportService cottageReportService;

	@GetMapping("/cottageReports")
	public List<CottageReport> getAllCottageReports() {
		return this.cottageReportService.getAllCottageReports();
	}

	@GetMapping("/cottageReports/{id}")
	public ResponseEntity<CottageReport> getCottageReportById(@PathVariable(value = "id") int cottageReportId)
			throws ResourceNotFoundException {
		return cottageReportService.getCottageReportById(cottageReportId);
	}

	@PostMapping("/cottageReports")
	public CottageReport createCottageReport(@RequestBody CottageReport cottageReport) {
		return cottageReportService.createCottageReport(cottageReport);
	}

	@PutMapping("/cottageReports/{id}")
	public ResponseEntity<CottageReport> updateCottageReport(@PathVariable(value = "id") int cottageReportId,
			@RequestBody CottageReport cottageReportDetails) throws ResourceNotFoundException {
		return cottageReportService.updateCottageReport(cottageReportId, cottageReportDetails);
	}

	@DeleteMapping("/cottageReports/{id}")
	public Map<String, Boolean> deleteCottageReport(@PathVariable(value = "id") int cottageReportId)
			throws ResourceNotFoundException {
		return cottageReportService.deleteCottageReport(cottageReportId);
	}
}
