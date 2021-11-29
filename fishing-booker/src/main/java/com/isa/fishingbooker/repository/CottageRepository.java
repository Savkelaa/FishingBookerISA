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
	
	@Query(value="select * from cottage order by name asc",nativeQuery=true)
	List<Cottage> getAllCottagesSortedByNameAsc();
	
	@Query(value="select * from cottage order by name desc",nativeQuery=true)
	List<Cottage> getAllCottagesSortedByNameDesc();
	
	@Query(value="select * from cottage order by address asc",nativeQuery=true)
	List<Cottage> getAllCottagesSortedByAddressAsc();
	
	@Query(value="select * from cottage order by address desc",nativeQuery=true)
	List<Cottage> getAllCottagesSortedByAddressDesc();
	
	@Query(value="select * from cottage order by price asc",nativeQuery=true)
	List<Cottage> getAllCottagesSortedByPriceAsc();
	
	@Query(value="select * from cottage order by price desc",nativeQuery=true)
	List<Cottage> getAllCottagesSortedByPriceDesc();
}
