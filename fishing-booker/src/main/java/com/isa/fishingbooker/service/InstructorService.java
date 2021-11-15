package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Instructor;
import com.isa.fishingbooker.repository.InstructorRepository;

@Service
public class InstructorService {

	@Autowired
	private InstructorRepository InstructorRepository;
	
	public List<Instructor> getAllInstructors(){
		return this.InstructorRepository.findAll();
	}
	
	public ResponseEntity<Instructor> getInstructorById(int instructorId)
		throws ResourceNotFoundException{
		Instructor instructor = InstructorRepository.findById(instructorId).orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));
	 return ResponseEntity.ok().body(instructor);
	}
	
	@PostMapping("/instructors")
	public Instructor createInstructor(Instructor instructor) {
		return InstructorRepository.save(instructor);
	}
	
	
	@PutMapping("/instructor/{id}")
	public ResponseEntity<Instructor> updateInstructor(Integer instructorId,
			 @RequestBody Instructor instructorDetails) throws ResourceNotFoundException {
		Instructor instructor = InstructorRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));
		
		instructor.setAddress(instructorDetails.getAddress());
		instructor.setCity(instructorDetails.getCity());
		instructor.setCountry(instructorDetails.getCountry());
		instructor.setEmail(instructorDetails.getEmail());
		instructor.setExplanation(instructorDetails.getExplanation());
		instructor.setName(instructorDetails.getName());
		instructor.setNumber(instructorDetails.getNumber());
		instructor.setPassword(instructorDetails.getPassword());
		instructor.setShortBiography(instructorDetails.getShortBiography());
		instructor.setSurname(instructorDetails.getSurname());
		
		final Instructor updatedInstructor = InstructorRepository.save(instructor);
		return ResponseEntity.ok(updatedInstructor);
	}
	
	@DeleteMapping("/instructors/{id}")
	public Map<String, Boolean> deleteInstructor(int instructorId)
			throws ResourceNotFoundException {
		Instructor  instructor = InstructorRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));

		InstructorRepository.delete(instructor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
