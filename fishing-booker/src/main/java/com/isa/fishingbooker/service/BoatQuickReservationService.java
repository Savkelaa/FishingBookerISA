package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.BoatQuickReservation;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.repository.BoatQuickReservationRepository;
import com.isa.fishingbooker.repository.ClientRepository;

@Service
public class BoatQuickReservationService {

	@Autowired
	private BoatQuickReservationRepository BoatQuickReservationRepository;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<BoatQuickReservation> getAllBoatQuickReservations(){
		return this.BoatQuickReservationRepository.findAll();
	}
	
	public List<BoatQuickReservation> getBoatQuickReservationsByOwner(Integer boatOwnerId) {
		return BoatQuickReservationRepository.getBoatQuickReservationsByOwner(boatOwnerId);
	}
	
	public List<BoatQuickReservation> getFreeBoatQuickReservationsByBoat(Integer boatId) {
		return BoatQuickReservationRepository.getFreeBoatQuickReservationsByBoat(boatId);
	}
	
	public List<BoatQuickReservation> getBoatQuickReservationsByBoat(Integer boatId) {
		return BoatQuickReservationRepository.getBoatQuickReservationsByBoat(boatId);
	
	}	
	public ResponseEntity<BoatQuickReservation> getBoatQuickReservationById(int boatQuickReservationId)
		throws ResourceNotFoundException{
		BoatQuickReservation boatQuickReservation = BoatQuickReservationRepository.findById(boatQuickReservationId).orElseThrow(() -> new ResourceNotFoundException("BoatQuickReservation not found for this id :: " + boatQuickReservationId));
	 return ResponseEntity.ok().body(boatQuickReservation);
	}
	public List<BoatQuickReservation> getBoatQuickReservationsByBoatOwner(Integer boatOwnerId)
	{
		return BoatQuickReservationRepository.getBoatQuickReservationsByBoatOwner(boatOwnerId);
	}


	public Double getTotalPriceCompletedBoatQuickReservations(){
		return this.BoatQuickReservationRepository.getTotalPriceCompletedBoatQuickReservations();
	}

	public BoatQuickReservation createBoatQuickReservation(BoatQuickReservation boatQuickReservation) {
		
		List<Client> subscribers = clientRepository.getAllSubscribersByBoat(boatQuickReservation.getBoat().getId());
		for (Client client : subscribers)
		{
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionToSubscribersForNewBoatAction(client);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
		}
		
		return BoatQuickReservationRepository.save(boatQuickReservation);
	}
	
	
	
	public ResponseEntity<BoatQuickReservation> updateBoatQuickReservation(Integer boatQuickReservationId,
			 @RequestBody BoatQuickReservation boatQuickReservationDetails) throws ResourceNotFoundException {
		BoatQuickReservation boatQuickReservation = BoatQuickReservationRepository.findById(boatQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatQuickReservation not found for this id :: " + boatQuickReservationId));
		
		boatQuickReservation.setCancellationCondition(boatQuickReservationDetails.getCancellationCondition());
		boatQuickReservation.setDiscount(boatQuickReservationDetails.getDiscount());
		boatQuickReservation.setStartDate(boatQuickReservationDetails.getStartDate());
		boatQuickReservation.setFinishDate(boatQuickReservationDetails.getFinishDate());
		boatQuickReservation.setMaxPeople(boatQuickReservationDetails.getMaxPeople());
	
		final BoatQuickReservation updatedBoatQuickReservation = BoatQuickReservationRepository.save(boatQuickReservation);
		return ResponseEntity.ok(updatedBoatQuickReservation);
	}
	
	
	public Map<String, Boolean> deleteBoatQuickReservation(int boatQuickReservationId)
			throws ResourceNotFoundException {
		BoatQuickReservation  boatQuickReservation = BoatQuickReservationRepository.findById(boatQuickReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatQuickReservation not found for this id :: " + boatQuickReservationId));

		BoatQuickReservationRepository.delete(boatQuickReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public List<BoatQuickReservation> getAllBoatQuickReservationByClient(Integer clientId){
		return BoatQuickReservationRepository.getAllBoatQuickReservationByClient(clientId);
	}
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClient(Integer clientId){
		return BoatQuickReservationRepository.getAllFinishedBoatQuickReservationByClient(clientId);
	}
	
	public List<BoatQuickReservation> getAllBoatQuickReservationAtPresentByClient(Integer clientId){
		return BoatQuickReservationRepository.getAllBoatQuickReservationAtPresentByClient(clientId);
	}
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDateAsc(Integer clientId){
		return BoatQuickReservationRepository.getAllFinishedBoatQuickReservationByClientSortedByDateAsc(clientId);
	}
	
	
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDateDesc(Integer clientId){
		return BoatQuickReservationRepository.getAllFinishedBoatQuickReservationByClientSortedByDateDesc(clientId);
	}
	
	
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDurationAsc(Integer clientId){
		return BoatQuickReservationRepository.getAllFinishedBoatQuickReservationByClientSortedByDurationAsc(clientId);
	}
	
	
	public List<BoatQuickReservation> getAllFinishedBoatQuickReservationByClientSortedByDurationDesc(Integer clientId){
		return BoatQuickReservationRepository.getAllFinishedBoatQuickReservationByClientSortedByDurationDesc(clientId);
	}
}
