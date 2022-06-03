package com.isa.fishingbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.fishingbooker.model.CottageOwnerReport;

import com.isa.fishingbooker.repository.CottageOwnerReportRepository;

@Service
public class CottageOwnerReportService {
	
	@Autowired
	private CottageOwnerReportRepository cottageOwnerReportRepository;

	public CottageOwnerReport createCottageOwnerReport(CottageOwnerReport cottageOwnerReport) {
        return cottageOwnerReportRepository.save(cottageOwnerReport);
	}
	
	public List<CottageOwnerReport> getAll() {
		return cottageOwnerReportRepository.findAll();
	}
}
