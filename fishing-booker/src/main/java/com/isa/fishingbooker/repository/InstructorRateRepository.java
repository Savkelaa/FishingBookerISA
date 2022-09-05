package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.FishingClassRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.InstructorRate;

import java.util.List;

@Repository
public interface InstructorRateRepository extends JpaRepository<InstructorRate, Integer> {

    @Query(value = "Select * from instructor_rate where accepted='false' and request='true'", nativeQuery = true)
    List<InstructorRate> getAllInstructorRateRequests();
    
    @Query(value = "Select avg(rate) from instructor_rate where accepted = 'true' and instructor_id = :cottageId", nativeQuery = true)
    Double getInstructorAvgRate(Integer cottageId);

}
