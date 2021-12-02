package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.AdditionalService;
import com.isa.fishingbooker.model.FishingClassReservation;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Integer> {

	@Query(value="SELECT additional_service.id,additional_service.name,additional_service.description,\r\n"
			+ "additional_service.price,additional_service.cottage_reservation_id, additional_service.cottage_quick_reservation_id,\r\n"
			+ "additional_service.boat_reservation_id, additional_service.boat_quick_reservation_id,\r\n"
			+ "additional_service.fishing_class_reservation_id,additional_service.fishing_class_quick_reservation_id\r\n"
			+ "from fishing_class_reservation\r\n"
			+ "INNER JOIN fishing_class on fishing_class_reservation.fishing_class_id= fishing_class.id\r\n"
			+ "INNER JOIN additional_service on fishing_class_reservation.id = additional_service.fishing_class_reservation_id\r\n"
			+ "where fishing_class.id =:fishingClassId",nativeQuery=true)	
			List<AdditionalService> getAdditionalServiceByFishingClass(Integer fishingClassId);
	
	@Query(value = "SELECT *\r\n"
			+ "FROM additional_service\r\n"
			+ "INNER JOIN cottage_reservation on additional_service.cottage_reservation_id = cottage_reservation.id\r\n"
			+ "INNER JOIN cottage on cottage_reservation.id = cottage.id\r\n"
			+ "WHERE cottage_id = :cottageId", nativeQuery = true)
	List<AdditionalService> getAdditionalServicesByCottage(Integer cottageId);
	
}
