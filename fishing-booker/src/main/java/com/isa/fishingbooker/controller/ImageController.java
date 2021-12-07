package com.isa.fishingbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.model.Image;
import com.isa.fishingbooker.repository.ImageRepository;
import com.isa.fishingbooker.service.FishingClassQuickReservationService;
import com.isa.fishingbooker.service.ImageService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@GetMapping("/images")
	public List<Image> getAllImagesByFishingClass(@RequestParam (value="fishingClassId")  Integer fishingClassId)
	{
		return imageService.getAllImagesByFishingClass(fishingClassId);
	}
	
	
}

