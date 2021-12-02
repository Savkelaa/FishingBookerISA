package com.isa.fishingbooker.repository;

import java.util.List;

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
	
	@Query(value = "SELECT * from fishing_class_reservation\r\n"
			+ "INNER JOIN fishing_class on fishing_class_reservation.fishing_class_id = fishing_class.id\r\n"
			+ "WHERE status = 'finished' AND instructor_id = :instructorId", nativeQuery = true)
	List<FishingClassReservation> getFinishedFishingClassReservationsByInstructor(Integer instructorId);
	
	
	
	
}
