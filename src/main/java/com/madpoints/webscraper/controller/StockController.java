package com.madpoints.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.service.StockService;

@Controller
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping("/list")
	public String getStocks(Model theModel) {
		
		List<Stock> stocks = stockService.getStocks();
		
		theModel.addAttribute("stocks", stocks);
		
		return "stock-list";
	}

}
