package com.isa.fishingbooker.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.CottageReservation;

@Repository
public interface CottageReservationRepository extends JpaRepository<CottageReservation, Integer> {

	@Query(value="select * from cottage_reservation where client_id=:clientId",nativeQuery=true)
	List<CottageReservation> getAllCottageReservationByClient(Integer clientId);
	
	@Query(value="select * from cottage_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<CottageReservation> getAllFinishedCottageReservationByClient(Integer clientId);
	
	@Query(value="select * from cottage_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<CottageReservation> getAllCottageReservationAtPresentByClient(Integer clientId);
	
	@Query(value = "SELECT * FROM cottage_reservation\r\n"
			+ "INNER JOIN cottage ON cottage_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE status != 'free' AND cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<CottageReservation> getCottageReservationsByOwner(Integer cottageOwnerId);
	
	@Query(value = "SELECT * from cottage_reservation\r\n"
			+ "INNER JOIN cottage on cottage_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE status = 'finished' AND cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<CottageReservation> getFinishedCottageReservationsByOwner(Integer cottageOwnerId);
	
	
}
