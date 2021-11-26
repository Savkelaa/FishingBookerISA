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
import com.isa.fishingbooker.model.FishingClassReport;
import com.isa.fishingbooker.service.FishingClassReportService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FishingClassReportController {

	@Autowired
	private FishingClassReportService fishingClassReportService;

	@GetMapping("/fishingClassReports")
	public List<FishingClassReport> getAllFishingClassReports() {
		return this.fishingClassReportService.getAllFishingClassReports();
	}

	@GetMapping("/fishingClassReports/{id}")
	public ResponseEntity<FishingClassReport> getFishingClassReportById(@PathVariable(value = "id") int fishingClassReportId)
			throws ResourceNotFoundException {
		return fishingClassReportService.getFishingClassReportById(fishingClassReportId);
	}

	@PostMapping("/fishingClassReports")
	public FishingClassReport createFishingClassReport(@RequestBody FishingClassReport fishingClassReport) {
		return fishingClassReportService.createFishingClassReport(fishingClassReport);
	}

	@PutMapping("/fishingClassReports/{id}")
	public ResponseEntity<FishingClassReport> updateFishingClassReport(@PathVariable(value = "id") int fishingClassReportId,
			@RequestBody FishingClassReport fishingClassReportDetails) throws ResourceNotFoundException {
		return fishingClassReportService.updateFishingClassReport(fishingClassReportId, fishingClassReportDetails);
	}

	@DeleteMapping("/fishingClassReports/{id}")
	public Map<String, Boolean> deleteFishingClassReport(@PathVariable(value = "id") int fishingClassReportId)
			throws ResourceNotFoundException {
		return fishingClassReportService.deleteFishingClassReport(fishingClassReportId);
	}
}
