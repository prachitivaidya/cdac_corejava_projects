package utils;

import java.time.LocalDate;
import java.util.HashMap;

import com.app.core.Stock;

public class StockUtils {

	
	
	
	
	
	
	public static HashMap<String, Stock> populatestocks() {
		HashMap<String, Stock> stockMap = new HashMap<String, Stock>();
		Stock s1 = new Stock("s1", "Basic", "Bata", 2500, LocalDate.parse("2023-10-05"), 10);
		Stock s2= new Stock("s2", "Advance", "Tata", 3500, LocalDate.parse("2023-09-25"), 10);
		Stock s3 = new Stock("s3", "Average", "jio", 4000, LocalDate.parse("2023-09-05"), 10);
		Stock s4 = new Stock("s4", "New", "Suziki", 5000, LocalDate.parse("2023-10-15"), 10);
		Stock s5 = new Stock("s5", "Organised", "Tesla", 15000, LocalDate.parse("2023-10-16"), 10);
		Stock s6 = new Stock("s6", "Basic", "Mahindra", 1200, LocalDate.parse("2023-10-07"), 10);
		stockMap.put(s1.getStockId(), s1);
		stockMap.put(s2.getStockId(), s2);
		stockMap.put(s3.getStockId(), s3);
		stockMap.put(s4.getStockId(), s4);
		stockMap.put(s5.getStockId(), s5);
		stockMap.put(s6.getStockId(), s6);
		
		return stockMap;
	}
}
