package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageReport;

@Repository
public interface CottageReportRepository extends JpaRepository<CottageReport, Integer> {

}
