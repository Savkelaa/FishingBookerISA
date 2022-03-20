package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.isa.fishingbooker.service.EmailService;
import com.isa.fishingbooker.service.InstructorService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors() {
		return this.instructorService.getAllInstructors();
	}
	
	@GetMapping("/instructorRequests")
	public List<Instructor> getAllInstructorRequests(){
		return this.instructorService.getAllInstructorRequests();
	}
	
	

	@GetMapping("/instructors/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") int instructorId)
			throws ResourceNotFoundException {
		return instructorService.getInstructorById(instructorId);
	}

	@PostMapping("/instructors")
	public Instructor createInstructor(@RequestBody Instructor instructor) {
		//slanje emaila
				try {
					System.out.println("Thread id: " + Thread.currentThread().getId());
					emailService.sendNotificaitionAsync(instructor);
				}catch( Exception e ){
					logger.info("Greska prilikom slanja emaila: " + e.getMessage());
				}
		
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
	@GetMapping("/allInstructorsOrderedByAddressAsc")
	public List<Instructor> getAllInstructorsSortedByAddressAsc(){
		return instructorService.getAllInstructorsSortedByAddressAsc();
	}
	
	@GetMapping("/allInstructorsOrderedByNameAsc")
	public List<Instructor> getAllInstructorsSortedByNameAsc(){
		return instructorService.getAllInstructorsSortedByNameAsc();
	}
	
	@GetMapping("/allInstructorsOrderedByNameDesc")
	public 	List<Instructor> getAllInstructorsSortedByNameDesc(){
		return instructorService.getAllInstructorsSortedByNameDesc();
	}
	@GetMapping("/allInstructorsOrderedByAddressDesc")
	public List<Instructor> getAllInstructorsSortedByAddressDesc(){
		return instructorService.getAllInstructorsSortedByAddressDesc();
	}
	
	@GetMapping("/allInstructorsOrderedByPriceAsc")
	public List<Instructor> getAllInstructorsSortedByPriceAsc(){
		return instructorService.getAllInstructorsSortedByPriceAsc();
	}
	
	@GetMapping("/allInstructorsOrderedByPriceDesc")
	public List<Instructor> getAllInstructorsSortedByPriceDesc(){
		return instructorService.getAllInstructorsSortedByPriceDesc();
	}
}
