package io.davidarchanjo.service;

import io.davidarchanjo.component.StockApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockApiClient stockApiClient;
    private final Set<String> TECH_COMPANIES = Set.of("AAPL", "MSFT", "GOOG");

    public BigDecimal getLatestPrice(String stockCode) {
        if (TECH_COMPANIES.contains(stockCode)) {
            return BigDecimal.valueOf(Double.MAX_VALUE);
        }

        try {
            return stockApiClient.getLatestStockPrice(stockCode);
        } catch (Exception e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }
}