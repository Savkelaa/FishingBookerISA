package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Cottage;
import com.isa.fishingbooker.repository.CottageQuickReservationRepository;
import com.isa.fishingbooker.repository.CottageRepository;
import com.isa.fishingbooker.repository.CottageReservationRepository;

@Service
public class CottageService {

	@Autowired
	private CottageRepository CottageRepository;
	
	@Autowired
	private CottageReservationRepository cottageReservationRepository;
	
	@Autowired
	private CottageQuickReservationRepository cottageQuickReservationRepository;
	
	public List<Cottage> getAllCottages(){
		return this.CottageRepository.findAll();
	}
		
	public ResponseEntity<Cottage> getCottageById(int cottageId)
		throws ResourceNotFoundException{
		Cottage cottage = CottageRepository.findById(cottageId).orElseThrow(() -> new ResourceNotFoundException("Cottage not found for this id :: " + cottageId));
	 return ResponseEntity.ok().body(cottage);
	}
	

	public Cottage createCottage(Cottage cottage) {
		return CottageRepository.save(cottage);
	}
	

	public ResponseEntity<Cottage> updateCottage(Integer cottageId,
			 @RequestBody Cottage cottageDetails) throws ResourceNotFoundException {
		Cottage cottage = CottageRepository.findById(cottageId)
				.orElseThrow(() -> new ResourceNotFoundException("Cottage not found for this id :: " + cottageId));
		
		if (cottageDetails.getName() != "") {
			cottage.setName(cottageDetails.getName());
		}
		if (cottageDetails.getAddress() != "") {
			cottage.setAddress(cottageDetails.getAddress());
		}
		if (cottageDetails.getPrice() != 0) {
			cottage.setPrice(cottageDetails.getPrice());
		}
		if (cottageDetails.getPromoDescription() != "") {
			cottage.setPromoDescription(cottageDetails.getPromoDescription());
		}
		
		final Cottage updatedCottage = CottageRepository.save(cottage);
		return ResponseEntity.ok(updatedCottage);
	}
	

	public Map<String, Boolean> deleteCottage(int cottageId)
			throws ResourceNotFoundException {
		Cottage  cottage = CottageRepository.findById(cottageId)
				.orElseThrow(() -> new ResourceNotFoundException("Cottage not found for this id :: " + cottageId));

		CottageRepository.delete(cottage);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public List<Cottage> getCottagesByOwnerAndName(Integer cottageOwnerId, String cottageName) {
		return CottageRepository.getCottagesByOwnerAndName(cottageOwnerId, cottageName);
	}
	
	public Double getWeeklyReservationsByCottage(Integer cottageId) {
		double numReservations = cottageReservationRepository.CountWeeklyCottageReservations(cottageId) + cottageQuickReservationRepository.CountWeeklyCottageQuickReservations(cottageId);
		return numReservations;
	}
	
	public Double getMonthlyReservationsByCottage(Integer cottageId) {
		double numReservations = cottageReservationRepository.CountMonthlyCottageReservations(cottageId) + cottageQuickReservationRepository.CountMonthlyCottageQuickReservations(cottageId);
		return numReservations;
	}
	
	public Double getYearlyReservationsByCottage(Integer cottageId) {
		double numReservations = cottageReservationRepository.CountYearlyCottageReservations(cottageId) + cottageQuickReservationRepository.CountYearlyCottageQuickReservations(cottageId);
		return numReservations;
	}
	
	public List<Cottage> getCottagesByOwner(Integer cottageOwnerId) {
		return CottageRepository.getCottagesByOwner(cottageOwnerId);
	}
	
	public List<Cottage> getAllCottagesSortedByNameAsc(){
		return CottageRepository.getAllCottagesSortedByNameAsc();
	}
	public 	List<Cottage> getAllCottagesSortedByNameDesc(){
		return CottageRepository.getAllCottagesSortedByNameDesc();
	}

	public List<Cottage> getAllCottagesSortedByAddressAsc(){
		return CottageRepository.getAllCottagesSortedByAddressAsc();
	}
	
	
	public List<Cottage> getAllCottagesSortedByAddressDesc(){
		return CottageRepository.getAllCottagesSortedByAddressDesc();
	}
	
	
	public List<Cottage> getAllCottagesSortedByPriceAsc(){
		return CottageRepository.getAllCottagesSortedByPriceAsc();
	}
	
	
	public List<Cottage> getAllCottagesSortedByPriceDesc(){
		return CottageRepository.getAllCottagesSortedByPriceDesc();
	}
}
