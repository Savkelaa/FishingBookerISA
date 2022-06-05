package com.isa.fishingbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.model.BoatOwnerReport;
import com.isa.fishingbooker.service.BoatOwnerReportService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatOwnerReportController {

	@Autowired
	private BoatOwnerReportService boatOwnerReportService;
	
	@PostMapping("/boatOwnerReport")
    public BoatOwnerReport createBoatOwnerReport(@RequestBody BoatOwnerReport boatOwnerReport) {
        return boatOwnerReportService.createBoatOwnerReport(boatOwnerReport);
    }
	
	@GetMapping("/boatOwnerReport")
    public List<BoatOwnerReport> getAllBoatOwnerReports() {
        return this.boatOwnerReportService.getAll();
    }
}

