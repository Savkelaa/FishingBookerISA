package com.isa.fishingbooker.repository;

import java.util.List;

import com.isa.fishingbooker.model.BoatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.CottageReservation;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query(value="select * from client where email=:email and password=:password",nativeQuery=true)
	Client getClientByEmailAndPassword(String email, String password);
	
	@Query(value = "SELECT * FROM client\r\n"
			+ "INNER JOIN cottage_reservation ON client.id = client_id\r\n"
			+ "INNER JOIN cottage ON cottage_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE status != 'free' AND cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<Client> getClientsByOwnerCottageReservations(Integer cottageOwnerId);
	
	@Query(value = "SELECT * FROM client\r\n"
			+ "INNER JOIN cottage_quick_reservation ON client.id = client_id\r\n"
			+ "INNER JOIN cottage ON cottage_quick_reservation.cottage_id = cottage.id\r\n"
			+ "WHERE finish_date < CURRENT_TIMESTAMP AND cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<Client> getClientsByOwnerCottageQuickReservations(Integer cottageOwnerId);

	@Query(value = "SELECT * FROM client\n" +
			"INNER JOIN fishing_class_subscribers ON client.id = client_id\n" +
			"WHERE fishing_class_id = :fishingClassId", nativeQuery = true)
	List<Client> getAllSubscribersByFishingClass(Integer fishingClassId);
	
	@Query(value = "SELECT * FROM client\r\n"
	+ "INNER JOIN fishing_class_reservation ON client.id = client_id\r\n"
	+ "INNER JOIN fishing_class ON fishing_class_reservation.fishing_class_id = fishing_class.id\r\n"
	+ "WHERE finish_date < CURRENT_TIMESTAMP AND instructor_id = :instructorId and client.name like :name%", nativeQuery = true)
	List<Client> getClientsByInstructorFishingClassReservations(Integer instructorId, String name);
	
	@Query(value = "SELECT * FROM client\r\n"
			+ "INNER JOIN fishing_class_quick_reservation ON client.id = client_id\r\n"
			+ "INNER JOIN fishing_class ON fishing_class_quick_reservation.fishing_class_id = fishing_class.id\r\n"
			+ "WHERE status != 'free' AND instructor_id = :instructorId and client.name like :name%", nativeQuery = true)
	List<Client> getClientsByInstructorFishingClassQuickReservations(Integer instructorId, String name);
	
	@Query(value="select * from client where email= :email ", nativeQuery=true)
	Client findByEmail(String email);
	
	@Query(value="SELECT * FROM CLIENT WHERE USERNAME = :email AND PASSWORD= :password", nativeQuery=true)
	Client findByEmailAndPassword(String email, String password);

	@Query(value="SELECT * FROM CLIENT WHERE delete_request = 'true'", nativeQuery=true)
	List<Client> getAllClientDeleteRequests();

	@Query(value="Select * from client where activated = 'false' and deleted = 'false';",nativeQuery=true)
	List<Client> getAllClientRequests();

//// GET NUMBER OF PAST RESERVATIONS BY CLIENT

	@Query(value="Select count(*) from fishing_class_reservation\n" +
			"\twhere client_id=:clientId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastFishingClassReservationsByClient(Integer clientId);

	@Query(value="Select count(*) from fishing_class_quick_reservation\n" +
			"\twhere client_id=:clientId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastFishingClassQuickReservationsByClient(Integer clientId);

	@Query(value="Select count(*) from boat_reservation\n" +
			"\twhere client_id=:clientId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastBoatReservationsByClient(Integer clientId);

	@Query(value="Select count(*) from boat_quick_reservation\n" +
			"\twhere client_id=:clientId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastBoatQuickReservationsByClient(Integer clientId);

	@Query(value="Select count(*) from cottage_reservation\n" +
			"\twhere client_id=:clientId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastCottageReservationsByClient(Integer clientId);

	@Query(value="Select count(*) from cottage_quick_reservation\n" +
			"\twhere client_id=:clientId and finish_date < CURRENT_TIMESTAMP;",nativeQuery=true)
	Integer getNuberOfPastCottageQuickReservationsByClient(Integer clientId);





}
