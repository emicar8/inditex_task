package com.inditex.task.integration.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.task.controllers.dtos.PriceResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;


    private static Stream<Arguments> integrationTests_parameters() {
        // Test 1 data
        LocalDateTime test1Date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        PriceResponse expectedResponse1 = new PriceResponse(35455L, 1L, BigDecimal.valueOf(3550, 2), test1Date);
        // Test 2 data
        LocalDateTime test2Date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        PriceResponse expectedResponse2 = new PriceResponse(35455L, 1L, BigDecimal.valueOf(2545, 2), test2Date);
        // Test 3 data
        LocalDateTime test3Date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        PriceResponse expectedResponse3 = new PriceResponse(35455L, 1L, BigDecimal.valueOf(3550, 2), test3Date);
        // Test 4 data
        LocalDateTime test4Date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        PriceResponse expectedResponse4 = new PriceResponse(35455L, 1L, BigDecimal.valueOf(3050, 2), test4Date);
        // Test 5 data
        LocalDateTime test5Date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        PriceResponse expectedResponse5 = new PriceResponse(35455L, 1L, BigDecimal.valueOf(3895, 2), test5Date);

        return Stream.of(
            Arguments.of(test1Date, expectedResponse1),
            Arguments.of(test2Date, expectedResponse2),
            Arguments.of(test3Date, expectedResponse3),
            Arguments.of(test4Date, expectedResponse4),
            Arguments.of(test5Date, expectedResponse5)
        );
    }

    @ParameterizedTest
    @MethodSource("integrationTests_parameters") 
    public void integrationTests(LocalDateTime priceDate, PriceResponse expectedResponse) throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
        .param("price_date", priceDate.format(DateTimeFormatter.ISO_DATE_TIME))
        .param("brand_id", "1")
        .param("product_id", "35455")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        PriceResponse priceResponse = mapper.readValue(response.getContentAsString(),PriceResponse.class);
        assertEquals(expectedResponse, priceResponse);
    }
}
