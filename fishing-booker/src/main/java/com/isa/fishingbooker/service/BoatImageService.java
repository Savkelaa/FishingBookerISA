package com.isa.fishingbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.fishingbooker.model.BoatImage;
import com.isa.fishingbooker.repository.BoatImageRepository;

@Service
public class BoatImageService {

	@Autowired
	private BoatImageRepository boatImageRepository;
	
	public List<BoatImage> getAllByBoat(Integer boatId) {
		return this.boatImageRepository.getAllImagesByBoat(boatId);
	}
	
	public BoatImage create(BoatImage boatImage) {
		return this.boatImageRepository.save(boatImage);
	}
}
