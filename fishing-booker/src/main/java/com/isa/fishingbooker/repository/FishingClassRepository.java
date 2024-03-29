package com.isa.fishingbooker.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Cottage;
import com.isa.fishingbooker.model.FishingClass;
import com.isa.fishingbooker.model.FishingClassBehavioralRule;


@Repository
public interface FishingClassRepository extends JpaRepository<FishingClass, Integer> {

	@Query(value="SELECT short_biography from instructor \r\n"
	+ "INNER JOIN fishing_class on instructor.id = fishing_class.instructor_id\r\n"
	+ "WHERE fishing_class.id=:fishingClassId",nativeQuery=true)	
	List<String> getShortBiographyByFishingClass(Integer fishingClassId);
	
	@Query(value = "SELECT * FROM fishing_class\r\n"
	+ "WHERE instructor_id = :instructorId AND name LIKE :fishingclassName%", nativeQuery = true)
	List<FishingClass> getFishingClassByInstructorAndName(Integer instructorId, String fishingclassName);
	
	@Query(value = "SELECT * FROM fishing_class\r\n"
			+ "WHERE instructor_id = :instructorId", nativeQuery = true)
	List<FishingClass> getFishingClassByInstructor(Integer instructorId);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "0")})
	FishingClass findLockedById(Long id);


}
