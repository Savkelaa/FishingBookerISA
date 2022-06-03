package com.isa.fishingbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.model.CottageImage;
import com.isa.fishingbooker.service.CottageImageService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CottageImageController {
	
	@Autowired
	CottageImageService cottageImageService;
	
	@GetMapping("/cottageImage")
	public List<CottageImage> getAllImagesByCottage(@RequestParam (value="cottageId")  Integer cottageId)
	{
		return cottageImageService.getAllByCottage(cottageId);
	}
}
