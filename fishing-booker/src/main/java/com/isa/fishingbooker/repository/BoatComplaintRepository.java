package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatComplaint;

@Repository
public interface BoatComplaintRepository extends JpaRepository<BoatComplaint, Integer> {

}
