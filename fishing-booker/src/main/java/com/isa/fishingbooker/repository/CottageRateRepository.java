package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.FishingClassRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageRate;

import java.util.List;

@Repository
public interface CottageRateRepository extends JpaRepository<CottageRate, Integer> {
    @Query(value = "Select * from cottage_rate where accepted='false' and request='true'", nativeQuery = true)
    List<CottageRate> getAllCottageRateRequests();

}
