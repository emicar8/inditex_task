package com.inditex.task.services;

import java.time.LocalDateTime;

import com.inditex.task.models.Price;

public interface PriceService {
    

    public Price getApplicablePrice(LocalDateTime priceDate, Long brandId, Long productId);
}
