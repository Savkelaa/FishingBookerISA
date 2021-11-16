package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageOwnerRate;

@Repository
public interface CottageOwnerRateRepository extends JpaRepository<CottageOwnerRate, Integer> {

}
