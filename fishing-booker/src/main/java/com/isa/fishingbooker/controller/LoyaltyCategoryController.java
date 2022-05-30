package com.isa.fishingbooker.controller;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.InstructorComplaint;
import com.isa.fishingbooker.model.LoyaltyCategory;
import com.isa.fishingbooker.service.LoyaltyCategoryService;
import com.isa.fishingbooker.service.impl.InstructorComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class LoyaltyCategoryController {

    @Autowired
    private LoyaltyCategoryService loyaltyCategoryService;

    @GetMapping("/loyaltyCategories")
    public List<LoyaltyCategory> getAllLoyaltyCategories() {
        return this.loyaltyCategoryService.getAllLoyaltyCategories();
    }


    @PostMapping("/loyaltyCategories")
    public LoyaltyCategory createLoyaltyCategory(@RequestBody LoyaltyCategory loyaltyCategory) {
        return loyaltyCategoryService.createLoyaltyCategory(loyaltyCategory);
    }


}
