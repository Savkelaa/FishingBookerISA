package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.FishingClassQuickReservation;
import com.isa.fishingbooker.model.FishingClassQuickReservation;

@Repository
public interface FishingClassQuickReservationRepository extends JpaRepository<FishingClassQuickReservation, Integer> {


	@Query(value="select * from fishing_class_quick_reservation where client_id=:clientId",nativeQuery=true)
	List<FishingClassQuickReservation> getAllFishingClassQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClient(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where start_date >CURRENT_TIMESTAMP and client_id=:clientId ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFishingClassQuickReservationAtPresentByClient(Integer clientId);

	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date asc ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDateAsc(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by start_date desc ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDateDesc(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date asc ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDurationAsc(Integer clientId);
	
	@Query(value="select * from fishing_class_quick_reservation where finish_date <CURRENT_TIMESTAMP and client_id=:clientId order by finish_date-start_date desc ", nativeQuery=true)
	List<FishingClassQuickReservation> getAllFinishedFishingClassQuickReservationByClientSortedByDurationDesc(Integer clientId);

}
