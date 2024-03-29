package com.isa.fishingbooker.repository;

import java.util.Date;
import java.util.List;

import com.isa.fishingbooker.model.CottageQuickReservation;
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
			+ "WHERE cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<CottageReservation> getCottageReservationsByOwner(Integer cottageOwnerId);

	@Query(value = "Select sum(cottage.price) from cottage\n" +
			"INNER JOIN cottage_reservation on cottage.id = cottage_reservation.cottage_id\n" +
			"where finish_date <CURRENT_TIMESTAMP and status='finished'", nativeQuery = true)
	Double getTotalPriceComplatedCottageReservations();


	@Query(value = "SELECT * FROM cottage_reservation\n" +
			"INNER JOIN cottage ON cottage_reservation.cottage_id = cottage.id\n" +
			"WHERE cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<CottageReservation> getCottageReservationsByCottageOwner(Integer cottageOwnerId);
	
	@Query(value = "select count (*) from cottage_reservation where cottage_id = :cottageId "
			+ "and finish_date > current_date-350\r\n", nativeQuery = true)
	Double CountYearlyCottageReservations(Integer cottageId);
	
	@Query(value = "select count (*) from cottage_reservation where cottage_id = :cottageId "
			+ "and finish_date > current_date-30\r\n", nativeQuery = true)
	Double CountMonthlyCottageReservations(Integer cottageId);
	
	@Query(value = "select count (*) from cottage_reservation where cottage_id = :cottageId "
			+ "and finish_date > current_date-7\r\n", nativeQuery = true)
	Double CountWeeklyCottageReservations(Integer cottageId);


	@Query(value = "SELECT * from cottage_reservation\r\n"
			+ "INNER JOIN cottage on cottage_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE status = 'finished' AND cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<CottageReservation> getFinishedCottageReservationsByOwner(Integer cottageOwnerId);
	
	@Query(value="select * from cottage_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date asc ", nativeQuery=true)
	List<CottageReservation> getAllFinishedCottageReservationByClientSortedByDateAsc(Integer clientId);
	
	@Query(value="select * from cottage_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date desc ", nativeQuery=true)
	List<CottageReservation> getAllFinishedCottageReservationByClientSortedByDateDesc(Integer clientId);
	
	@Query(value="select * from cottage_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date asc ", nativeQuery=true)
	List<CottageReservation> getAllFinishedCottageReservationByClientSortedByDurationAsc(Integer clientId);
	
	@Query(value="select * from cottage_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date desc ", nativeQuery=true)
	List<CottageReservation> getAllFinishedCottageReservationByClientSortedByDurationDesc(Integer clientId);

	@Query(value = "select sum(price) from cottage_reservation where finish_date > current_date-7 and finish_date < current_date"
			+ " and cottage_id = :cottageId"
			+ "", nativeQuery = true)
	Double CountWeeklyIncomeCottageReservations(Integer cottageId);
	
	@Query(value = "select sum(price) from cottage_reservation where finish_date > current_date-30 and finish_date < current_date"
			+ " and cottage_id = :cottageId"
			+ "", nativeQuery = true)
	Double CountMonthlyIncomeCottageReservations(Integer cottageId);
	
	@Query(value = "select sum(price) from cottage_reservation where finish_date > current_date-350 and finish_date < current_date"
			+ " and cottage_id = :cottageId"
			+ "", nativeQuery = true)
	Double CountYearlyIncomeCottageReservations(Integer cottageId);
	
}
