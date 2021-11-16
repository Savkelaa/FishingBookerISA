package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatBehavioralRule;

@Repository
public interface BoatBehavioralRuleRepository extends JpaRepository<BoatBehavioralRule, Integer> {

}
