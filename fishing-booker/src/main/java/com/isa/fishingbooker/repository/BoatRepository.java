package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Boat;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Integer> {

}
