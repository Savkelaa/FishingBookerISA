package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.Instructor;
import com.isa.fishingbooker.repository.InstructorRepository;

@Service
public class InstructorService {

	@Autowired
	private InstructorRepository InstructorRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Instructor> getAllInstructors(){
		return this.InstructorRepository.findAll();
	}
	
	public List<Instructor> getAllInstructorRequests(){
		return this.InstructorRepository.getAllInstructorRequests();
	}
	
	public ResponseEntity<Instructor> getInstructorById(int instructorId)
		throws ResourceNotFoundException{
		Instructor instructor = InstructorRepository.findById(instructorId).orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));
	 return ResponseEntity.ok().body(instructor);
	}
	

	public Instructor createInstructor(Instructor instructor) {
		instructor.setPassword(passwordEncoder.encode(instructor.getPassword()));
		return InstructorRepository.save(instructor);
	}
	

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
	
	public ResponseEntity<Instructor> activateInstructor(Integer instructorId) throws ResourceNotFoundException {
		Instructor instructor = InstructorRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));
		
		instructor.setActivated("true");
		
		final Instructor updatedInstructor = InstructorRepository.save(instructor);
		return ResponseEntity.ok(updatedInstructor);
	}
	
	public ResponseEntity<Instructor> removeInstructor(Integer instructorId) throws ResourceNotFoundException {
		Instructor instructor = InstructorRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));
		
		instructor.setDeleted("true");
		
		final Instructor updatedInstructor = InstructorRepository.save(instructor);
		return ResponseEntity.ok(updatedInstructor);
	}
	
	

	public Map<String, Boolean> deleteInstructor(int instructorId)
			throws ResourceNotFoundException {
		Instructor  instructor = InstructorRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));

		InstructorRepository.delete(instructor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public Instructor getInstructorByEmailAndPassword(String email, String password) {
		return InstructorRepository.getInstructorByEmailAndPassword(email, password);
	}
	public List<Instructor> getAllInstructorsSortedByNameAsc(){
		return InstructorRepository.getAllInstructorsSortedByNameAsc();
	}
	public 	List<Instructor> getAllInstructorsSortedByNameDesc(){
		return InstructorRepository.getAllInstructorsSortedByNameDesc();
	}

	public List<Instructor> getAllInstructorsSortedByAddressAsc(){
		return InstructorRepository.getAllInstructorsSortedByAddressAsc();
	}
	
	
	public List<Instructor> getAllInstructorsSortedByAddressDesc(){
		return InstructorRepository.getAllInstructorsSortedByAddressDesc();
	}
	
	
	public List<Instructor> getAllInstructorsSortedByPriceAsc(){
		return InstructorRepository.getAllInstructorsSortedByPriceAsc();
	}
	
	
	public List<Instructor> getAllInstructorsSortedByPriceDesc(){
		return InstructorRepository.getAllInstructorsSortedByPriceDesc();
	}
}
