package com.inditex.task.unit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.inditex.task.models.Price;
import com.inditex.task.repositories.PriceRepository;
import com.inditex.task.services.PriceService;
import com.inditex.task.services.PriceServiceImpl;

public class PriceServiceTest {
    
    private PriceRepository priceRepositoryMock;

    private PriceService priceService;

    @BeforeEach
    void initService() {
        priceRepositoryMock = Mockito.mock(PriceRepository.class);
        priceService = new PriceServiceImpl(priceRepositoryMock);
    }

    @Test
    public void testGetApplicablePrice() {
        Price expected = Price.builder().id(1L).brandId(1L).productId(2L).price(BigDecimal.TEN).build();
        when(priceRepositoryMock.findPriceByParams(any(), any(),any())).thenReturn(expected);
        LocalDateTime priceDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        Price result = priceService.getApplicablePrice(priceDate, 1L, 2L);
        assertEquals(expected, result);
    }
}
