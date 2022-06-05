package com.isa.fishingbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.fishingbooker.model.BoatOwnerReport;

import com.isa.fishingbooker.repository.BoatOwnerReportRepository;

@Service
public class BoatOwnerReportService {
	
	@Autowired
	private BoatOwnerReportRepository boatOwnerReportRepository;

	public BoatOwnerReport createBoatOwnerReport(BoatOwnerReport boatOwnerReport) {
        return boatOwnerReportRepository.save(boatOwnerReport);
	}
	
	public List<BoatOwnerReport> getAll() {
		return boatOwnerReportRepository.findAll();
	}
}
