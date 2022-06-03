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

import com.isa.fishingbooker.model.DateSpanCottage;
import com.isa.fishingbooker.service.DateSpanCottageService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class DateSpanCottageController {

	@Autowired
    private DateSpanCottageService dateSpanCottageService;

    @GetMapping("/dateSpanCottage")
    public List<DateSpanCottage> getAllDateSpans() {
        return this.dateSpanCottageService.getAllDateSpans();
    }

    @GetMapping("/dateSpanCottageByCottage")
    public List<DateSpanCottage> getDateSpansByCottage(@RequestParam (value="cottageId")  Integer cottageId){
        return dateSpanCottageService.getDateSpansBycottage(cottageId);
    }

    @PostMapping("/dateSpanCottage")
    public DateSpanCottage createDateSpan(@RequestBody DateSpanCottage dateSpanCottage) {
        return dateSpanCottageService.createDateSpan(dateSpanCottage);
    }
}
