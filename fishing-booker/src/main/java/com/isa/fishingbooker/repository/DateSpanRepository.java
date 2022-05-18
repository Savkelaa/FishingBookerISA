package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.BoatRate;
import com.isa.fishingbooker.model.DateSpan;
import com.isa.fishingbooker.model.FishingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateSpanRepository extends JpaRepository<DateSpan, Integer> {

    @Query(value = "SELECT * FROM datespan\r\n"
            + "WHERE instructor_id = :instructorId", nativeQuery = true)
    List<DateSpan> getDateSpansByInstructor(Integer instructorId);
}
