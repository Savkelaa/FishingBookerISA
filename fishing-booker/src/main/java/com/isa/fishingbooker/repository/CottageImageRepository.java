package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageImage;

@Repository
public interface CottageImageRepository extends JpaRepository<CottageImage, Integer> {
	
	@Query(value="select * from cottageimage where cottage_id = :cottageId",nativeQuery=true)
	List<CottageImage> getAllImagesByCottage(Integer cottageId);

}
