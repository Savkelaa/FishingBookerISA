package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassComplaint;

@Repository
public interface FishingClassComplaintRepository extends JpaRepository<FishingClassComplaint, Integer> {

}
