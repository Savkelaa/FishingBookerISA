package com.isa.fishingbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.fishingbooker.model.DateSpanCottage;
import com.isa.fishingbooker.repository.DateSpanCottageRepository;

@Service
public class DateSpanCottageService {

	@Autowired
    private DateSpanCottageRepository dateSpanCottageRepository;

    public List<DateSpanCottage> getAllDateSpans(){
        return this.dateSpanCottageRepository.findAll();
    }

    public List<DateSpanCottage> getDateSpansBycottage(Integer cottageId){
        return dateSpanCottageRepository.getDateSpansByCottage(cottageId);
    }

    public DateSpanCottage createDateSpan(DateSpanCottage dateSpancottage) {
        return dateSpanCottageRepository.save(dateSpancottage);
    }
}
