package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatReport;

@Repository
public interface BoatReportRepository extends JpaRepository<BoatReport, Integer> {

}
