package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.DateSpanBoat;

@Repository
public interface DateSpanBoatRepository extends JpaRepository<DateSpanBoat, Integer> {

	@Query(value = "SELECT * FROM datespanboat\r\n"
            + "WHERE boat_id = :boatId", nativeQuery = true)
    List<DateSpanBoat> getDateSpansByBoat(Integer boatId);
}