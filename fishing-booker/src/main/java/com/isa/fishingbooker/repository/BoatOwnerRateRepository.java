package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.InstructorRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatOwnerRate;

import java.util.List;

@Repository
public interface BoatOwnerRateRepository extends JpaRepository<BoatOwnerRate, Integer> {

    @Query(value = "Select * from boat_owner_rate where accepted='false' and request='true'", nativeQuery = true)
    List<BoatOwnerRate> getAllBoatOwnerRateRequests();
}
