package com.inditex.task.unit.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.inditex.task.controllers.PriceController;
import com.inditex.task.models.Price;
import com.inditex.task.services.PriceService;

public class PriceControllerTest {

    private MockMvc mvc;

    private PriceService priceServiceMock;

    private PriceController priceController;

    @BeforeEach
    void initController() {
        priceServiceMock = Mockito.mock(PriceService.class);
        priceController = new PriceController(priceServiceMock);

        mvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }

    @Test
    public void testGetApplicablePrice() throws Exception {
        Price expected = Price.builder().id(1L).brandId(2L).productId(3L).price(BigDecimal.TEN).build();
        when(priceServiceMock.getApplicablePrice(any(), any(), any())).thenReturn(expected);

        LocalDateTime priceDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);

        MockHttpServletResponse response = mvc.perform(
            MockMvcRequestBuilders.get("/prices")
            .param("price_date", priceDate.format(DateTimeFormatter.ISO_DATE_TIME))
            .param("brand_id", "1")
            .param("product_id", "2"))
        .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"productId\":3,\"brandId\":2,\"price\":10,\"priceDate\":\"2020-06-15T10:00:00\"}", response.getContentAsString());
        
    }
    
}
