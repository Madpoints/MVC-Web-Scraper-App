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

import com.madpoints.webscraper.entity.Share;
import com.madpoints.webscraper.entity.Stock;
import com.madpoints.webscraper.entity.User;
import com.madpoints.webscraper.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
//	@Autowired
//	private UserShareService userShareService;
	
	@GetMapping("/list")
	public String getStocks(Model theModel) {
		
		List<Stock> stocks;
		
		stocks = stockService.getStocks();
		
		if (stocks.isEmpty()) {
			
			stocks = scrapeAndSetStocks();
			
			for (Stock stock : stocks) {
				
				stockService.saveStock(stock);
			}
		
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
	
	private static void stockTransaction(User user, Stock stock, Share share) {
		
		user.addStock(stock);
		
	}
	
	private static List<Stock> scrapeAndSetStocks() {
		
		// path to chrome webdriver exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\John\\careerDevs\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.finance.yahoo.com/most-active");
		
		List<WebElement> stockSymbolElements = driver.findElements(By.xpath("//table[@data-reactid='42']//td[@aria-label='Symbol']"));
		List<WebElement> stockNameElements = driver.findElements(By.xpath("//table[@data-reactid='42']//td[@aria-label='Name']"));
		List<WebElement> stockPriceElements = driver.findElements(By.xpath("//table[@data-reactid='42']//td[@aria-label='Price (Intraday)']"));
//		List<WebElement> stockChangeElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Change']"));
		// escape % char?
//		List<WebElement> stockPercentChangeElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='% Change']"));
//		List<WebElement> stockVolumeElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Volume']"));
//		List<WebElement> stockAvgVolumeElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Avg Vol (3 month)']"));
//		List<WebElement> stockMarketCapElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Market Cap']"));
//		List<WebElement> stockPeRatioElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='PE Ratio (TTM)']"));

		List<Stock> stocks = new ArrayList<Stock>();
		
		int index = 0;
		
		for (WebElement stockSymbolElement : stockSymbolElements) {
			
			Stock tempStock = new Stock();
			
			stocks.add(index, tempStock);
			
			stocks.get(index).setSymbol(stockSymbolElement.getText());
			stocks.get(index).setName(stockNameElements.get(index).getText());
			stocks.get(index).setPrice(stockPriceElements.get(index).getText());
//			stocks.get(index).setChange(stockChangeElements.get(index).getText());
//			stocks.get(index).setPercentChange(stockPercentChangeElements.get(index).getText());
//			stocks.get(index).setVolume(stockVolumeElements.get(index).getText());
//			stocks.get(index).setAvgVolume(stockAvgVolumeElements.get(index).getText());
//			stocks.get(index).setMarketCap(stockMarketCapElements.get(index).getText());
//			stocks.get(index).setPeRatio(stockPeRatioElements.get(index).getText());
			
			index++;	
		}
		
		driver.quit();
		
		return stocks;		
	}
	
}
