package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatNavigationEquipment;

@Repository
public interface BoatNavigationEquipmentRepository extends JpaRepository<BoatNavigationEquipment, Integer> {

}
