package com.isa.fishingbooker.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.AdditionalService;
import com.isa.fishingbooker.model.Boat;
import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.model.BoatReservation;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.BoatReservation;
import com.isa.fishingbooker.repository.BoatOwnerRepository;
import com.isa.fishingbooker.repository.BoatRepository;
import com.isa.fishingbooker.repository.BoatReservationRepository;
import com.isa.fishingbooker.repository.ClientRepository;

@Service
public class BoatReservationService {

	@Autowired
	private BoatReservationRepository BoatReservationRepository;
	
	private BoatRepository boatRepository;
	
	private ClientRepository clientRepo;
	
	private BoatOwnerRepository ownerRepo;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	public List<BoatReservation> getAllBoatReservations(){
		return this.BoatReservationRepository.findAll();
	}
		
	public ResponseEntity<BoatReservation> getBoatReservationById(int boatReservationId)
		throws ResourceNotFoundException{
		BoatReservation boatReservation = BoatReservationRepository.findById(boatReservationId).orElseThrow(() -> new ResourceNotFoundException("BoatReservation not found for this id :: " + boatReservationId));
	 return ResponseEntity.ok().body(boatReservation);
	}

	public Double getTotalPriceCompletedBoatReservations(){
		return this.BoatReservationRepository.getTotalPriceCompletedBoatReservations();
	}


	public List<BoatReservation> getBoatReservationsByBoatOwner(Integer boatOwnerId)
	{
		return BoatReservationRepository.getBoatReservationsByBoatOwner(boatOwnerId);
	}
	
	public List<BoatReservation> getBoatReservationsByOwner(Integer boatOwnerId) {
		return BoatReservationRepository.getBoatReservationsByOwner(boatOwnerId);
	}

	@Transactional
	public BoatReservation createBoatReservation(BoatReservation boatReservation) {
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionForBoatReservation(boatReservation.getClient(), boatReservation);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		return BoatReservationRepository.save(boatReservation);
	}
	
	

	public ResponseEntity<BoatReservation> updateBoatReservation(Integer boatReservationId,
			 @RequestBody BoatReservation boatReservationDetails) throws ResourceNotFoundException {
		BoatReservation boatReservation = BoatReservationRepository.findById(boatReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatReservation not found for this id :: " + boatReservationId));
		
		boatReservation.setCancellationCondition(boatReservationDetails.getCancellationCondition());
		boatReservation.setStartDate(boatReservationDetails.getStartDate());
		boatReservation.setFinishDate(boatReservationDetails.getFinishDate());
		boatReservation.setMaxPeople(boatReservationDetails.getMaxPeople());
	
		final BoatReservation updatedBoatReservation = BoatReservationRepository.save(boatReservation);
		return ResponseEntity.ok(updatedBoatReservation);
	}
	

	public Map<String, Boolean> deleteBoatReservation(int boatReservationId)
			throws ResourceNotFoundException {
		BoatReservation  boatReservation = BoatReservationRepository.findById(boatReservationId)
				.orElseThrow(() -> new ResourceNotFoundException("BoatReservation not found for this id :: " + boatReservationId));

		BoatReservationRepository.delete(boatReservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public List<BoatReservation> getAllBoatReservationByClient(Integer clientId){
		return BoatReservationRepository.getAllBoatReservationByClient(clientId);
	}
	
	public List<BoatReservation> getAllFinishedBoatReservationByClient(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClient(clientId);
	}
	
	public List<BoatReservation> getAllBoatReservationAtPresentByClient(Integer clientId){
		return BoatReservationRepository.getAllBoatReservationAtPresentByClient(clientId);
	}
	
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDateAsc(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClientSortedByDateAsc(clientId);
	}
	
	
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDateDesc(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClientSortedByDateDesc(clientId);
	}
	
	
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDurationAsc(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClientSortedByDurationAsc(clientId);
	}
	
	
	public List<BoatReservation> getAllFinishedBoatReservationByClientSortedByDurationDesc(Integer clientId){
		return BoatReservationRepository.getAllFinishedBoatReservationByClientSortedByDurationDesc(clientId);
	}
	
	
	
}