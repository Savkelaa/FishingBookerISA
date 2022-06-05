package com.isa.fishingbooker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.fishingbooker.model.DateSpanBoat;
import com.isa.fishingbooker.repository.DateSpanBoatRepository;

@Service
public class DateSpanBoatService {

	@Autowired
    private DateSpanBoatRepository dateSpanBoatRepository;

    public List<DateSpanBoat> getAllDateSpans(){
        return this.dateSpanBoatRepository.findAll();
    }

    public List<DateSpanBoat> getDateSpansByboat(Integer boatId){
        return dateSpanBoatRepository.getDateSpansByBoat(boatId);
    }

    public DateSpanBoat createDateSpan(DateSpanBoat dateSpanboat) {
        return dateSpanBoatRepository.save(dateSpanboat);
    }
}

