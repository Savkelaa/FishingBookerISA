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
import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.CottageOwner;
import com.isa.fishingbooker.model.Instructor;
import com.isa.fishingbooker.service.BoatOwnerService;
import com.isa.fishingbooker.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatOwnerController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private BoatOwnerService boatOwnerService;

	@GetMapping("/boatOwners")
	public List<BoatOwner> getAllBoatOwners() {
		return this.boatOwnerService.getAllBoatOwners();
	}
	
	@GetMapping("/boatOwnerRequests")
	public List<BoatOwner> getAllBoatOwnerRequests()
	{
		return this.boatOwnerService.getAllBoatOwnerRequests();
	}
	
	@PutMapping("/activateBoatOwner/{id}")
	public ResponseEntity<BoatOwner> activateBoatOwner(@PathVariable(value = "id") int boatOwnerId) throws ResourceNotFoundException {
		return boatOwnerService.activateBoatOwner(boatOwnerId);
	}
	
	@PutMapping("/removeBoatOwner/{id}")
	public ResponseEntity<BoatOwner> removeBoatOwner(@PathVariable(value = "id") int boatOwnerId,
			@RequestBody BoatOwner boatOnwnerDetails) throws ResourceNotFoundException {
		return boatOwnerService.removeBoatOwner(boatOwnerId, boatOnwnerDetails);
	}

	@GetMapping("/boatOwners/{id}")
	public ResponseEntity<BoatOwner> getBoatOwnerById(@PathVariable(value = "id") int boatOwnerId)
			throws ResourceNotFoundException {
		return boatOwnerService.getBoatOwnerById(boatOwnerId);
	}

	@PostMapping("/boatOwners")
	public BoatOwner createBoatOwner(@RequestBody BoatOwner boatOwner) {
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(boatOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		return boatOwnerService.createBoatOwner(boatOwner);
	}

	@PutMapping("/boatOwners/{id}")
	public ResponseEntity<BoatOwner> updateBoatOwner(@PathVariable(value = "id") int boatOwnerId,
			@RequestBody BoatOwner boatOwnerDetails) throws ResourceNotFoundException {
		return boatOwnerService.updateBoatOwner(boatOwnerId, boatOwnerDetails);
	}

	@DeleteMapping("/boatOwners/{id}")
	public Map<String, Boolean> deleteBoatOwner(@PathVariable(value = "id") int boatOwnerId)
			throws ResourceNotFoundException {
		return boatOwnerService.deleteBoatOwner(boatOwnerId);
	}
	
	@GetMapping("/boatOwnerByEmailAndPassword")
	public BoatOwner getBoatOwnerByEmailAndPassword(@RequestParam (value="email")  String email, @RequestParam (value="password") String password) {
		return boatOwnerService.getBoatOwnerByEmailAndPassword(email, password);
	}
}
