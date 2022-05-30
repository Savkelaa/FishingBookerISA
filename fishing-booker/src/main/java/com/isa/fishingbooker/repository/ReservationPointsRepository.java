package com.isa.fishingbooker.repository;


import com.isa.fishingbooker.model.ReservationPoints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationPointsRepository extends JpaRepository<ReservationPoints, Integer> {
}
