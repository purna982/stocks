package com.purna.stocks.webservices.stock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockDaoService {
	
	private static List<Stock> stocks = new ArrayList<>();
	private static List<Stock> st = new ArrayList<>();
	
	@Autowired
	private StockRepository stockRepository;
	
	private int i = 0;
	
	static {
		stocks.add(new Stock(10001,"down","USD/GPE", 1.222,1.43333,new Date()));
		stocks.add(new Stock(10002,"down","USD/LEP", 1.122,1.03333,new Date()));
		stocks.add(new Stock(10003,"up","LOP/GPE", 0.222,1.3333,new Date()));
		stocks.add(new Stock(10004,"up","ERE/GPE", 0.222,0.43333,new Date()));
		stocks.add(new Stock(10004,"up","ERE/GPE", 0.222,0.43333,new Date()));
	}
	
	static {
		st.add(new Stock(10001,"up","USD/GPE", 0.222,1.43333,new Date()));
		st.add(new Stock(10002,"up","USD/LEP", 0.122,7.03333,new Date()));
		st.add(new Stock(10003,"down","LOP/GPE", 11.222,1.3333,new Date()));
		st.add(new Stock(10004,"down","ERE/GPE", 1.222,4.43333,new Date()));
		st.add(new Stock(10005,"down","GGD/GPD", 2.222,4.43333,new Date()));
	}

	public List<Stock> before() {
		 stocks.forEach(s-> s.setMid((s.getBid()+s.getAsk())/2));
		 return stocks;
	}
	
	public List<Stock> after() {
		 st.forEach(s-> s.setMid((s.getBid()+s.getAsk())/2));
		 return st;
	}
	
	@Scheduled(fixedDelay = 10000)
	public void run() {
		
	    System.out.print("Current time is :: " + Calendar.getInstance().getTime());
	    if(i == 0) {
	    	  before().stream().forEach(s-> {
	  	    	retriveStock(s);
	  	    });	
	    	  i  = 1;	  
	    } else {
	    	  after().stream().forEach(s-> {
	  	    	retriveStock(s);
	  	    });
	    	  i  = 0;	  
	    }
	}
	
	
	public void retriveStock(Stock s) {
		stockRepository.save(s);
	}
	
	
}
