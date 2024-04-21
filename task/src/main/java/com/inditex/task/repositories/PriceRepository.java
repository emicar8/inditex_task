package com.inditex.task.repositories;

import java.time.LocalDateTime;

import com.inditex.task.models.Price;

public interface PriceRepository{

    Price findPriceByParams(LocalDateTime priceDate, Long brandId, Long productId); 
}
