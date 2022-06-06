package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.CottageOwner;
import com.isa.fishingbooker.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	@Query(value="select * from instructor where deleted = 'false' and activated='true'",nativeQuery=true)
	List<Instructor> getAllInstructorsNotDeleted();


	@Query(value="select * from instructor where email=:email and password=:password",nativeQuery=true)
	Instructor getInstructorByEmailAndPassword(String email, String password);
	
	@Query(value="Select * from instructor where activated = 'false' and deleted = 'false';",nativeQuery=true)
	List<Instructor> getAllInstructorRequests();
	
	@Query(value="select * from Instructor order by name asc",nativeQuery=true)
	List<Instructor> getAllInstructorsSortedByNameAsc();
	
	@Query(value="select * from Instructor order by name desc",nativeQuery=true)
	List<Instructor> getAllInstructorsSortedByNameDesc();
	
	@Query(value="select * from Instructor order by address asc",nativeQuery=true)
	List<Instructor> getAllInstructorsSortedByAddressAsc();
	
	@Query(value="select * from Instructor order by address desc",nativeQuery=true)
	List<Instructor> getAllInstructorsSortedByAddressDesc();
	
	@Query(value="select * from Instructor order by price asc",nativeQuery=true)
	List<Instructor> getAllInstructorsSortedByPriceAsc();
	
	@Query(value="select * from Instructor order by price desc",nativeQuery=true)
	List<Instructor> getAllInstructorsSortedByPriceDesc();
	
	@Query(value="select * from instructor where email= :email", nativeQuery=true)
	Instructor getInstructorByEmail(String email);

	@Query(value="select * from instructor where delete_request='true'", nativeQuery=true)
	List<Instructor> getAllInstructorDeleteRequests();

	/// GET NUMBER OF ALL RESERVATIONS BY INSTRUCTOR, BOAT OWNER, COTTAGE OWNER


	@Query(value="SELECT count(*) from fishing_class_reservation\n" +
			"INNER JOIN fishing_class ON fishing_class_reservation.fishing_class_id = fishing_class.id\n" +
			"WHERE instructor_id = :instructorId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastFishingClassReservationsByInstructor(Integer instructorId);

	@Query(value="SELECT count(*) from fishing_class_quick_reservation\n" +
			"INNER JOIN fishing_class ON fishing_class_quick_reservation.fishing_class_id = fishing_class.id\n" +
			"WHERE instructor_id = :instructorId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastFishingClassQuickReservationsByInstructor(Integer instructorId);

	@Query(value="SELECT count(*) from boat_reservation\n" +
			"INNER JOIN boat ON boat_reservation.boat_id = boat.id\n" +
			"WHERE boat_owner_id = :boatOwnerId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastBoatReservationsByBoatOwner(Integer boatOwnerId);

	@Query(value="SELECT count(*) from boat_quick_reservation\n" +
			"INNER JOIN boat ON boat_quick_reservation.boat_id = boat.id\n" +
			"WHERE boat_owner_id = :boatOwnerId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastBoatQuickReservationsByBoatOwner(Integer boatOwnerId);

	@Query(value="SELECT count(*) from cottage_reservation\n" +
			"INNER JOIN cottage ON cottage_reservation.cottage_id = cottage.id\n" +
			"WHERE cottage_owner_id = :cottageOwnerId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastCottageReservationsByCottageOwner(Integer cottageOwnerId);

	@Query(value="SELECT count(*) from cottage_quick_reservation\n" +
			"INNER JOIN cottage ON cottage_quick_reservation.cottage_id = cottage.id\n" +
			"WHERE cottage_owner_id = :cottageOwnerId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastCottageQuickReservationsByCottageOwner(Integer cottageOwnerId);




}
