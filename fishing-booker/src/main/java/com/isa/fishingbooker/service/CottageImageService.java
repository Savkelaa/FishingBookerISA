package com.isa.fishingbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.fishingbooker.model.CottageImage;
import com.isa.fishingbooker.repository.CottageImageRepository;

@Service
public class CottageImageService {

	@Autowired
	private CottageImageRepository cottageImageRepository;
	
	public List<CottageImage> getAllByCottage(Integer cottageId) {
		return this.cottageImageRepository.getAllImagesByCottage(cottageId);
	}
	
	public CottageImage create(CottageImage cottageImage) {
		return this.cottageImageRepository.save(cottageImage);
	}
}
