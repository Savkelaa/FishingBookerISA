package com.isa.fishingbooker.repository;

import java.util.List;

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
			+ "WHERE status != 'free' AND cottage_owner_id = :cottageOwnerId", nativeQuery = true)
	List<Client> getClientsByOwnerCottageQuickReservations(Integer cottageOwnerId);
	
	@Query(value = "SELECT * FROM client\r\n"
	+ "INNER JOIN fishing_class_reservation ON client.id = client_id\r\n"
	+ "INNER JOIN fishing_class ON fishing_class_reservation.fishing_class_id = fishing_class.id\r\n"
	+ "WHERE status != 'free' AND instructor_id = :instructorId", nativeQuery = true)
	List<Client> getClientsByInstructorFishingClassReservations(Integer instructorId);
	
	@Query(value = "SELECT * FROM client\r\n"
			+ "INNER JOIN fishing_class_quick_reservation ON client.id = client_id\r\n"
			+ "INNER JOIN fishing_class ON fishing_class_quick_reservation.fishing_class_id = fishing_class.id\r\n"
			+ "WHERE status != 'free' AND instructor_id = :instructorId", nativeQuery = true)
	List<Client> getClientsByInstructorFishingClassQuickReservations(Integer instructorId);
	
	@Query(value="select * from client where email= :email ", nativeQuery=true)
	Client findByEmail(String email);
	
	@Query(value="SELECT * FROM CLIENT WHERE USERNAME = :email AND PASSWORD= :password", nativeQuery=true)
	Client findByEmailAndPassword(String email, String password);
	
	
	
}
