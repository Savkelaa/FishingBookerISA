package com.isa.fishingbooker.repository;

import java.util.List;

import com.isa.fishingbooker.model.FishingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.model.FishingClassReservation;

@Repository
public interface FishingClassReservationRepository extends JpaRepository<FishingClassReservation, Integer> {

	
	@Query(value="select * from fishing_class_reservation where client_id=:clientId",nativeQuery=true)
	List<FishingClassReservation> getAllFishingClassReservationByClient(Integer clientId);
	
	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClient(Integer clientId);
	
	@Query(value="select * from fishing_class_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<FishingClassReservation> getAllFishingClassReservationAtPresentByClient(Integer clientId);

	@Query(value = "SELECT * FROM fishing_class_reservation\r\n"
	+ "INNER JOIN fishing_class ON fishing_class_reservation.fishing_class_id = fishing_class.id\r\n"
	+ "WHERE status != 'free' AND instructor_id = :instructorId", nativeQuery = true)
	List<FishingClassReservation> getUnavailableFishingClassReservationsByInstructor(Integer instructorId);

	@Query(value = "SELECT * FROM fishing_class_reservation\r\n"
			+ "INNER JOIN fishing_class ON fishing_class_reservation.fishing_class_id = fishing_class.id\r\n"
			+ "WHERE instructor_id = :instructorId", nativeQuery = true)
	List<FishingClassReservation> getFishingClassReservationsByInstructor(Integer instructorId);

	@Query(value = "Select sum(fishing_class_reservation.price) from fishing_class\n" +
			"INNER JOIN fishing_class_reservation on fishing_class.id = fishing_class_reservation.fishing_class_id\n" +
			"where finish_date <CURRENT_TIMESTAMP and status='finished'", nativeQuery = true)
	Double getTotalPriceCompletedFishingClassReservations();


	@Query(value = "SELECT * from fishing_class_reservation\r\n"
			+ "INNER JOIN fishing_class on fishing_class_reservation.fishing_class_id = fishing_class.id\r\n"
			+ "WHERE status = 'finished' AND instructor_id = :instructorId", nativeQuery = true)
	List<FishingClassReservation> getFinishedFishingClassReservationsByInstructor(Integer instructorId);
	
	
	


	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date asc ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDateAsc(Integer clientId);
	
	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date desc ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDateDesc(Integer clientId);
	
	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date asc ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDurationAsc(Integer clientId);
	
	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date desc ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDurationDesc(Integer clientId);


	@Query(value = "SELECT * FROM fishing_class_reservation\r\n"
			+ "WHERE client_id = :clientId", nativeQuery = true)
	List<FishingClassReservation> getFishingClassByClient(Integer clientId);

	@Query(value = "select count (*) from fishing_class_reservation where fishing_class_id = :fishingClassId "
			+ "and finish_date > current_date-350\r\n", nativeQuery = true)
	Double CountYearlyFishingClassReservations(Integer fishingClassId);

	@Query(value = "select count (*) from fishing_class_reservation where fishing_class_id = :fishingClassId "
			+ "and finish_date > current_date-30\r\n", nativeQuery = true)
	Double CountMonthlyFishingClassReservations(Integer fishingClassId);

	@Query(value = "select count (*) from fishing_class_reservation where fishing_class_id = :fishingClassId "
			+ "and finish_date > current_date-7\r\n", nativeQuery = true)
	Double CountWeeklyFishingClassReservations(Integer fishingClassId);

	@Query(value = "select sum(price) from fishing_class_reservation"
			+ " where finish_date > current_date-7 and finish_date < current_date and fishing_class_id = :fishingClassId"
			, nativeQuery = true)
	Double CountWeeklyIncomeFishingClassReservations(Integer fishingClassId);

	@Query(value = "select sum(price) from fishing_class_reservation where finish_date > current_date-30 and finish_date < current_date"
			+ " and fishing_class_id = :fishingClassId"
			, nativeQuery = true)
	Double CountMonthlyIncomeFishingClassReservations(Integer fishingClassId);

	@Query(value = "select sum(price) from fishing_class_reservation where finish_date > current_date-350 and finish_date < current_date"
			+ " and fishing_class_id = :fishingClassId"
			, nativeQuery = true)
	Double CountYearlyIncomeFishingClassReservations(Integer fishingClassId);

}
