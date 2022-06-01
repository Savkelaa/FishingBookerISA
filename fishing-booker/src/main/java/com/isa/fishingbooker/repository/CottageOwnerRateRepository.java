package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.InstructorRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageOwnerRate;

import java.util.List;

@Repository
public interface CottageOwnerRateRepository extends JpaRepository<CottageOwnerRate, Integer> {
    @Query(value = "Select * from cottage_owner_rate where accepted='false' and request='true'", nativeQuery = true)
    List<CottageOwnerRate> getAllCottageOwnerRateRequests();


}
