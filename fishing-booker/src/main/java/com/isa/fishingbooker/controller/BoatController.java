package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

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
import com.isa.fishingbooker.model.Boat;
import com.isa.fishingbooker.model.Boat;
import com.isa.fishingbooker.service.BoatService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatController {

	@Autowired
	private BoatService boatService;

	@GetMapping("/boats")
	public List<Boat> getAllBoats() {
		return this.boatService.getAllBoats();
	}

	@GetMapping("/boats/{id}")
	public ResponseEntity<Boat> getBoatById(@PathVariable(value = "id") int boatId)
			throws ResourceNotFoundException {
		return boatService.getBoatById(boatId);
	}

	@PostMapping("/boats")
	public Boat createBoat(@RequestBody Boat boat) {
		return boatService.createBoat(boat);
	}

	@PutMapping("/boats/{id}")
	public ResponseEntity<Boat> updateBoat(@PathVariable(value = "id") int boatId,
			@RequestBody Boat boatDetails) throws ResourceNotFoundException {
		return boatService.updateBoat(boatId, boatDetails);
	}

	@DeleteMapping("/boats/{id}")
	public Map<String, Boolean> deleteBoat(@PathVariable(value = "id") int boatId)
			throws ResourceNotFoundException {
		return boatService.deleteBoat(boatId);
	}
	@GetMapping("/allBoatsOrderedByAddressAsc")
	public List<Boat> getAllBoatsSortedByAddressAsc(){
		return boatService.getAllBoatsSortedByAddressAsc();
	}
	
	@GetMapping("/allBoatsOrderedByNameAsc")
	public List<Boat> getAllBoatsSortedByNameAsc(){
		return boatService.getAllBoatsSortedByNameAsc();
	}
	
	@GetMapping("/allBoatsOrderedByNameDesc")
	public 	List<Boat> getAllBoatsSortedByNameDesc(){
		return boatService.getAllBoatsSortedByNameDesc();
	}
	@GetMapping("/allBoatsOrderedByAddressDesc")
	public List<Boat> getAllBoatsSortedByAddressDesc(){
		return boatService.getAllBoatsSortedByAddressDesc();
	}
	
	@GetMapping("/allBoatsOrderedByPriceAsc")
	public List<Boat> getAllBoatsSortedByPriceAsc(){
		return boatService.getAllBoatsSortedByPriceAsc();
	}
	
	@GetMapping("/allBoatsOrderedByPriceDesc")
	public List<Boat> getAllBoatsSortedByPriceDesc(){
		return boatService.getAllBoatsSortedByPriceDesc();
	}
	
	@GetMapping("/boatsByOwner")
	public List<Boat> getBoatsByOwner(@RequestParam (value = "boatOwnerId") Integer boatOwnerId){
		return boatService.getBoatsByOwner(boatOwnerId);
	}
	
	@GetMapping("/boatsByOwnerAndName")
	public List<Boat> getBoatsByOwnerAndName(@RequestParam (value = "boatOwnerId") Integer boatOwnerId, @RequestParam (value = "boatName") String boatName){
		return boatService.getBoatsByOwnerAndName(boatOwnerId, boatName);
	}
	
	@GetMapping("/weeklyBoatReservation")
	public Double getWeeklyBoatReservation(@RequestParam (value = "boatId") Integer boatId){
		return boatService.getWeeklyReservationsByBoat(boatId);
	}
	
	@GetMapping("/monthlyBoatReservation")
	public Double getMonthlyBoatReservation(@RequestParam (value = "boatId") Integer boatId){
		return boatService.getMonthlyReservationsByBoat(boatId);
	}
	
	@GetMapping("/yearlyBoatReservation")
	public Double getYearlyBoatReservation(@RequestParam (value = "boatId") Integer boatId){
		return boatService.getYearlyReservationsByBoat(boatId);
	}
	
	@GetMapping("/yearlyBoatIncome")
	public Double getYearlyBoatIncome(@RequestParam (value = "boatId") Integer boatId) {
		return boatService.getYearlyIncomeByBoat(boatId);
	}
	
	@GetMapping("/monthlyBoatIncome")
	public Double getMonthlyBoatIncome(@RequestParam (value = "boatId") Integer boatId) {
		return boatService.getMonthlyIncomeByBoat(boatId);
	}
	
	@GetMapping("/weeklyBoatIncome")
	public Double getWeeklyBoatIncome(@RequestParam (value = "boatId") Integer boatId) {
		return boatService.getWeeklyIncomeByBoat(boatId);
	}
	
	
	
}
