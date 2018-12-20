package com.madpoints.webscraper.controller;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		
		scrapeStocks();
		
		List<Stock> stocks = stockService.getStocks();
		
		theModel.addAttribute("stocks", stocks);
		
		return "stock-list";
	}
	
	@GetMapping("/info")
	public String getStockInfo(Stock stock, Model theModel) {
		
		theModel.addAttribute("stock", stock);
		
		return "stock-info";
	}
	
	private static List<Stock> scrapeStocks() {
		
		// path to chrome webdriver exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\John\\careerDevs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.finance.yahoo.com/most-active");
		
		driver.quit();
		
		return null;		
	}

}
