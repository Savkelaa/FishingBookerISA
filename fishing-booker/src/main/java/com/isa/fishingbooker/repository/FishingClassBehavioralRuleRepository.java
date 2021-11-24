package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassBehavioralRule;

@Repository
public interface FishingClassBehavioralRuleRepository extends JpaRepository<FishingClassBehavioralRule, Integer>{

	@Query(value="SELECT * from fishing_class_behavioral_rule \r\n"
			+ "where fishing_class_id =:fishingClassId",nativeQuery=true)	
			List<FishingClassBehavioralRule> getBehavioralRuleByFishingClass(Integer fishingClassId);
			
}
