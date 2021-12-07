package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
	
	@Query(value="select * from image where fishing_class_id = :fishingClassId",nativeQuery=true)
	List<Image> getAllImagesByFishingClass(Integer fishingClassId);
	
	
	
}