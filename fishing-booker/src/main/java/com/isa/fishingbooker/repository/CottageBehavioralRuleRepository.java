package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageBehavioralRule;

@Repository
public interface CottageBehavioralRuleRepository extends JpaRepository<CottageBehavioralRule, Integer> {

	@Query(value = "SELECT * from cottage_behavioral_rule\r\n"
			+ "WHERE cottage_id = :cottageId", nativeQuery = true)
	List<CottageBehavioralRule> getCottageBehavioralRulesByCottage(Integer cottageId);
}
