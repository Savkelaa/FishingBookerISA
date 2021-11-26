package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.model.Instructor;


@Repository
public interface BoatOwnerRepository extends JpaRepository<BoatOwner, Integer> {

	@Query(value = "SELECT * FROM boat_owner\r\n"
			+ "WHERE email = :email AND password = :password", nativeQuery = true)
	BoatOwner getBoatOwnerByEmailAndPassword(String email, String password);
	
	
	@Query(value="Select * from boat_owner where activated = 'false' and deleted = 'false';",nativeQuery=true)
	List<BoatOwner> getAllBoatOwnerRequests();
}
