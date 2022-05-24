package com.isa.fishingbooker.repository;



import com.isa.fishingbooker.model.InstructorRate;
import com.isa.fishingbooker.model.InstructorReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorReportRepository extends JpaRepository<InstructorReport, Integer> {

    @Query(value = "Select * from instructor_report where bad='true' ", nativeQuery = true)
    List<InstructorReport> getAllBadInstructorReports();

}
