package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.FishingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassRate;

import java.util.List;

@Repository
public interface FishingClassRateRepository extends JpaRepository<FishingClassRate, Integer> {

    @Query(value = "Select * from fishing_class_rate where accepted='false' and request='true'", nativeQuery = true)
    List<FishingClassRate> getAllFishingClassRateRequests();

    @Query(value = "Select avg(rate) from fishing_class_rate where accepted = 'true' and fishing_class_id = :fishingClassId", nativeQuery = true)
    Double getFishingClassAvgRate(Integer fishingClassId);


}
