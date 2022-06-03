package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.isa.fishingbooker.model.FishingEquipment;

@Repository
public interface FishingEquipmentRepository extends JpaRepository<FishingEquipment, Integer>{

	@Query(value="SELECT fishing_equipment.name from fishing_class_reservation\r\n"
	+ "INNER JOIN fishing_class on fishing_class_reservation.fishing_class_id= fishing_class.id\r\n"
	+ "INNER JOIN fishing_equipment on fishing_class_reservation.id = fishing_equipment.fishing_class_reservation_id\r\n"
	+ "where fishing_class_reservation.id = :fishingClassReservationId",nativeQuery=true)	
			List<String> getFishingEquipmentByFishingClassReservation(Integer fishingClassReservationId);

	@Query(value="Select * from fishing_equipment where fishing_class_quick_reservation_id IS NOT NULL or fishing_class_reservation_id IS NOT NULL",nativeQuery=true)
	List<FishingEquipment> getAllFishingEquipmentsFishingClass();


}
