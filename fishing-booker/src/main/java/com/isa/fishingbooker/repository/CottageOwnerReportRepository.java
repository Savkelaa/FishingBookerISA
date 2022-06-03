package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageOwnerReport;

@Repository
public interface CottageOwnerReportRepository extends JpaRepository<CottageOwnerReport, Integer> {

	
}
