package com.inditex.task.controllers;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.task.controllers.dtos.PriceResponse;
import com.inditex.task.models.Price;
import com.inditex.task.services.PriceService;

@RestController
public class PriceController {

    private PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    
    @GetMapping("/prices")
    public ResponseEntity<PriceResponse> getApplicablePrice(
        @RequestParam("price_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime priceDate, 
        @RequestParam("brand_id") Long brandId, 
        @RequestParam("product_id") Long productId) {
            Price price = priceService.getApplicablePrice(priceDate, brandId, productId);
            PriceResponse response = new PriceResponse(price);
            response.setPriceDate(priceDate);
        return ResponseEntity.ok(response);
    }
}
