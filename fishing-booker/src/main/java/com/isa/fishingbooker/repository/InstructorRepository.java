package com.isa.fishingbooker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	@Query(value="select * from instructor where email=:email and password=:password",nativeQuery=true)
	Instructor getInstructorByEmailAndPassword(String email, String password);
	
	@Query(value="Select * from instructor where activated = 'false' and deleted = 'false';",nativeQuery=true)
	List<Instructor> getAllInstructorRequests();
	
}
