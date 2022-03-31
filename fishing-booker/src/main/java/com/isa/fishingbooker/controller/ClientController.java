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
import com.isa.fishingbooker.service.ClientService;
import com.isa.fishingbooker.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ClientController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;

	@PostMapping("/signup/async")
	public String signUpAsync(Client user){

		//slanje emaila
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(user);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return "success";
	}

	@Autowired 
	private ClientService clientService;

	@GetMapping("/clients")
	public List<Client> getAllClients(){
		return this.clientService.getAllClients();
	}

	@GetMapping("/clientDeleteRequests")
	public List<Client> getAllClientDeleteRequests(){
		return this.clientService.getAllClientDeleteRequests();
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value= "id") int clientId)
		throws ResourceNotFoundException{
		return clientService.getClientById(clientId);
	}
	
	@GetMapping("/clientsByInstructorFishingClassReservations")
	public List<Client> getClientsByInstructorFishingClassReservations(@RequestParam (value = "instructorId") Integer instructorId)
	{
		return clientService.getClientsByInstructorFishingClassReservations(instructorId);
	}
	
	@GetMapping("/clientsByInstructorQuickFishingClassReservations")
	public List<Client> getClientsByInstructorFishingClassQuickReservations(@RequestParam (value = "instructorId") Integer instructorId)
	{
		return clientService.getClientsByInstructorFishingClassQuickReservations(instructorId);
	}
	
	@PostMapping("/clients")
	public Client createClient(@RequestBody Client client) throws Exception {
		return clientService.createClient(client);
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") int clientId,
			 @RequestBody Client clientDetails) throws ResourceNotFoundException {
		return clientService.updateClient(clientId, clientDetails);
	}

	@PutMapping("/clientSendDeleteRequest/{id}")
	public ResponseEntity<Client> clientSendDeleteRequest(@PathVariable(value = "id") int clientId,
											   @RequestBody Client clientDetails) throws ResourceNotFoundException {
		return clientService.clientSendDeleteRequest(clientId, clientDetails);
	}
	
	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") int clientId)
			throws ResourceNotFoundException {
		return clientService.deleteClient(clientId);
	}
	
	@GetMapping("/clientByEmailAndPassword")
	public Client getClientByEmailAndPassword(@RequestParam (value="email")  String email, @RequestParam (value="password") String password) {
		return clientService.getClientByEmailAndPassword(email, password);
	}
	
	@GetMapping("/clientsByOwnerCottageReservations")
	public List<Client> getClientByOwnerCottageReservations(@RequestParam (value = "cottageOwnerId") Integer cottageOwnerId) {
		return clientService.getClientsByOwnerCottageReservation(cottageOwnerId);
	}
	
	@GetMapping("/clientsByOwnerCottageQuickReservations")
	public List<Client> getClientByOwnerCottageQuickReservations(@RequestParam (value = "cottageOwnerId") Integer cottageOwnerId) {
		return clientService.getClientsByOwnerCottageQuickReservation(cottageOwnerId);
	}

}

