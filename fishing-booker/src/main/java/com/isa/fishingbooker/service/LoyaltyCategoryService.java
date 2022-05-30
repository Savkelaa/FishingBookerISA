package com.isa.fishingbooker.service;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.InstructorReport;
import com.isa.fishingbooker.model.LoyaltyCategory;
import com.isa.fishingbooker.repository.InstructorReportRepository;
import com.isa.fishingbooker.repository.LoyaltyCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoyaltyCategoryService {

    @Autowired
    private LoyaltyCategoryRepository loyaltyCategoryRepository;

    public List<LoyaltyCategory> getAllLoyaltyCategories(){
        return this.loyaltyCategoryRepository.findAll();
    }

    public List<LoyaltyCategory> getLoyaltyCategoryByClientPoints(Integer clientPoints){
        return this.loyaltyCategoryRepository.getLoyaltyCategoryByClientPoints(clientPoints);
    }


    public LoyaltyCategory createLoyaltyCategory(LoyaltyCategory loyaltyCategory) {
        return loyaltyCategoryRepository.save(loyaltyCategory);
    }



}
