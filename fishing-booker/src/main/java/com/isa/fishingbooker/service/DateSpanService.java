package com.isa.fishingbooker.service;

import com.isa.fishingbooker.model.DateSpanInstructor;
import com.isa.fishingbooker.repository.DateSpanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateSpanService {

    @Autowired
    private DateSpanRepository dateSpanRepository;

    public List<DateSpanInstructor> getAllDateSpans(){
        return this.dateSpanRepository.findAll();
    }

    public List<DateSpanInstructor> getDateSpansByInstructor(Integer instructorId){
        return dateSpanRepository.getDateSpansByInstructor(instructorId);
    }

    public DateSpanInstructor createDateSpan(DateSpanInstructor dateSpanInstructor) {
        return dateSpanRepository.save(dateSpanInstructor);
    }

}
