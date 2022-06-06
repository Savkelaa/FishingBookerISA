package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.model.BoatOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.Cottage;
import com.isa.fishingbooker.repository.ClientRepository;

import javax.transaction.Transactional;

@Service
public class ClientService {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Client> getAllClients(){
		return this.clientRepository.findAll();
	}

	public List<Client> getAllClientDeleteRequests(){
		return this.clientRepository.getAllClientDeleteRequests();
	}
	
	public ResponseEntity<Client> getClientById(int clientId)
		throws ResourceNotFoundException{
		Client client = clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));
	 return ResponseEntity.ok().body(client);
	}




	public Integer getNuberOfPastFishingClassReservationsByClient(Integer clientId)
	{
		return this.clientRepository.getNuberOfPastFishingClassReservationsByClient(clientId);
	}


	public Integer getNuberOfPastFishingClassQuickReservationsByClient(Integer clientId)
	{
		return this.clientRepository.getNuberOfPastFishingClassQuickReservationsByClient(clientId);
	}

	public Integer getNuberOfPastBoatReservationsByClient(Integer clientId)
	{
		return this.clientRepository.getNuberOfPastBoatReservationsByClient(clientId);
	}


	public Integer getNuberOfPastBoatQuickReservationsByClient(Integer clientId)
	{
		return this.clientRepository.getNuberOfPastBoatQuickReservationsByClient(clientId);
	}

	public Integer getNuberOfPastCottageReservationsByClient(Integer clientId)
	{
		return this.clientRepository.getNuberOfPastCottageReservationsByClient(clientId);
	}


	public Integer getNuberOfPastCottageQuickReservationsByClient(Integer clientId)
	{
		return this.clientRepository.getNuberOfPastCottageQuickReservationsByClient(clientId);
	}


	public List<Client> getAllClientRequests()
	{
		return this.clientRepository.getAllClientRequests();
	}


	public ResponseEntity<Client> activateClient(Integer clientId) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));

		client.setActivated("true");

		final Client updatedClient = clientRepository.save(client);

		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsyncAccept(client);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}


		return ResponseEntity.ok(updatedClient);
	}

	public List<Client> getAllSubscribersByFishingClass(Integer fishingClassId)
	{

		return clientRepository.getAllSubscribersByFishingClass(fishingClassId);
	}

	public List<Client> getClientsByInstructorFishingClassReservations(Integer instructorId, String name)
	{
		return clientRepository.getClientsByInstructorFishingClassReservations(instructorId,name);
	}
	
	public List<Client> getClientsByInstructorFishingClassQuickReservations(Integer instructorId, String name)
	{
		return clientRepository.getClientsByInstructorFishingClassQuickReservations(instructorId,name);
	}
	
	public List<Client> getClientsByOwnerBoatQuickReservation(Integer boatOwnerId, String name) {
		return clientRepository.getClientsByOwnerBoatQuickReservations(boatOwnerId, name);
	}
	
	public List<Client> getClientsByOwnerBoatReservation(Integer boatOwnerId, String name) {
		return clientRepository.getClientsByOwnerBoatReservations(boatOwnerId, name);
	}
	
	
	
	public Client createClient(Client client) throws Exception {


		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(client);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		client.setActivated("false");
		client.setDeleted("false");
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		return clientRepository.save(client);
	}


	@Transactional
	public ResponseEntity<Client> updateClient(Integer clientId,
			 @RequestBody Client clientDetails) throws ResourceNotFoundException {
		try{
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));
		
		client.setAddress(clientDetails.getAddress());
		client.setCity(clientDetails.getCity());
		client.setCountry(clientDetails.getCountry());
		client.setEmail(clientDetails.getEmail());
		client.setExplanation(clientDetails.getExplanation());
		client.setName(clientDetails.getName());
		client.setNumber(clientDetails.getNumber());
		client.setPassword(clientDetails.getPassword());
		client.setPenalty(clientDetails.getPenalty());
		client.setSurname(clientDetails.getSurname());
		client.setPoints(clientDetails.getPoints());
		
		final Client updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
		}catch(OptimisticLockingFailureException e)
		{
			return null;
		}
	}

	public ResponseEntity<Client> clientSendDeleteRequest(Integer clientId,
											   @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));

		client.setDeleteRequest("true");
		client.setDeleteReason(clientDetails.getDeleteReason());

		final Client updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
	}

	public ResponseEntity<Client> removeClient(Integer clientId,
														  @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));

		client.setRefusalReason(clientDetails.getRefusalReason());
		client.setDeleted("true");
		client.setDeleteRequest("false");

		final Client updatedClient = clientRepository.save(client);

		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsyncRemove(client);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return ResponseEntity.ok(updatedClient);
	}



	public ResponseEntity<Client> removeClientDeleteRequest(Integer clientId,
											   @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));

		client.setRefusalReason(clientDetails.getRefusalReason());
		client.setDeleteRequest("false");

		final Client updatedClient = clientRepository.save(client);

		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsyncRemove(client);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return ResponseEntity.ok(updatedClient);
	}

	public Map<String, Boolean> deleteClient(int clientId)
			throws ResourceNotFoundException {
		Client  client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));

		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public Client getClientByEmailAndPassword(String email, String password) {
		return clientRepository.getClientByEmailAndPassword(email, password);
	}
	
	public List<Client> getClientsByOwnerCottageReservation(Integer cottageOwnerId) {
		return clientRepository.getClientsByOwnerCottageReservations(cottageOwnerId);
	}
	
	public List<Client> getClientsByOwnerCottageQuickReservation(Integer cottageOwnerId) {
		return clientRepository.getClientsByOwnerCottageQuickReservations(cottageOwnerId);
	}
}

