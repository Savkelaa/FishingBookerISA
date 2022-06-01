package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassQuickReservation;
import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.model.FishingClassQuickReservation;

@Repository
public interface FishingClassQuickReservationRepository extends JpaRepository<FishingClassQuickReservation, Integer> {


	@Query(value="select * from fishing_class_quick_reservation where client_id=:clientId",nativeQuery=true)
	List<FishingClassQuickReservation> getAllFishingClassQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFishingClassQuickReservationAtPresentByClient(Integer clientId);

	@Query(value = "SELECT * FROM fishing_class_quick_reservation\r\n"
			+ "INNER JOIN fishing_class ON fishing_class_quick_reservation.fishing_class_id = fishing_class.id\r\n"
			+ "WHERE instructor_id = :instructorId", nativeQuery = true)
	List<FishingClassQuickReservation> getFishingClassQuickReservationsByInstructor(Integer instructorId);


	@Query(value = "SELECT * FROM fishing_class_quick_reservation\r\n"
	+ "	INNER JOIN fishing_class ON fishing_class_quick_reservation.fishing_class_id = fishing_class.id\r\n"
	+ "	WHERE status != 'free' AND instructor_id = :instructorId", nativeQuery = true)
	List<FishingClassQuickReservation> getUnavailableFishingClassQuickReservationsByInstructor(Integer instructorId);

	@Query(value = "SELECT * from fishing_class_quick_reservation\r\n"
			+ "INNER JOIN fishing_class on fishing_class_quick_reservation.fishing_class_id = fishing_class.id\r\n"
			+ "WHERE status = 'finished' AND instructor_id = :instructorId", nativeQuery = true)
	List<FishingClassQuickReservation> getFinishedFishingClassQuickReservationsByInstructor(Integer instructorId);

	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date asc ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDateAsc(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date desc ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDateDesc(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date asc ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDurationAsc(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date desc ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDurationDesc(Integer clientId);





	@Query(value="Select * from fishing_class_quick_reservation where fishing_class_id = :fishingClassId", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFishingClassQuickReservationByFishingClass(Integer fishingClassId);

	@Query(value="SELECT *\r\n"
	+ "FROM fishing_class_quick_reservation\r\n"
	+ "INNER JOIN fishing_class on fishing_class_quick_reservation.fishing_class_id = fishing_class.id\r\n"
	+ "WHERE status = 'free' AND fishing_class_id = :fishingClassId", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFreeFishingClassQuickReservation(Integer fishingClassId);
	
	
	@Query(value="SELECT fishing_class.price *(100-fishing_class_quick_reservation.discount)/100\r\n"
	+ "FROM fishing_class_quick_reservation\r\n"
	+ "INNER JOIN fishing_class on fishing_class_quick_reservation.fishing_class_id = fishing_class.id\r\n"
	+ "where fishing_class_quick_reservation.id = :fishingClassId\r\n"
	+ "", nativeQuery=true)
	Integer getPriceWithDiscountQuickReservationByFishingClass(Integer fishingClassId);
	
	@Query(value="SELECT fishing_class.price\r\n"
			+ "FROM fishing_class_quick_reservation\r\n"
			+ "INNER JOIN fishing_class on fishing_class_quick_reservation.fishing_class_id = fishing_class.id\r\n"
			+ "where fishing_class_quick_reservation.id = :fishingClassId\r\n"
			+ "", nativeQuery=true)
    Integer getPriceQuickReservationByFishingClass(Integer fishingClassId);
	
	
	
}
