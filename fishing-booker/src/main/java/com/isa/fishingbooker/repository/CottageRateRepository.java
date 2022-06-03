package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.CottageRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CottageRateRepository extends JpaRepository<CottageRate, Integer> {
	
    @Query(value = "Select * from cottage_rate where accepted='false' and request='true'", nativeQuery = true)
    List<CottageRate> getAllCottageRateRequests();
    
    @Query(value = "Select avg(rate) from cottage_rate where accepted = 'true' and cottage_id = :cottageId", nativeQuery = true)
    Double getCottageAvgRate(Integer cottageId);

}
