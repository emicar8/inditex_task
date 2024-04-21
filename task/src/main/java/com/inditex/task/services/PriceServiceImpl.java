package com.inditex.task.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.inditex.task.models.Price;
import com.inditex.task.repositories.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService{

    private PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getApplicablePrice(LocalDateTime priceDate, Long brandId, Long productId) {
        return priceRepository.findPriceByParams(priceDate, brandId, productId);
    }
    
}
