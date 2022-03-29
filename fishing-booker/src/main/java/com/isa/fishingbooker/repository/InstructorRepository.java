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


}
