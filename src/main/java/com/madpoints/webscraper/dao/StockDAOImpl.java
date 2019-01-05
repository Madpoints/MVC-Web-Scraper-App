package com.madpoints.webscraper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madpoints.webscraper.entity.Stock;

@Repository
public class StockDAOImpl implements StockDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Stock> getStocks() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Stock> theQuery = 
				currentSession.createQuery("from Stock order by name",
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

}
