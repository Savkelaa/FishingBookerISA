package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.FishingClassRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatReport;

import java.util.List;

@Repository
public interface BoatReportRepository extends JpaRepository<BoatReport, Integer> {



}
