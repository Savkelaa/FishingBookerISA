package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.service.ClientService;


@RestController
@RequestMapping("/api/v1")
public class ClientController {
	
	@Autowired 
	private ClientService clientService;
	
	
	@GetMapping("/clients")
	public List<Client> getAllClients(){
		return this.clientService.getAllClients();
	}
	

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value= "id") int clientId)
		throws ResourceNotFoundException{
		return clientService.getClientById(clientId);
	}
	
	@PostMapping("/clients")
	public Client createClient(@RequestBody Client client) {
		return clientService.createClient(client);
	}
	
	/*
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long clientId,
			 @RequestBody Client clientDetails) throws ResourceNotFoundException {
		return clientService.updateClient(clientId, clientDetails);
	}
	*/
	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") int clientId)
			throws ResourceNotFoundException {
		return clientService.deleteClient(clientId);
	}
	
	
}
