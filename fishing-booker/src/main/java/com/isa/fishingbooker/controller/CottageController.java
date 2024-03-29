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
import com.isa.fishingbooker.model.Cottage;
import com.isa.fishingbooker.model.CottageReservation;
import com.isa.fishingbooker.service.CottageService;
import com.isa.fishingbooker.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageController {
	
	
	@Autowired
	private CottageService cottageService;

	@GetMapping("/cottages")
	public List<Cottage> getAllCottages() {
		return this.cottageService.getAllCottages();
	}

	@GetMapping("/cottages/{id}")
	public ResponseEntity<Cottage> getCottageById(@PathVariable(value = "id") int cottageId)
			throws ResourceNotFoundException {
		return cottageService.getCottageById(cottageId);
	}

	@PostMapping("/cottages")
	public Cottage createCottage(@RequestBody Cottage cottage) {
		return cottageService.createCottage(cottage);
	}

	@PutMapping("/cottages/{id}")
	public ResponseEntity<Cottage> updateCottage(@PathVariable(value = "id") int cottageId,
			@RequestBody Cottage cottageDetails) throws ResourceNotFoundException {
		return cottageService.updateCottage(cottageId, cottageDetails);
	}

	@DeleteMapping("/cottages/{id}")
	public Map<String, Boolean> deleteCottage(@PathVariable(value = "id") int cottageId)
			throws ResourceNotFoundException {
		return cottageService.deleteCottage(cottageId);
	}
	
	@GetMapping("/cottagesByOwner")
	public List<Cottage> getCottagesByOwner(@RequestParam (value = "cottageOwnerId") Integer cottageOwnerId){
		return cottageService.getCottagesByOwner(cottageOwnerId);
	}
	
	@GetMapping("/cottagesByOwnerAndName")
	public List<Cottage> getCottagesByOwnerAndName(@RequestParam (value = "cottageOwnerId") Integer cottageOwnerId, @RequestParam (value = "cottageName") String cottageName){
		return cottageService.getCottagesByOwnerAndName(cottageOwnerId, cottageName);
	}
	
	@GetMapping("/allCottagesOrderedByAddressAsc")
	public List<Cottage> getAllCottagesSortedByAddressAsc(){
		return cottageService.getAllCottagesSortedByAddressAsc();
	}
	
	@GetMapping("/allCottagesOrderedByNameAsc")
	public List<Cottage> getAllCottagesSortedByNameAsc(){
		return cottageService.getAllCottagesSortedByNameAsc();
	}
	
	@GetMapping("/weeklyCottageReservation")
	public Double getWeeklyCottageReservation(@RequestParam (value = "cottageId") Integer cottageId){
		return cottageService.getWeeklyReservationsByCottage(cottageId);
	}
	
	@GetMapping("/monthlyCottageReservation")
	public Double getMonthlyCottageReservation(@RequestParam (value = "cottageId") Integer cottageId){
		return cottageService.getMonthlyReservationsByCottage(cottageId);
	}
	
	@GetMapping("/yearlyCottageReservation")
	public Double getYearlyCottageReservation(@RequestParam (value = "cottageId") Integer cottageId){
		return cottageService.getYearlyReservationsByCottage(cottageId);
	}
	
	@GetMapping("/allCottagesOrderedByNameDesc")
	public 	List<Cottage> getAllCottagesSortedByNameDesc(){
		return cottageService.getAllCottagesSortedByNameDesc();
	}
	@GetMapping("/allCottagesOrderedByAddressDesc")
	public List<Cottage> getAllCottagesSortedByAddressDesc(){
		return cottageService.getAllCottagesSortedByAddressDesc();
	}
	
	@GetMapping("/allCottagesOrderedByPriceAsc")
	public List<Cottage> getAllCottagesSortedByPriceAsc(){
		return cottageService.getAllCottagesSortedByPriceAsc();
	}
	
	@GetMapping("/allCottagesOrderedByPriceDesc")
	public List<Cottage> getAllCottagesSortedByPriceDesc(){
		return cottageService.getAllCottagesSortedByPriceDesc();
	}
	
	@GetMapping("/yearlyCottageIncome")
	public Double getYearlyCottageIncome(@RequestParam (value = "cottageId") Integer cottageId) {
		return cottageService.getYearlyIncomeByCottage(cottageId);
	}
	
	@GetMapping("/monthlyCottageIncome")
	public Double getMonthlyCottageIncome(@RequestParam (value = "cottageId") Integer cottageId) {
		return cottageService.getMonthlyIncomeByCottage(cottageId);
	}
	
	@GetMapping("/weeklyCottageIncome")
	public Double getWeeklyCottageIncome(@RequestParam (value = "cottageId") Integer cottageId) {
		return cottageService.getWeeklyIncomeByCottage(cottageId);
	}
}
