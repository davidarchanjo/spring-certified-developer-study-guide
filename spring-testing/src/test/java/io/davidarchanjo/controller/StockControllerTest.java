package io.davidarchanjo.controller;

import io.davidarchanjo.service.StockService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StockController.class)
class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService stockService;

    @Test
    @SneakyThrows
    void shouldReturnStockPriceFromService() {
        when(stockService.getLatestPrice("AMZN"))
            .thenReturn(BigDecimal.TEN);

        mockMvc.perform(get("/api/stocks?stockCode=AMZN"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", is(10)));
    }

}
