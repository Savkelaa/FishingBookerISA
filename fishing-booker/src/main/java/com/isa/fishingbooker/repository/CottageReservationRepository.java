package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageReservation;

@Repository
public interface CottageReservationRepository extends JpaRepository<CottageReservation, Integer> {

}
