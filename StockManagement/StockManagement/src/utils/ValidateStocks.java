package utils;

import java.time.LocalDate;
import java.util.HashMap;
import customExceptions.*;

public class ValidateStocks {
	
	public static LocalDate validateDate(String date) throws StockTradingExceptions {
		LocalDate validdate = LocalDate.parse(date);
		if(LocalDate.now().isBefore(validdate)) {
			throw new StockTradingExceptions("Invalid date!!");
		}
		return validdate;
	}

	public static Stock purchaseStock (String id, int Qty,HashMap maps) {
		
	}
	
	public static String checkForDuplicate(String id,HashMap maps) throws StockTradingExceptions {
		if(maps.containsKey(id)) {
			throw new StockTradingExceptions("Duplicate Id!");
		}
		return id;
	}
	
}
