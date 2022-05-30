package com.isa.fishingbooker.repository;

import java.util.List;

import com.isa.fishingbooker.model.LoyaltyCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface LoyaltyCategoryRepository extends JpaRepository<LoyaltyCategory, Integer> {
}