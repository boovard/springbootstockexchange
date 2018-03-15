package com.switchfully.springboot.exchange.api;

import com.switchfully.springboot.exchange.domain.Stock;
import com.switchfully.springboot.exchange.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@ResponseBody
@RequestMapping("/stocks")
public class StockExchangeController {

    private StockService stockService;
    private StockMapper stockMapper;

    @Inject
    public StockExchangeController(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    /**
     * For your information:
     * This method gets called from outside this application
     * (not really, but just imagine it will)
     */
    @GetMapping("/{stockId}")
    public StockDto getStock(@PathVariable String stockId) {
        Stock foundStock = stockService.getStock(stockId);
        return stockMapper.mapToDto(foundStock);
    }

}
