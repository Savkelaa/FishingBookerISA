package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.AdditionalService;
import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.repository.AdditionalServiceRepository;

@Service
public class AdditionalServiceService {

	@Autowired
	private AdditionalServiceRepository AdditionalServiceRepository;
	
	public List<AdditionalService> getAdditionalServiceByFishingClass(Integer fishingClassId)
	{
		return AdditionalServiceRepository.getAdditionalServiceByFishingClass(fishingClassId);
	}
	
	
	public List<AdditionalService> getAllAdditionalServices(){
		return this.AdditionalServiceRepository.findAll();
	}
		
	public ResponseEntity<AdditionalService> getAdditionalServiceById(int additionalServiceId)
		throws ResourceNotFoundException{
		AdditionalService additionalService = AdditionalServiceRepository.findById(additionalServiceId).orElseThrow(() -> new ResourceNotFoundException("AdditionalService not found for this id :: " + additionalServiceId));
	 return ResponseEntity.ok().body(additionalService);
	}
	
	
	public AdditionalService createAdditionalService(AdditionalService additionalService) {
		return AdditionalServiceRepository.save(additionalService);
	}
	
	
	
	public ResponseEntity<AdditionalService> updateAdditionalService(Integer additionalServiceId,
			 @RequestBody AdditionalService additionalServiceDetails) throws ResourceNotFoundException {
		AdditionalService additionalService = AdditionalServiceRepository.findById(additionalServiceId)
				.orElseThrow(() -> new ResourceNotFoundException("AdditionalService not found for this id :: " + additionalServiceId));
		
		additionalService.setName(additionalServiceDetails.getName());
		additionalService.setPrice(additionalServiceDetails.getPrice());
		additionalService.setDescription(additionalServiceDetails.getDescription());
		
		final AdditionalService updatedAdditionalService = AdditionalServiceRepository.save(additionalService);
		return ResponseEntity.ok(updatedAdditionalService);
	}
	
	
	public Map<String, Boolean> deleteAdditionalService(int additionalServiceId)
			throws ResourceNotFoundException {
		AdditionalService  additionalService = AdditionalServiceRepository.findById(additionalServiceId)
				.orElseThrow(() -> new ResourceNotFoundException("AdditionalService not found for this id :: " + additionalServiceId));

		AdditionalServiceRepository.delete(additionalService);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
