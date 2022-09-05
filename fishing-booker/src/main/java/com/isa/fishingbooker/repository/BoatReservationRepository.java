package com.isa.fishingbooker.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.isa.fishingbooker.model.BoatReservation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;

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

	@Query(value = "SELECT * FROM boat_reservation\r\n"
			+ "INNER JOIN boat ON boat_reservation.boat_id = boat.id\r\n"
			+ "WHERE boat_reservation.status != 'free' AND boat_owner_id = :boatOwnerId", nativeQuery = true)
	List<BoatReservation> getBoatReservationsByOwner(Integer boatOwnerId);
	
	@Query(value = "select count (*) from boat_reservation where boat_id = :boatId "
			+ "and finish_date > current_date-350\r\n", nativeQuery = true)
	Double CountYearlyBoatReservations(Integer boatId);
	
	@Query(value = "select count (*) from boat_reservation where boat_id = :boatId "
			+ "and finish_date > current_date-30\r\n", nativeQuery = true)
	Double CountMonthlyBoatReservations(Integer boatId);
	
	@Query(value = "select count (*) from boat_reservation where boat_id = :boatId "
			+ "and finish_date > current_date-7\r\n", nativeQuery = true)
	Double CountWeeklyBoatReservations(Integer boatId);
	
	@Query(value = "select sum(price) from boat_reservation"
			+ " where finish_date > current_date-7 and finish_date < current_date and boat_id = :boatId"
			, nativeQuery = true)
	Double CountWeeklyIncomeBoatReservations(Integer boatId);
	
	@Query(value = "select sum(price) from boat_reservation where finish_date > current_date-30 and finish_date < current_date"
			+ " and boat_id = :boatId"
			, nativeQuery = true)
	Double CountMonthlyIncomeBoatReservations(Integer boatId);
	
	@Query(value = "select sum(price) from boat_reservation where finish_date > current_date-350 and finish_date < current_date"
			+ " and boat_id = :boatId"
			, nativeQuery = true)
	Double CountYearlyIncomeBoatReservations(Integer boatId);
	
	
	

	

}
