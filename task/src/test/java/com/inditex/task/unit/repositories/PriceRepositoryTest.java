package com.inditex.task.unit.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.inditex.task.repositories.PriceRepository;
import com.inditex.task.models.Price;

@SpringBootTest
public class PriceRepositoryTest {
    
    @Autowired
    private PriceRepository priceRepository;

    @Test
    public void testFindPriceByParams() {
        LocalDateTime priceDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        Price price = priceRepository.findPriceByParams(priceDate, 1L, 35456L);
        assertNotNull(price);
    }
}
