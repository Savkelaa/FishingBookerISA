package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.repository.ClientRepository;




@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public List<Client> getAllClients(){
		return this.clientRepository.findAll();
	}
	

	
	public ResponseEntity<Client> getClientById(int clientId)
		throws ResourceNotFoundException{
		Client client = clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));
	 return ResponseEntity.ok().body(client);
	}
	
	@PostMapping("/clients")
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}
	
	/*
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(Long clientId,
			 @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));

		client.(clientDetails.getId());
		client.setProject(clientDetails.getProject());
		client.setTimeSheets(clientDetails.getTimeSheets());
		client.setTeamMember(clientDetails.getTeamMember());
		
				
		
		final Client updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
	}*/
	
	
	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteClient(int clientId)
			throws ResourceNotFoundException {
		Client  client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));

		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
