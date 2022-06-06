package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Boat;
import com.isa.fishingbooker.repository.BoatQuickReservationRepository;
import com.isa.fishingbooker.repository.BoatRepository;
import com.isa.fishingbooker.repository.BoatReservationRepository;

@Service
public class BoatService {

	@Autowired
	private BoatRepository BoatRepository;
	
	@Autowired
	private BoatReservationRepository boatReservationRepository;
	
	@Autowired
	private BoatQuickReservationRepository boatQuickReservationRepository;
	
	
	public List<Boat> getAllBoats(){
		return this.BoatRepository.findAll();
	}
		
	public ResponseEntity<Boat> getBoatById(int boatId)
		throws ResourceNotFoundException{
		Boat boat = BoatRepository.findById(boatId).orElseThrow(() -> new ResourceNotFoundException("Boat not found for this id :: " + boatId));
	 return ResponseEntity.ok().body(boat);
	}
	
	
	public Boat createBoat(Boat boat) {
		return BoatRepository.save(boat);
	}
	
	
	
	public ResponseEntity<Boat> updateBoat(Integer boatId,
			 @RequestBody Boat boatDetails) throws ResourceNotFoundException {
		Boat boat = BoatRepository.findById(boatId)
				.orElseThrow(() -> new ResourceNotFoundException("Boat not found for this id :: " + boatId));
		
		boat.setName(boatDetails.getName());
		boat.setAddress(boatDetails.getAddress());
		boat.setCapacity(boatDetails.getCapacity());
		boat.setLength(boatDetails.getLength());
		boat.setMaxSpeed(boatDetails.getMaxSpeed());
		boat.setMotorPower(boatDetails.getMotorPower());
		boat.setNum_motors(boatDetails.getNum_motors());
		boat.setPrice(boatDetails.getPrice());
		boat.setPromoDescription(boatDetails.getPromoDescription());
		boat.setStatus(boatDetails.getStatus());
		boat.setType(boatDetails.getType());
		boat.setCancellationCondition(boatDetails.getCancellationCondition());
		
		final Boat updatedBoat = BoatRepository.save(boat);
		return ResponseEntity.ok(updatedBoat);
	}
	
	
	public Map<String, Boolean> deleteBoat(int boatId)
			throws ResourceNotFoundException {
		Boat  boat = BoatRepository.findById(boatId)
				.orElseThrow(() -> new ResourceNotFoundException("Boat not found for this id :: " + boatId));

		BoatRepository.delete(boat);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public List<Boat> getAllBoatsSortedByNameAsc(){
		return BoatRepository.getAllBoatsSortedByNameAsc();
	}
	public 	List<Boat> getAllBoatsSortedByNameDesc(){
		return BoatRepository.getAllBoatsSortedByNameDesc();
	}

	public List<Boat> getAllBoatsSortedByAddressAsc(){
		return BoatRepository.getAllBoatsSortedByAddressAsc();
	}
	
	
	public List<Boat> getAllBoatsSortedByAddressDesc(){
		return BoatRepository.getAllBoatsSortedByAddressDesc();
	}
	
	
	public List<Boat> getAllBoatsSortedByPriceAsc(){
		return BoatRepository.getAllBoatsSortedByPriceAsc();
	}
	
	
	public List<Boat> getAllBoatsSortedByPriceDesc(){
		return BoatRepository.getAllBoatsSortedByPriceDesc();
	}
	
	public List<Boat> getBoatsByOwnerAndName(Integer boatOwnerId, String boatName) {
		return BoatRepository.getBoatsByOwnerAndName(boatOwnerId, boatName);
	}
	
	public List<Boat> getBoatsByOwner(Integer boatOwnerId) {
		return BoatRepository.getBoatsByOwner(boatOwnerId);
	}
	
	public Double getWeeklyReservationsByBoat(Integer boatId) {
		double numReservations = boatReservationRepository.CountWeeklyBoatReservations(boatId) + boatQuickReservationRepository.CountWeeklyBoatQuickReservations(boatId);
		return numReservations;
	}
	
	public Double getMonthlyReservationsByBoat(Integer boatId) {
		double numReservations = boatReservationRepository.CountMonthlyBoatReservations(boatId) + boatQuickReservationRepository.CountMonthlyBoatQuickReservations(boatId);
		return numReservations;
	}
	
	public Double getYearlyReservationsByBoat(Integer boatId) {
		double numReservations = boatReservationRepository.CountYearlyBoatReservations(boatId) + boatQuickReservationRepository.CountYearlyBoatQuickReservations(boatId);
		return numReservations;
	}
	
}
