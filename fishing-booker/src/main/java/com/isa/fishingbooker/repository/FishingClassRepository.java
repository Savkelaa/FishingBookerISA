package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClass;

@Repository
public interface FishingClassRepository extends JpaRepository<FishingClass, Integer> {

}
