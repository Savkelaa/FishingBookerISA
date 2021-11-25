package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.model.BoatQuickReservation;

@Repository
public interface BoatQuickReservationRepository extends JpaRepository<BoatQuickReservation, Integer> {

	@Query(value="select * from boat_quick_reservation where client_id=:clientId",nativeQuery=true)
	List<BoatQuickReservation> getAllBoatQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from boat_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from boat_quick_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<BoatQuickReservation> getAllBoatQuickReservationAtPresentByClient(Integer clientId);
}
