package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Boat;
import com.isa.fishingbooker.model.Boat;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import javax.transaction.Transactional;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Integer> {
	
	
	@Query(value = "SELECT * FROM boat"
			+ " WHERE boat_owner_id = :boatOwnerId AND name like :boatName%", nativeQuery = true)
	List<Boat> getBoatsByOwnerAndName(Integer boatOwnerId, String boatName);

	
	@Query(value = "SELECT * FROM boat"
			+ " WHERE boat_owner_id = :boatOwnerId", nativeQuery = true)
	List<Boat> getBoatsByOwner(Integer boatOwnerId);

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
	
	@Query(value="select * from boat where price < :prices",nativeQuery=true)
	List<Boat> getAllBoatsPrices(Integer prices);
	
	@Query(value="select * from boat where address = :prices",nativeQuery=true)
	List<Boat> getAllBoatsAddress(String prices);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "0")})
	Boat findLockedById(Long id);

	
	
	
}
