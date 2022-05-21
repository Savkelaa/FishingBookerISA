package com.isa.fishingbooker.controller;

import com.isa.fishingbooker.model.DateSpanInstructor;
import com.isa.fishingbooker.service.DateSpanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class DateSpanController {

    @Autowired
    private DateSpanService dateSpanService;

    @GetMapping("/dateSpan")
    public List<DateSpanInstructor> getAllDateSpans() {
        return this.dateSpanService.getAllDateSpans();
    }

    @GetMapping("/dateSpanInstructor")
    public List<DateSpanInstructor> getDateSpansByInstructor(@RequestParam (value="instructorId")  Integer instructorId){
        return dateSpanService.getDateSpansByInstructor(instructorId);
    }

    @PostMapping("/dateSpan")
    public DateSpanInstructor createDateSpan(@RequestBody DateSpanInstructor dateSpanInstructor) {
        return dateSpanService.createDateSpan(dateSpanInstructor);
    }


}