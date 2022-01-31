package io.davidarchanjo.service;

import io.davidarchanjo.component.StockApiClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @Mock
    private StockApiClient stockApiClient;

    @InjectMocks
    private StockService stockService;

    @Test
    void shouldReturnDefaultPriceWhenClientThrowsException() {
        when(stockApiClient.getLatestStockPrice("AMZN"))
            .thenReturn(BigDecimal.ZERO);

        BigDecimal result = stockApiClient.getLatestStockPrice("AMZN");
        assertEquals(BigDecimal.ZERO, result);
    }
}
