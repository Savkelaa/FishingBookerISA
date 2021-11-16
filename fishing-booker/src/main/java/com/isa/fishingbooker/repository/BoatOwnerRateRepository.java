package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatOwnerRate;

@Repository
public interface BoatOwnerRateRepository extends JpaRepository<BoatOwnerRate, Integer> {

}
