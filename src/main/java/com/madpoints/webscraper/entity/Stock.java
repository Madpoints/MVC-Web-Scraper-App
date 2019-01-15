package com.madpoints.webscraper.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private String price;
	
//	private String change;
//	private String percentChange;
//	private String volume;
//	private String avgVolume;
//	private String marketCap;
//	private String peRatio;
	
	@OneToMany(mappedBy="user_stock",
			cascade={CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<UserStock> userStocks;
	
	public Stock() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

//	public String getChange() {
//		return change;
//	}
//
//	public void setChange(String change) {
//		this.change = change;
//	}
//
//	public String getPercentChange() {
//		return percentChange;
//	}
//
//	public void setPercentChange(String percentChange) {
//		this.percentChange = percentChange;
//	}
//
//	public String getVolume() {
//		return volume;
//	}
//
//	public void setVolume(String volume) {
//		this.volume = volume;
//	}
//
//	public String getAvgVolume() {
//		return avgVolume;
//	}
//
//	public void setAvgVolume(String avgVolume) {
//		this.avgVolume = avgVolume;
//	}
//
//	public String getMarketCap() {
//		return marketCap;
//	}
//
//	public void setMarketCap(String marketCap) {
//		this.marketCap = marketCap;
//	}
//
//	public String getPeRatio() {
//		return peRatio;
//	}
//
//	public void setPeRatio(String peRatio) {
//		this.peRatio = peRatio;
//	}
//
//	@Override
//	public String toString() {
//		return "Stock [id=" + id + ", symbol=" + symbol + ", name=" + name + ", price=" + price + ", change=" + change
//				+ ", percentChange=" + percentChange + ", volume=" + volume + ", avgVolume=" + avgVolume
//				+ ", marketCap=" + marketCap + ", peRatio=" + peRatio + "]";
//	}

}
