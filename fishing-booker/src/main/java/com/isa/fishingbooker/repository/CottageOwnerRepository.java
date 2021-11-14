package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageOwner;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Integer> {

}