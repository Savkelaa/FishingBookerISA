package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageComplaint;

@Repository
public interface CottageComplaintRepository extends JpaRepository<CottageComplaint, Integer> {

}
