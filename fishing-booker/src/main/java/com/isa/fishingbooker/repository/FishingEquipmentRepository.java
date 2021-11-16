package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingEquipment;

@Repository
public interface FishingEquipmentRepository extends JpaRepository<FishingEquipment, Integer>{

}
