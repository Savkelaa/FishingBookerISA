package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageQuickReservation;

@Repository
public interface CottageQuickReservationRepository extends JpaRepository<CottageQuickReservation, Integer> {

}
