package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Admin;
import com.isa.fishingbooker.model.CottageOwner;
import com.isa.fishingbooker.model.Instructor;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Integer> {

	@Query(value = "SELECT * FROM cottage_owner\r\n"
			+ "WHERE email = :email AND password = :password", nativeQuery = true)
	CottageOwner getCottageOwnerByEmailAndPassword(String email, String password);
	
	
	@Query(value="Select * from cottage_owner where activated = 'false' and deleted = 'false';",nativeQuery=true)
	List<CottageOwner> getAllCottageOwnerRequests();
	
	@Query(value="select * from cottage_owner where email= :email", nativeQuery=true)
	CottageOwner getCottageOwnerByEmail(String email);

	
}
