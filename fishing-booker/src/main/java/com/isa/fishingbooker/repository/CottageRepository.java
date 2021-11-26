package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Cottage;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Integer> {

	@Query(value = "SELECT * FROM cottage"
			+ " WHERE cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<Cottage> getCottagesByOwner(Integer cottageOwnerId);
}
