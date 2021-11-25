package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatReservation;
import com.isa.fishingbooker.model.BoatReservation;

@Repository
public interface BoatReservationRepository extends JpaRepository<BoatReservation, Integer> {

	@Query(value="select * from boat_reservation where client_id=:clientId",nativeQuery=true)
	List<BoatReservation> getAllBoatReservationByClient(Integer clientId);
	
	@Query(value="select * from boat_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<BoatReservation> getAllFinishedBoatReservationByClient(Integer clientId);
	
	@Query(value="select * from boat_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<BoatReservation> getAllBoatReservationAtPresentByClient(Integer clientId);
}
