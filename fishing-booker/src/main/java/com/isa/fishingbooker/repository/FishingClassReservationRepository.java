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
	

	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date asc ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDateAsc(Integer clientId);
	
	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date desc ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDateDesc(Integer clientId);
	
	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date asc ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDurationAsc(Integer clientId);
	
	@Query(value="select * from fishing_class_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date desc ", nativeQuery=true)
	List<FishingClassReservation> getAllFinishedFishingClassReservationByClientSortedByDurationDesc(Integer clientId);

}
