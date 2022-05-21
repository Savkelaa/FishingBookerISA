package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.DateSpanInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateSpanRepository extends JpaRepository<DateSpanInstructor, Integer> {

    @Query(value = "SELECT * FROM datespan\r\n"
            + "WHERE instructor_id = :instructorId", nativeQuery = true)
    List<DateSpanInstructor> getDateSpansByInstructor(Integer instructorId);
}
