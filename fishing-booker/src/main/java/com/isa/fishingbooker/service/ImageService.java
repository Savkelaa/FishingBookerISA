package com.isa.fishingbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.fishingbooker.model.FishingClassReservation;
import com.isa.fishingbooker.model.Image;
import com.isa.fishingbooker.repository.FishingClassRateRepository;
import com.isa.fishingbooker.repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	
	public List<Image> getAllImagesByFishingClass(Integer fishingClassId)
	{
		return imageRepository.getAllImagesByFishingClass(fishingClassId);
	}
}

