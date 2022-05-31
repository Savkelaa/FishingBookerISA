package com.isa.fishingbooker.repository;

import java.util.List;

import com.isa.fishingbooker.model.InstructorReport;
import com.isa.fishingbooker.model.LoyaltyCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface LoyaltyCategoryRepository extends JpaRepository<LoyaltyCategory, Integer> {


    @Query(value = "SELECT * from loyalty_category where min_points<:clientPoints and max_points>:clientPoints", nativeQuery = true)
    List<LoyaltyCategory> getLoyaltyCategoryByClientPoints(Integer clientPoints);
}