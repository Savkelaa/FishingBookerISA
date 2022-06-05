package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatOwnerReport;

@Repository
public interface BoatOwnerReportRepository extends JpaRepository<BoatOwnerReport, Integer> {

}
