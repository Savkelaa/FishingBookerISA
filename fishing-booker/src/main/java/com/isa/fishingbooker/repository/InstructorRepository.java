package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.fishingbooker.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
