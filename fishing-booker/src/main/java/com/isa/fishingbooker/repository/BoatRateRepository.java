package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.BoatReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatRate;

import java.util.List;

@Repository
public interface BoatRateRepository extends JpaRepository<BoatRate, Integer> {
    @Query(value = "Select * from boat_rate where accepted='false' and request='true'", nativeQuery = true)
    List<BoatRate> getAllBoatRateRequests();
    
    @Query(value = "Select avg(rate) from boat_rate where accepted = 'true' and boat_id = :boatId", nativeQuery = true)
    Double getBoatAvgRate(Integer boatId);
    
}
