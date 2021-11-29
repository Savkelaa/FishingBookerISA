package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Boat;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Integer> {

	@Query(value="select * from boat order by name asc",nativeQuery=true)
	List<Boat> getAllBoatsSortedByNameAsc();
	
	@Query(value="select * from boat order by name desc",nativeQuery=true)
	List<Boat> getAllBoatsSortedByNameDesc();
	
	@Query(value="select * from boat order by address asc",nativeQuery=true)
	List<Boat> getAllBoatsSortedByAddressAsc();
	
	@Query(value="select * from boat order by address desc",nativeQuery=true)
	List<Boat> getAllBoatsSortedByAddressDesc();
	
	@Query(value="select * from boat order by price asc",nativeQuery=true)
	List<Boat> getAllBoatsSortedByPriceAsc();
	
	@Query(value="select * from boat order by price desc",nativeQuery=true)
	List<Boat> getAllBoatsSortedByPriceDesc();
}
