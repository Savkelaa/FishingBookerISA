package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatReport;
import com.isa.fishingbooker.service.BoatReportService;

@RestController
@RequestMapping("/api/v1")
public class BoatReportController {

	@Autowired
	private BoatReportService boatReportService;

	@GetMapping("/boatReports")
	public List<BoatReport> getAllBoatReports() {
		return this.boatReportService.getAllBoatReports();
	}

	@GetMapping("/boatReports/{id}")
	public ResponseEntity<BoatReport> getBoatReportById(@PathVariable(value = "id") int boatReportId)
			throws ResourceNotFoundException {
		return boatReportService.getBoatReportById(boatReportId);
	}

	@PostMapping("/boatReports")
	public BoatReport createBoatReport(@RequestBody BoatReport boatReport) {
		return boatReportService.createBoatReport(boatReport);
	}

	@PutMapping("/boatReports/{id}")
	public ResponseEntity<BoatReport> updateBoatReport(@PathVariable(value = "id") int boatReportId,
			@RequestBody BoatReport boatReportDetails) throws ResourceNotFoundException {
		return boatReportService.updateBoatReport(boatReportId, boatReportDetails);
	}

	@DeleteMapping("/boatReports/{id}")
	public Map<String, Boolean> deleteBoatReport(@PathVariable(value = "id") int boatReportId)
			throws ResourceNotFoundException {
		return boatReportService.deleteBoatReport(boatReportId);
	}
}
