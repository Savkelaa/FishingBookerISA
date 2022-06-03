package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.DateSpanCottage;
import com.isa.fishingbooker.model.DateSpanCottage;

@Repository
public interface DateSpanCottageRepository extends JpaRepository<DateSpanCottage, Integer> {

	@Query(value = "SELECT * FROM datespancottage\r\n"
            + "WHERE cottage_id = :cottageId", nativeQuery = true)
    List<DateSpanCottage> getDateSpansByCottage(Integer cottageId);
}
