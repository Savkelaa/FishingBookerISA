package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassReservation;

@Repository
public interface FishingClassReservationRepository extends JpaRepository<FishingClassReservation, Integer> {

}
