package com.isa.fishingbooker.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import com.isa.fishingbooker.model.BoatReservation;
import com.isa.fishingbooker.model.FishingClassQuickReservation;
import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.model.BoatQuickReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.model.BoatQuickReservation;

@Repository
public interface BoatQuickReservationRepository extends JpaRepository<BoatQuickReservation, Integer> {

	@Query(value="select * from boat_quick_reservation where client_id=:clientId",nativeQuery=true)
	List<BoatQuickReservation> getAllBoatQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from boat_quick_reservation where status='free'",nativeQuery=true)
	List<BoatQuickReservation> getAllBoatQuickReservationFREE();
	
	@Query(value="select * from boat_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from boat_quick_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<BoatQuickReservation> getAllBoatQuickReservationAtPresentByClient(Integer clientId);

	@Query(value="select * from boat_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date asc ", nativeQuery=true)
	List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDateAsc(Integer clientId);

	@Query(value = "SELECT * FROM boat_quick_reservation\n" +
			"INNER JOIN boat ON boat_quick_reservation.boat_id = boat.id\n" +
			"WHERE boat_owner_id = :boatOwnerId", nativeQuery = true)
	List<BoatQuickReservation> getBoatQuickReservationsByBoatOwner(Integer boatOwnerId);

	@Query(value = "Select sum(boat.price) from boat\n" +
			"INNER JOIN boat_quick_reservation on boat.id = boat_quick_reservation.boat_id\n" +
			"where finish_date <CURRENT_TIMESTAMP ", nativeQuery = true)
	Double getTotalPriceCompletedBoatQuickReservations();

	@Query(value="select * from boat_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date desc ", nativeQuery=true)
	List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDateDesc(Integer clientId);
	
	@Query(value="select * from boat_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date asc ", nativeQuery=true)
	List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDurationAsc(Integer clientId);
	
	@Query(value="select * from boat_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date desc ", nativeQuery=true)
	List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDurationDesc(Integer clientId);

	@Query(value = "SELECT * FROM boat_quick_reservation\r\n"
			+ "INNER JOIN boat ON boat_quick_reservation.boat_id = boat.id\r\n"
			+ "WHERE boat_quick_reservation.status != 'free' AND boat_owner_id = :boatOwnerId", nativeQuery = true)
	List<BoatQuickReservation> getBoatQuickReservationsByOwner(Integer boatOwnerId);
	
	@Query(value = "SELECT *\r\n"
			+ "FROM boat_quick_reservation\r\n"
			+ "INNER JOIN boat on boat_quick_reservation.boat_id = boat.id\r\n"
			+ "WHERE boat_quick_reservation.status = 'free' AND boat_id = :boatId", nativeQuery = true)
	List<BoatQuickReservation> getFreeBoatQuickReservationsByBoat(Integer boatId);
	
	@Query(value = "SELECT *\r\n"
			+ "FROM boat_quick_reservation\r\n"
			+ "INNER JOIN boat on boat_quick_reservation.boat_id = boat.id\r\n"
			+ "WHERE boat_id = :boatId", nativeQuery = true)
	List<BoatQuickReservation> getBoatQuickReservationsByBoat(Integer boatId);
	
	@Query(value = "select count (*) from boat_quick_reservation where boat_id = :boatId "
			+ "and finish_date > current_date-350\r\n", nativeQuery = true)
	Double CountYearlyBoatQuickReservations(Integer boatId);
	
	@Query(value = "select count (*) from boat_reservation where boat_id = :boatId "
			+ "and finish_date > current_date-30\r\n", nativeQuery = true)
	Double CountMonthlyBoatQuickReservations(Integer boatId);
	
	@Query(value = "select count (*) from boat_reservation where boat_id = :boatId "
			+ "and finish_date > current_date-7\r\n", nativeQuery = true)
	Double CountWeeklyBoatQuickReservations(Integer boatId);
	
	@Query(value = "select sum(price) from boat_quick_reservation"
			+ " where finish_date > current_date-7 and finish_date < current_date and boat_id = :boatId"
			, nativeQuery = true)
	Double CountWeeklyIncomeBoatReservations(Integer boatId);
	
	@Query(value = "select sum(price) from boat_quick_reservation where finish_date > current_date-30 and finish_date < current_date"
			+ " and boat_id = :boatId"
			, nativeQuery = true)
	Double CountMonthlyIncomeBoatReservations(Integer boatId);
	
	@Query(value = "select sum(price) from boat_quick_reservation where finish_date > current_date-350 and finish_date < current_date"
			+ " and boat_id = :boatId"
			, nativeQuery = true)
	Double CountYearlyIncomeBoatReservations(Integer boatId);
	
	
	@Query(value="select q from boat_quick_reservation q where q.id=:id  ", nativeQuery=true)
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "0")})
	BoatQuickReservation getLock(Long id);

	
}
