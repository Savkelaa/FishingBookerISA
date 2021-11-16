package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatReservation;

@Repository
public interface BoatReservationRepository extends JpaRepository<BoatReservation, Integer> {

}
