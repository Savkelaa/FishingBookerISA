package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.AdditionalService;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Integer> {

}
