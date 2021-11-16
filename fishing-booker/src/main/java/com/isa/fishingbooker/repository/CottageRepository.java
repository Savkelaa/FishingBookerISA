package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Cottage;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Integer> {

}
