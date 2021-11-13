package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatOwner;

@Repository
public interface BoatOwnerRepository extends JpaRepository<BoatOwner, Integer> {

}
