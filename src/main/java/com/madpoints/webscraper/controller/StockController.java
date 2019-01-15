package com.madpoints.webscraper.controller;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.entity.UserStock;
import com.madpoints.webscraper.service.StockService;
import com.madpoints.webscraper.service.UserStockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private UserStockService userStockService;
	
	@GetMapping("/list")
	public String getStocks(Model theModel) {
		
		List<Stock> stocks;
		
		stocks = stockService.getStocks();
		
		if (stocks.isEmpty()) {
			
			stocks = scrapeStocks();
			
			for (Stock stock : stocks) {
				
				stockService.saveStock(stock);
			}
			
			stocks = stockService.getStocks();
		}
		
		theModel.addAttribute("stocks", stocks);
		
		return "stock-list";
	}
	
	@GetMapping("/info")
	public String getStockInfo(@RequestParam("stockId") int stockId, Model theModel) {
		
		Stock stock = stockService.getStock(stockId);
		
		theModel.addAttribute("stock", stock);
		
		return "stock-info";
	}
	
	private static List<Stock> scrapeStocks() {
		
		// path to chrome webdriver exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\John\\careerDevs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.finance.yahoo.com/most-active");
		
		List<Stock> stocks = setStocks(driver);
		
		driver.quit();
		
		return stocks;		
	}
	
	private static List<Stock> setStocks(WebDriver driver) {
		
		List<WebElement> stockSymbolElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Symbol']"));
		List<WebElement> stockNameElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Name']"));
		List<WebElement> stockPriceElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Price (Intraday)']"));
//		List<WebElement> stockChangeElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Change']"));
		// escape % char?
//		List<WebElement> stockPercentChangeElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='% Change']"));
//		List<WebElement> stockVolumeElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Volume']"));
//		List<WebElement> stockAvgVolumeElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Avg Vol (3 month)']"));
//		List<WebElement> stockMarketCapElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Market Cap']"));
//		List<WebElement> stockPeRatioElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='PE Ratio (TTM)']"));

		List<Stock> stocks = new ArrayList<Stock>();
		
		int size = stockSymbolElements.size();
		int listIndex = 0;
		
		for (int index = 0; index < size; index++) {
			
			Stock tempStock = new Stock();
			stocks.add(index, tempStock);
			
		}
		
		for (WebElement stockSymbolElement : stockSymbolElements) {
			
			stocks.get(listIndex).setSymbol(stockSymbolElement.getText());
			listIndex++;
			
		}
		
		listIndex = 0;
		
		for (WebElement stockNameElement : stockNameElements) {
			
			stocks.get(listIndex).setName(stockNameElement.getText());
			listIndex++;
			
		}
		
		listIndex = 0;
		
		for (WebElement stockPriceElement : stockPriceElements) {
			
			stocks.get(listIndex).setPrice(stockPriceElement.getText());
			listIndex++;
			
		}
		
//		listIndex = 0;
//		
//		for (WebElement stockChangeElement : stockChangeElements) {
//			
//			stocks.get(listIndex).setChange(stockChangeElement.getText());
//			listIndex++;
//			
//		}
//		
//		listIndex = 0;
//		
//		for (WebElement stockPercentChangeElement : stockPercentChangeElements) {
//			
//			stocks.get(listIndex).setPercentChange(stockPercentChangeElement.getText());
//			listIndex++;
//			
//		}
//		
//		listIndex = 0;
//		
//		for (WebElement stockVolumeElement : stockVolumeElements) {
//			
//			stocks.get(listIndex).setVolume(stockVolumeElement.getText());
//			listIndex++;
//			
//		}
//		
//		listIndex = 0;
//		
//		for (WebElement stockAvgVolumeElement : stockAvgVolumeElements) {
//			
//			stocks.get(listIndex).setAvgVolume(stockAvgVolumeElement.getText());
//			listIndex++;
//			
//		}
//		
//		listIndex = 0;
//		
//		for (WebElement stockMarketCapElement : stockMarketCapElements) {
//			
//			stocks.get(listIndex).setMarketCap(stockMarketCapElement.getText());
//			listIndex++;
//			
//		}
//		
//		listIndex = 0;
//		
//		for (WebElement stockPeRatioElement : stockPeRatioElements) {
//			
//			stocks.get(listIndex).setPeRatio(stockPeRatioElement.getText());
//			listIndex++;
//			
//		}
		
		return stocks;
	}
	
	private void stockTransaction(UserStock userStock) {
		
		UserStock tempUserStock = userStockService.getUserStocks(userStock.getId());
		
		
	}
	
}
