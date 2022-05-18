package com.isa.fishingbooker.service;

import com.isa.fishingbooker.model.BoatRate;
import com.isa.fishingbooker.model.DateSpan;
import com.isa.fishingbooker.model.FishingClass;
import com.isa.fishingbooker.repository.BoatRateRepository;
import com.isa.fishingbooker.repository.DateSpanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DateSpanService {

    @Autowired
    private DateSpanRepository dateSpanRepository;

    public List<DateSpan> getAllDateSpans(){
        return this.dateSpanRepository.findAll();
    }

    public List<DateSpan> getDateSpansByInstructor(Integer instructorId){
        return dateSpanRepository.getDateSpansByInstructor(instructorId);
    }

    public DateSpan createDateSpan(DateSpan dateSpan) {
        return dateSpanRepository.save(dateSpan);
    }

}
