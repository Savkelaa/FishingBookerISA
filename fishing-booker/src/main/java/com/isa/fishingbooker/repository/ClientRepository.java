package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.CottageReservation;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query(value="select * from client where email=:email and password=:password",nativeQuery=true)
	Client getClientByEmailAndPassword(String email, String password);
}
