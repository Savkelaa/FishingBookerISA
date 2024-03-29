package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.Admin;
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


	@GetMapping("/instructorsNotDeleted")
	public List<Instructor> getAllInstructorsNotDeleted() {
		return this.instructorService.getAllInstructorsNotDeleted();
	}


	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors() {
		return this.instructorService.getAllInstructors();
	}

	@GetMapping("/numberOfFinishedFishingClassReservationsInstructor")
	public Integer getNuberOfPastFishingClassReservationsByInstructor(@RequestParam (value = "instructorId") Integer instructorId)
	{
		return this.instructorService.getNuberOfPastFishingClassReservationsByInstructor(instructorId);
	}

	@GetMapping("/numberOfFinishedFishingClassQuickReservationsInstuctor")
	public Integer getNuberOfPastFishingClassQuickReservationsByInstructor(@RequestParam (value = "instructorId") Integer instructorId)
	{
		return this.instructorService.getNuberOfPastFishingClassQuickReservationsByInstructor(instructorId);
	}

	@GetMapping("/numberOfFinishedBoatReservationsBoatOwner")
	public Integer getNuberOfPastBoatReservationsByBoatOwner(@RequestParam (value = "boatOwnerId") Integer boatOwnerId)
	{
		return this.instructorService.getNuberOfPastBoatReservationsByBoatOwner(boatOwnerId);
	}

	@GetMapping("/numberOfFinishedBoatQuickReservationsBoatOwner")
	public Integer getNuberOfPastBoatQuickReservationsByBoatOwner(@RequestParam (value = "boatOwnerId") Integer boatOwnerId)
	{
		return this.instructorService.getNuberOfPastBoatQuickReservationsByBoatOwner(boatOwnerId);
	}

	@GetMapping("/numberOfFinishedCottageReservationsCottageOwner")
	public Integer getNuberOfPastCottageReservationsByCottageOwner(@RequestParam (value = "cottageOwner") Integer cottageOwner)
	{
		return this.instructorService.getNuberOfPastCottageReservationsByCottageOwner(cottageOwner);
	}

	@GetMapping("/numberOfFinishedCottageQuickReservationsCottageOwner")
	public Integer getNuberOfPastCottageQuickReservationsByCottageOwner(@RequestParam (value = "cottageOwner") Integer cottageOwner)
	{
		return this.instructorService.getNuberOfPastCottageQuickReservationsByCottageOwner(cottageOwner);
	}


	@GetMapping("/instructorDeleteRequests")
	public List<Instructor> getAllInstructorDeleteRequests() {
		return this.instructorService.getAllInstructorDeleteRequests();
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

	//@PostMapping("/instructors")
	//public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) throws Exception  {
	//	return instructorService.createInstructor(instructor);
	//}


	@PutMapping("/instructors/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable(value = "id") int instructorId,
			@RequestBody Instructor instructorDetails) throws ResourceNotFoundException {
		return instructorService.updateInstructor(instructorId, instructorDetails);
	}

	@PutMapping("/changePasswordInstructor/{id}")
	public ResponseEntity<Instructor> changePasswordInstructor(@PathVariable(value = "id") int instructorId,
													 @RequestBody Instructor instructorDetails) throws ResourceNotFoundException {
		return instructorService.changePasswordInstructor(instructorId,instructorDetails);
	}
	
	@PutMapping("/activateInstructor/{id}")
	public ResponseEntity<Instructor> activateInstructor(@PathVariable(value = "id") int instructorId) throws ResourceNotFoundException {
		return instructorService.activateInstructor(instructorId);
	}
	
	@PutMapping("/removeInstructor/{id}")
	public ResponseEntity<Instructor> removeInstructor(@PathVariable(value = "id") int instructorId,
			@RequestBody Instructor instructorDetails) throws ResourceNotFoundException {
		return instructorService.removeInstructor(instructorId,instructorDetails);
	}

	@PutMapping("/removeInstructorDeleteRequest/{id}")
	public ResponseEntity<Instructor> removeInstructorDeleteRequest(@PathVariable(value = "id") int instructorId,
													   @RequestBody Instructor instructorDetails) throws ResourceNotFoundException {
		return instructorService.removeInstructorDeleteRequest(instructorId,instructorDetails);
	}



	@PutMapping("/instructorSendDeleteRequest/{id}")
	public ResponseEntity<Instructor> instructorSendDeleteRequest(@PathVariable(value = "id") int instructorId,
													   @RequestBody Instructor instructorDetails) throws ResourceNotFoundException {
		return instructorService.instructorSendDeleteRequest(instructorId,instructorDetails);
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
