package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatImage;

@Repository
public interface BoatImageRepository extends JpaRepository<BoatImage, Integer>{

	@Query(value="select * from boatimage where boat_id = :boatId",nativeQuery=true)
	List<BoatImage> getAllImagesByBoat(Integer boatId);
}
