package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageQuickReservation;
import com.isa.fishingbooker.model.CottageReservation;

@Repository
public interface CottageQuickReservationRepository extends JpaRepository<CottageQuickReservation, Integer> {

	@Query(value="select * from cottage_quick_reservation where client_id=:clientId",nativeQuery=true)
	List<CottageQuickReservation> getAllCottageQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from cottage_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from cottage_quick_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<CottageQuickReservation> getAllCottageQuickReservationAtPresentByClient(Integer clientId);
}
