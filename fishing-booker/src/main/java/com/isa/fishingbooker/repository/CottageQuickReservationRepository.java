package com.isa.fishingbooker.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import com.isa.fishingbooker.model.FishingClassReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Boat;
import com.isa.fishingbooker.model.CottageQuickReservation;
import com.isa.fishingbooker.model.CottageReservation;

@Repository
public interface CottageQuickReservationRepository extends JpaRepository<CottageQuickReservation, Integer> {

	@Query(value="select * from cottage_quick_reservation where client_id=:clientId",nativeQuery=true)
	List<CottageQuickReservation> getAllCottageQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from cottage_quick_reservation where status='free'",nativeQuery=true)
	List<CottageQuickReservation> findAll2();
	
	@Query(value="select * from cottage_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from cottage_quick_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<CottageQuickReservation> getAllCottageQuickReservationAtPresentByClient(Integer clientId);


	@Query(value = "SELECT * FROM cottage_quick_reservation\n" +
			"INNER JOIN cottage ON cottage_quick_reservation.cottage_id = cottage.id\n" +
			"WHERE cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<CottageQuickReservation> getCottageQuickReservationsByCottageOwner(Integer cottageOwnerId);

	@Query(value = "Select sum(cottage_quick_reservation.price) from cottage\n" +
			"INNER JOIN cottage_quick_reservation on cottage.id = cottage_quick_reservation.cottage_id\n" +
			"where finish_date <CURRENT_TIMESTAMP and status='finished' ", nativeQuery = true)
	Double getTotalPriceComplatedCottageQuickReservations();


	@Query(value = "SELECT * FROM cottage_quick_reservation\r\n"
			+ "INNER JOIN cottage ON cottage_quick_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<CottageQuickReservation> getCottageQuickReservationsByOwner(Integer cottageOwnerId);
	
	@Query(value = "SELECT * from cottage_quick_reservation\r\n"
			+ "INNER JOIN cottage on cottage_quick_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE status = 'finished' AND cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<CottageQuickReservation> getFinishedCottageQuickReservationsByOwner(Integer cottageOwnerId);
	
	@Query(value = "SELECT *\r\n"
			+ "FROM cottage_quick_reservation\r\n"
			+ "INNER JOIN cottage on cottage_quick_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE status = 'free' AND cottage_id = :cottageId", nativeQuery = true)
	List<CottageQuickReservation> getFreeCottageQuickReservationsByCottage(Integer cottageId);
	
	@Query(value = "SELECT *\r\n"
			+ "FROM cottage_quick_reservation\r\n"
			+ "INNER JOIN cottage on cottage_quick_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE cottage_id = :cottageId", nativeQuery = true)
	List<CottageQuickReservation> getCottageQuickReservationsByCottage(Integer cottageId);
	
	@Query(value = "select count (*) from cottage_quick_reservation where cottage_id = :cottageId "
			+ "and finish_date > current_date-350\r\n", nativeQuery = true)
	Double CountYearlyCottageQuickReservations(Integer cottageId);
	
	@Query(value = "select count (*) from cottage_reservation where cottage_id = :cottageId "
			+ "and finish_date > current_date-30\r\n", nativeQuery = true)
	Double CountMonthlyCottageQuickReservations(Integer cottageId);
	
	@Query(value = "select count (*) from cottage_reservation where cottage_id = :cottageId "
			+ "and finish_date > current_date-7\r\n", nativeQuery = true)
	Double CountWeeklyCottageQuickReservations(Integer cottageId);
	
	@Query(value = "select sum(price) from cottage_quick_reservation where finish_date > current_date-7 and finish_date < current_date"
			+ " and cottage_id = :cottageId"
			+ "", nativeQuery = true)
	Double CountWeeklyIncomeCottageReservations(Integer cottageId);
	
	@Query(value = "select sum(price) from cottage_quick_reservation where finish_date > current_date-30 and finish_date < current_date"
			+ " and cottage_id = :cottageId"
			+ "", nativeQuery = true)
	Double CountMonthlyIncomeCottageReservations(Integer cottageId);
	
	@Query(value = "select sum(price) from cottage_quick_reservation where finish_date > current_date-350 and finish_date < current_date"
			+ " and cottage_id = :cottageId"
			+ "", nativeQuery = true)
	Double CountYearlyIncomeCottageReservations(Integer cottageId);

	
	
	@Query(value="select * from cottage_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date asc ", nativeQuery=true)
	List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDateAsc(Integer clientId);
	
	@Query(value="select * from cottage_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date desc ", nativeQuery=true)
	List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDateDesc(Integer clientId);
	
	@Query(value="select * from cottage_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date asc ", nativeQuery=true)
	List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDurationAsc(Integer clientId);
	
	@Query(value="select * from cottage_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date desc ", nativeQuery=true)
	List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDurationDesc(Integer clientId);

	@Query(value="select q from cottage_quick_reservation q where q.id=:id  ", nativeQuery=true)
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "0")})
	CottageQuickReservation getLock(Long id);
}
