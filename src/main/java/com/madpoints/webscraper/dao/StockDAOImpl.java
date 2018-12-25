package com.madpoints.webscraper.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.madpoints.webscraper.entity.Stock;

public class StockDAOImpl implements StockDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Stock> getStocks() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Stock> theQuery = 
				currentSession.createQuery("from Stock order by stockName",
											Stock.class);
		
		List<Stock> stocks = theQuery.getResultList();
		
		return stocks;
	}
	
	@Override
	public Stock getStock(int stockId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Stock theStock = currentSession.get(Stock.class, stockId);
		
		return theStock;
	}
	

	@Override
	public void saveStock(List<Stock> stocks) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		for (Stock stock : stocks) {
		
			currentSession.saveOrUpdate(stock);
		}
		
	}

	@Override
	public void buyStock(int stockId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sellStock(int stockId) {
		// TODO Auto-generated method stub
		
	}

}
