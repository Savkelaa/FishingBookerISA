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
import com.isa.fishingbooker.model.CottageOwner;
import com.isa.fishingbooker.model.Instructor;
import com.isa.fishingbooker.service.CottageOwnerService;
import com.isa.fishingbooker.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageOwnerController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;

	
	@Autowired
	private CottageOwnerService cottageOwnerService;

	@GetMapping("/cottageOwners")
	public List<CottageOwner> getAllCottageOwners() {
		return this.cottageOwnerService.getAllCottageOwners();
	}
	
	@GetMapping("/cottageOwnerRequests")
	public  List<CottageOwner> getAllCottageOwnerRequests()	
	{
	return this.cottageOwnerService.getAllCottageOwnerRequests();
	}
	
	@PutMapping("/activateCottageOwner/{id}")
	public ResponseEntity<CottageOwner> activateCottageOwner(@PathVariable(value = "id") int cottageOwnerId) throws ResourceNotFoundException {
		return cottageOwnerService.activateCottageOwner(cottageOwnerId);
	}
	
	@PutMapping("/removeCottageOwner/{id}")
	public ResponseEntity<CottageOwner> removeCottageOwner(@PathVariable(value = "id") int cottageOwnerId) throws ResourceNotFoundException {
		return cottageOwnerService.removeCottageOwner(cottageOwnerId);
	}
	
	
	
	@PutMapping("/setCottageOwnerReason/{id}")
	public ResponseEntity<CottageOwner> setCottageOwnerReason(@PathVariable(value = "id") int cottageOwnerId,
			@RequestBody String cottageOwnerDetails) throws ResourceNotFoundException {
		return cottageOwnerService.setCottageOwnerReason(cottageOwnerId, cottageOwnerDetails);
	}


	@GetMapping("/cottageOwners/{id}")
	public ResponseEntity<CottageOwner> getCottageOwnerById(@PathVariable(value = "id") int cottageOwnerId)
			throws ResourceNotFoundException {
		return cottageOwnerService.getCottageOwnerById(cottageOwnerId);
	}

	@PostMapping("/cottageOwners")
	public CottageOwner createCottageOwner(@RequestBody CottageOwner cottageOwner) {
		
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(cottageOwner);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		return cottageOwnerService.createCottageOwner(cottageOwner);
	}

	@PutMapping("/cottageOwners/{id}")
	public ResponseEntity<CottageOwner> updateCottageOwner(@PathVariable(value = "id") int cottageOwnerId,
			@RequestBody CottageOwner cottageOwnerDetails) throws ResourceNotFoundException {
		return cottageOwnerService.updateCottageOwner(cottageOwnerId, cottageOwnerDetails);
	}

	@DeleteMapping("/cottageOwners/{id}")
	public Map<String, Boolean> deleteCottageOwner(@PathVariable(value = "id") int cottageOwnerId)
			throws ResourceNotFoundException {
		return cottageOwnerService.deleteCottageOwner(cottageOwnerId);
	}
	
	@GetMapping("/cottageOwnerByEmailAndPassword")
	public CottageOwner getCottageOwnerByEmailAndPassword(@RequestParam (value="email")  String email, @RequestParam (value="password") String password) {
		return cottageOwnerService.getCottageOwnerByEmailAndPassword(email, password);
	}
}
