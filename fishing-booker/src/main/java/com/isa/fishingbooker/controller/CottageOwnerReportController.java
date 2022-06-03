package com.isa.fishingbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.model.CottageOwnerReport;
import com.isa.fishingbooker.model.CottageOwnerReport;
import com.isa.fishingbooker.service.CottageOwnerReportService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageOwnerReportController {

	@Autowired
	private CottageOwnerReportService cottageOwnerReportService;
	
	@PostMapping("/cottageOwnerReport")
    public CottageOwnerReport createCottageOwnerReport(@RequestBody CottageOwnerReport cottageOwnerReport) {
        return cottageOwnerReportService.createCottageOwnerReport(cottageOwnerReport);
    }
	
	@GetMapping("/cottageOwnerReport")
    public List<CottageOwnerReport> getAllCottageOwnerReports() {
        return this.cottageOwnerReportService.getAll();
    }
}
