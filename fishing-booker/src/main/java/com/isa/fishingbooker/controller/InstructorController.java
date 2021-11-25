package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.Instructor;
import com.isa.fishingbooker.service.InstructorService;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors() {
		return this.instructorService.getAllInstructors();
	}

	@GetMapping("/instructors/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") int instructorId)
			throws ResourceNotFoundException {
		return instructorService.getInstructorById(instructorId);
	}

	@PostMapping("/instructors")
	public Instructor createInstructor(@RequestBody Instructor instructor) {
		return instructorService.createInstructor(instructor);
	}

	@PutMapping("/instructors/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable(value = "id") int instructorId,
			@RequestBody Instructor instructorDetails) throws ResourceNotFoundException {
		return instructorService.updateInstructor(instructorId, instructorDetails);
	}

	@DeleteMapping("/instructors/{id}")
	public Map<String, Boolean> deleteInstructor(@PathVariable(value = "id") int instructorId)
			throws ResourceNotFoundException {
		return instructorService.deleteInstructor(instructorId);
	}
	@GetMapping("/instructorByEmailAndPassword")
	public Instructor getInstructorByEmailAndPassword(@RequestParam (value="email")  String email, @RequestParam (value="password") String password) {
		return instructorService.getInstructorByEmailAndPassword(email, password);
	}
}
