package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.repository.ClientRepository;

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
import com.isa.fishingbooker.model.CottageQuickReservation;
import com.isa.fishingbooker.model.CottageReservation;
import com.isa.fishingbooker.service.CottageQuickReservationService;
import com.isa.fishingbooker.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageQuickReservationController {

	@Autowired
	private CottageQuickReservationService cottageQuickReservationService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/cottageQuickReservations")
	public List<CottageQuickReservation> getAllCottageQuickReservations() {
		return this.cottageQuickReservationService.getAllCottageQuickReservations();
	}
	
	@GetMapping("/cottageQuickReservations2")
	public List<CottageQuickReservation> getAllCottageQuickReservations2() {
		return this.cottageQuickReservationService.getAllCottageQuickReservations2();
	}

	@GetMapping("/priceCompletedCottageQuickReservation")
	public Double getTotalPriceComplatedCottageQuickReservations()
	{
		return cottageQuickReservationService.getTotalPriceComplatedCottageQuickReservations();
	}

	@GetMapping("/cottageQuickReservationCottageOwner")
	public List<CottageQuickReservation> getCottageQuickReservationsByCottageOwner(@RequestParam (value="cottageOwnerId")  Integer cottageOwnerId)
	{
		return cottageQuickReservationService.getCottageQuickReservationsByCottageOwner(cottageOwnerId);
	}

	@GetMapping("/cottageQuickReservations/{id}")
	public ResponseEntity<CottageQuickReservation> getCottageQuickReservationById(@PathVariable(value = "id") int cottageQuickReservationId)
			throws ResourceNotFoundException {
		return cottageQuickReservationService.getCottageQuickReservationById(cottageQuickReservationId);
	}

	@PostMapping("/cottageQuickReservations")
	public CottageQuickReservation createCottageQuickReservation(@RequestBody CottageQuickReservation cottageQuickReservation) {
		
	/*	List<Client> subscribers = clientRepository.getAllSubscribersByBoat(cottageQuickReservation.getCottage().getId());
		for (Client client : subscribers)
		{
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionToSubscribersForNewCottageAction(client);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
		}*/
		return cottageQuickReservationService.createCottageQuickReservation(cottageQuickReservation); 
	}

	@PutMapping("/cottageQuickReservations/{id}")
	public ResponseEntity<CottageQuickReservation> updateCottageQuickReservation(@PathVariable(value = "id") int cottageQuickReservationId,
			@RequestBody CottageQuickReservation cottageQuickReservationDetails) throws ResourceNotFoundException {
		return cottageQuickReservationService.updateCottageQuickReservation(cottageQuickReservationId, cottageQuickReservationDetails);
	}

	@DeleteMapping("/cottageQuickReservations/{id}")
	public Map<String, Boolean> deleteCottageQuickReservation(@PathVariable(value = "id") int cottageQuickReservationId)
			throws ResourceNotFoundException {
		return cottageQuickReservationService.deleteCottageQuickReservation(cottageQuickReservationId);
	}
	@GetMapping("/allQuickReservationsByClient")
	public List<CottageQuickReservation> getAllCottageQuickReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return cottageQuickReservationService.getAllCottageQuickReservationByClient(clientId);
	}
	@GetMapping("/allFinishedQuickReservationsByClient")
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClient(@RequestParam (value="clientId")  Integer clientId){
		return cottageQuickReservationService.getAllFinishedCottageQuickReservationByClient(clientId);
	}
	
	@GetMapping("/allQuickReservationsAtPresentByClient")
	public List<CottageQuickReservation> getAllCottageQuickReservationAtPresentByClient(@RequestParam (value="clientId")  Integer clientId){
		return cottageQuickReservationService.getAllCottageQuickReservationAtPresentByClient(clientId);
	}
	
	@GetMapping("/cottageQuickReservationsByOwner")
	public List<CottageQuickReservation> getCottageQuickReservationsByOwner(@RequestParam (value = "cottageOwnerId") Integer cottageOwnerId){
		return cottageQuickReservationService.getCottageQuickReservationsByOwner(cottageOwnerId);
	}
	
	@GetMapping("/freeCottageQuickReservationsByCottage")
	public List<CottageQuickReservation> getFreeCottageQuickReservationsByCottage(@RequestParam (value = "cottageId") Integer cottageId){
		return cottageQuickReservationService.getFreeCottageQuickReservationsByCottage(cottageId);
	}
	
	@GetMapping("/CottageQuickReservationsByCottage")
	public List<CottageQuickReservation> getCottageQuickReservationsByCottage(@RequestParam (value = "cottageId") Integer cottageId){
		return cottageQuickReservationService.getCottageQuickReservationsByCottage(cottageId);
	}
	
	
	
	
	@GetMapping("/finishedCottageQuickReservationByOwner")
	public List<CottageQuickReservation> getFinishedCottageQuickReservationByOwner(@RequestParam (value = "cottageOwnerId") Integer cottageOwnerId) {
		return cottageQuickReservationService.getFinishedCottageQuickReservationsByOwner(cottageOwnerId);
	}
	@GetMapping("/allFinishedCottageQuickReservationsByClientSortedByDateAsc")
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDateAsc(@RequestParam (value="clientId")  Integer clientId){
		return cottageQuickReservationService.getAllFinishedCottageQuickReservationByClientSortedByDateAsc(clientId);
	}
	@GetMapping("/allFinishedCottageQuickReservationsByClientSortedByDateDesc")
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDateDesc(@RequestParam (value="clientId")  Integer clientId){
		return cottageQuickReservationService.getAllFinishedCottageQuickReservationByClientSortedByDateDesc(clientId);
	}
	@GetMapping("/allFinishedCottageQuickReservationsByClientSortedByDurationAsc")
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDurationAsc(@RequestParam (value="clientId")  Integer clientId){
		return cottageQuickReservationService.getAllFinishedCottageQuickReservationByClientSortedByDurationAsc(clientId);
	}
	@GetMapping("/allFinishedCottageQuickReservationsByClientSortedByDurationDesc")
	public List<CottageQuickReservation> getAllFinishedCottageQuickReservationByClientSortedByDurationDesc(@RequestParam (value="clientId")  Integer clientId){
		return cottageQuickReservationService.getAllFinishedCottageQuickReservationByClientSortedByDurationDesc(clientId);
	}
}
