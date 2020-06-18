package com.purna.stocks.webservices.stock;

import static org.junit.Assert.assertNotNull;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StockRepositoryTest {
	
	 @Autowired
	 private StockRepository repo;
	 
	 @Test
	 public void testFindAll() throws Exception {
		 Stock stock = new Stock("up","USE/GPE",1.222,1.4444, new Date());
		 repo.save(stock);
		 assertNotNull(repo.findAll());
	 }

}
