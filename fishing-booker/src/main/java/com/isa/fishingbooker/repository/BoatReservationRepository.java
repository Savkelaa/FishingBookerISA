package com.isa.fishingbooker.repository;

import java.util.List;

import com.isa.fishingbooker.model.CottageReservation;
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

	@Query(value = "SELECT * FROM boat_reservation\n" +
			"INNER JOIN boat ON boat_reservation.boat_id = boat.id\n" +
			"WHERE boat_owner_id = :boatOwnerId", nativeQuery = true)
	List<BoatReservation> getBoatReservationsByBoatOwner(Integer boatOwnerId);

	@Query(value = "Select sum(boat.price) from boat\n" +
			"INNER JOIN boat_reservation on boat.id = boat_reservation.boat_id\n" +
			"where finish_date <CURRENT_TIMESTAMP ", nativeQuery = true)
	Double getTotalPriceCompletedBoatReservations();

	@Query(value="select * from boat_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date asc ", nativeQuery=true)
	List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDateAsc(Integer clientId);
	
	@Query(value="select * from boat_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date desc ", nativeQuery=true)
	List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDateDesc(Integer clientId);
	
	@Query(value="select * from boat_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date asc ", nativeQuery=true)
	List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDurationAsc(Integer clientId);
	
	@Query(value="select * from boat_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date desc ", nativeQuery=true)
	List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDurationDesc(Integer clientId);

}
