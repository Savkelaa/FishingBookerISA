package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageRate;

@Repository
public interface CottageRateRepository extends JpaRepository<CottageRate, Integer> {

}
