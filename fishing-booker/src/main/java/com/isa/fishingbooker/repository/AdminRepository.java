package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Admin;
import com.isa.fishingbooker.model.Client;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query(value="select * from admin where email=:email and password=:password",nativeQuery=true)
	Admin getAdminByEmailAndPassword(String email, String password);
	
	@Query(value="select * from admin where email= :email", nativeQuery=true)
	Admin getAdminByEmail(String email);

	
}
