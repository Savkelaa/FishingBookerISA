package com.isa.fishingbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.model.BoatImage;
import com.isa.fishingbooker.service.BoatImageService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class BoatImageController {
	
	@Autowired
	BoatImageService boatImageService;
	
	@GetMapping("/boatImage")
	public List<BoatImage> getAllImagesByBoat(@RequestParam (value="boatId")  Integer boatId)
	{
		return boatImageService.getAllByBoat(boatId);
	}
}
