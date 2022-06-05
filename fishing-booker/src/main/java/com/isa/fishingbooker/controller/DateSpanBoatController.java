package com.isa.fishingbooker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.model.DateSpanBoat;
import com.isa.fishingbooker.service.DateSpanBoatService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class DateSpanBoatController {

	@Autowired
    private DateSpanBoatService dateSpanBoatService;

    @GetMapping("/dateSpanBoat")
    public List<DateSpanBoat> getAllDateSpans() {
        return this.dateSpanBoatService.getAllDateSpans();
    }

    @GetMapping("/dateSpanBoatByBoat")
    public List<DateSpanBoat> getDateSpansByBoat(@RequestParam (value="boatId")  Integer boatId){
        return dateSpanBoatService.getDateSpansByboat(boatId);
    }

    @PostMapping("/dateSpanBoat")
    public DateSpanBoat createDateSpan(@RequestBody DateSpanBoat dateSpanBoat) {
        return dateSpanBoatService.createDateSpan(dateSpanBoat);
    }
}
