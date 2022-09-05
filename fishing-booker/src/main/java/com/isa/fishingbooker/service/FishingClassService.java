package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.model.*;
import com.isa.fishingbooker.repository.FishingClassQuickReservationRepository;
import com.isa.fishingbooker.repository.FishingClassReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.repository.FishingClassRepository;

@Service
public class FishingClassService {

	@Autowired
	private FishingClassRepository fishingClassRepository;


	@Autowired
	private FishingClassReservationRepository fishingClassReservationRepository;

	@Autowired
	private FishingClassQuickReservationRepository fishingClassQuickReservationRepository;


	
	public List<String> getShortBiographyByFishingClass(Integer fishingClassId)
	{
		return fishingClassRepository.getShortBiographyByFishingClass(fishingClassId);
	}
	
	
	public List<FishingClass> getFishingClassByInstructorAndName(Integer instructorId, String fishingclassName)
	{
		return fishingClassRepository.getFishingClassByInstructorAndName(instructorId, fishingclassName);
	}
	
	public List<FishingClass> getFishingClassByInstructor(Integer instructorId){
		return fishingClassRepository.getFishingClassByInstructor(instructorId);
	}

//	public Double getWeeklyFishingClassReservation(Integer fishingClassId) {
//		double numReservations = fishingClassReservationRepository.CountWeeklyFishingClassReservations(fishingClassId) + fishingClassQuickReservationRepository.CountWeeklyFishingClassQuickReservations(fishingClassId);
//		return numReservations;
//	}
//
//	public Double getMonthlyFishingClassReservation(Integer fishingClassId) {
//		double numReservations = fishingClassReservationRepository.CountMonthlyFishingClassReservations(fishingClassId) + fishingClassQuickReservationRepository.CountMonthlyFishingClassQuickReservations(fishingClassId);
//		return numReservations;
//	}
//
//	public Double getYearlyFishingClassReservation(Integer fishingClassId) {
//		double numReservations = fishingClassReservationRepository.CountYearlyFishingClassReservations(fishingClassId) + fishingClassQuickReservationRepository.CountYearlyFishingClassQuickReservations(fishingClassId);
//		return numReservations;
//	}


	public List<FishingClass> getAllFishingClass(){
		return this.fishingClassRepository.findAll();
	}
		
	public ResponseEntity<FishingClass> getFishingClassById(int fishingClassId)
		throws ResourceNotFoundException{
		FishingClass fishingClass = fishingClassRepository.findById(fishingClassId).orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));
	 return ResponseEntity.ok().body(fishingClass);
	}

//	public Double getWeeklyIncomeByFishingClass(Integer fishingClassId) {
//		double income = 0;
//		if (fishingClassReservationRepository.CountWeeklyIncomeFishingClassReservations(fishingClassId) != null) {
//			income += fishingClassReservationRepository.CountWeeklyIncomeFishingClassReservations(fishingClassId);
//		}
//		if (fishingClassQuickReservationRepository.CountWeeklyIncomeFishingClassReservations(fishingClassId) != null) {
//			income += fishingClassQuickReservationRepository.CountWeeklyIncomeFishingClassReservations(fishingClassId);
//		}
//		return income;
//	}
//
//	public Double getMonthlyIncomeByFishingClass(Integer fishingClassId) {
//		double income = 0;
//		if (fishingClassReservationRepository.CountMonthlyIncomeFishingClassReservations(fishingClassId) != null) {
//			income += fishingClassReservationRepository.CountMonthlyIncomeFishingClassReservations(fishingClassId);
//		}
//		if (fishingClassQuickReservationRepository.CountMonthlyFishingClassQuickReservations(fishingClassId) != null) {
//			income += fishingClassQuickReservationRepository.CountMonthlyFishingClassQuickReservations(fishingClassId);
//		}
//		return income;
//	}

//	public Double getYearlyIncomeByFishingClass(Integer fishingClassId) {
//		double income = 0;
//		if (fishingClassReservationRepository.CountYearlyIncomeFishingClassReservations(fishingClassId) != null) {
//			income += fishingClassReservationRepository.CountYearlyIncomeFishingClassReservations(fishingClassId);
//		}
//		if (fishingClassQuickReservationRepository.CountYearlyIncomeFishingClassReservations(fishingClassId) != null) {
//			income += fishingClassQuickReservationRepository.CountYearlyIncomeFishingClassReservations(fishingClassId);
//		}
//		return income;
//	}


	public FishingClass createFishingClass(FishingClass fishingClass) {
		return fishingClassRepository.save(fishingClass);
	}
	
	
	public ResponseEntity<FishingClass> updateFishingClass(Integer fishingClassId,
			 @RequestBody FishingClass fishingClassDetails) throws ResourceNotFoundException {
		FishingClass fishingClass = fishingClassRepository.findById(fishingClassId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));
		
				
		fishingClass.setName(fishingClassDetails.getName());
		fishingClass.setAddress(fishingClassDetails.getAddress());
		fishingClass.setPromoDescription(fishingClassDetails.getPromoDescription());
		fishingClass.setCancellationCondition(fishingClassDetails.getCancellationCondition());
		fishingClass.setMaxPeople(fishingClassDetails.getMaxPeople());
		fishingClass.setPrice(fishingClassDetails.getPrice());


		Instructor instructor =fishingClassDetails.getInstructor();
		Instructor instructor1 = fishingClass.getInstructor();



		instructor1.setShortBiography(instructor.getShortBiography());

	
		final FishingClass updatedFishingClass = fishingClassRepository.save(fishingClass);
		return ResponseEntity.ok(updatedFishingClass);
	}
	

	public Map<String, Boolean> deleteFishingClass(int fishingClassId)
			throws ResourceNotFoundException {
		FishingClass  fishingClass = fishingClassRepository.findById(fishingClassId)
				.orElseThrow(() -> new ResourceNotFoundException("FishingClass not found for this id :: " + fishingClassId));

		fishingClassRepository.delete(fishingClass);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
