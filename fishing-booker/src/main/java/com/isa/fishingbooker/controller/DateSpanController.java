package com.isa.fishingbooker.controller;

import com.isa.fishingbooker.model.BoatRate;
import com.isa.fishingbooker.model.DateSpan;
import com.isa.fishingbooker.model.FishingClass;
import com.isa.fishingbooker.service.BoatRateService;
import com.isa.fishingbooker.service.DateSpanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class DateSpanController {

    @Autowired
    private DateSpanService dateSpanService;

    @GetMapping("/dateSpan")
    public List<DateSpan> getAllDateSpans() {
        return this.dateSpanService.getAllDateSpans();
    }

    @GetMapping("/dateSpanInstructor")
    public List<DateSpan> getDateSpansByInstructor(@RequestParam (value="instructorId")  Integer instructorId){
        return dateSpanService.getDateSpansByInstructor(instructorId);
    }

    @PostMapping("/dateSpan")
    public DateSpan createDateSpan(@RequestBody DateSpan dateSpan) {
        return dateSpanService.createDateSpan(dateSpan);
    }


}