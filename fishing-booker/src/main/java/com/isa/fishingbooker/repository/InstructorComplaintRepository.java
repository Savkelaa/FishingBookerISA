package com.isa.fishingbooker.repository;

import com.isa.fishingbooker.model.InstructorComplaint;
import com.isa.fishingbooker.model.InstructorRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstructorComplaintRepository extends JpaRepository<InstructorComplaint, Integer> {

    @Query(value = "Select * from instructor_complaint where active='true'", nativeQuery = true)
    List<InstructorComplaint> getAllInstructorComplaintRequests();
}
