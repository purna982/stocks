package com.purna.stocks.webservices.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	
	@Autowired
	private StockRepository stockRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getStocks")
	public ResponseEntity<List<Stock>> retrieveAllUsers() {
		List<Stock> stocks = stockRepository.findAll();
		stocks.stream().forEach(s-> s.setMid((s.getBid()+s.getAsk())/2));
		return new  ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
	}

}
