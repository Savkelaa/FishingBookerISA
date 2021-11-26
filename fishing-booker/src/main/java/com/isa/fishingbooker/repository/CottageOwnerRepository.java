package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageOwner;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Integer> {

	@Query(value = "SELECT * FROM cottage_owner\r\n"
			+ "WHERE email = :email AND password = :password", nativeQuery = true)
	CottageOwner getCottageOwnerByEmailAndPassword(String email, String password);
}
