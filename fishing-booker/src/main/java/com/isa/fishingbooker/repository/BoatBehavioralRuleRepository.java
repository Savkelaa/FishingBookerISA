package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatBehavioralRule;
import com.isa.fishingbooker.model.BoatBehavioralRule;

@Repository
public interface BoatBehavioralRuleRepository extends JpaRepository<BoatBehavioralRule, Integer> {

	@Query(value = "SELECT * from boat_behavioral_rule\r\n"
			+ "WHERE boat_id = :boatId", nativeQuery = true)
	List<BoatBehavioralRule> getBoatBehavioralRulesByBoat(Integer boatId);
}
