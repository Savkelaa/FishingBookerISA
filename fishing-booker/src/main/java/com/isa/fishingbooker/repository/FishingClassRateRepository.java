package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassRate;

@Repository
public interface FishingClassRateRepository extends JpaRepository<FishingClassRate, Integer> {

}
