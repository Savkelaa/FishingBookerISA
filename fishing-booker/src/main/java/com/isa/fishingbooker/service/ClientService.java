package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.isa.fishingbooker.model.Cottage;
import com.isa.fishingbooker.repository.ClientRepository;

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
	
	public List<Client> getClientsByInstructorFishingClassReservations(Integer instructorId)
	{
		return clientRepository.getClientsByInstructorFishingClassReservations(instructorId);
	}
	
	public List<Client> getClientsByInstructorFishingClassQuickReservations(Integer instructorId)
	{
		return clientRepository.getClientsByInstructorFishingClassQuickReservations(instructorId);
	}
	
	public Client createClient(Client client) throws Exception {

		Client existUser = this.clientRepository.findByEmail(client.getEmail());

		if (existUser != null) {
			throw new Exception("Email already exists");
		}

		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(client);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		client.setPassword(passwordEncoder.encode(client.getPassword()));
		return clientRepository.save(client);
	}
	
	
	
	public ResponseEntity<Client> updateClient(Integer clientId,
			 @RequestBody Client clientDetails) throws ResourceNotFoundException {
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
		
		final Client updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
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

