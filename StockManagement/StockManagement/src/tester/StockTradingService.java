package tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import static utils.StockUtils.populatestocks;
import com.app.core.Stock;

import customExceptions.StockTradingExceptions;
import utils.ValidateStocks.*;
import static utils.ValidateStocks.validateDate;

import static utils.ValidateStocks.checkForDuplicate;;
public class StockTradingService {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			HashMap<String, Stock> stocks = populatestocks();
			System.out.println("Select fromhe following\r\n 1.Add new stock\r\n 2.Display all stocks\r\n 3. ");
			while (!exit) {
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the unique id");
						String id = checkForDuplicate(sc.next(), stocks);
						System.out.println("Enter the following details: name,companyName, price,closingDate,quantity");
						Stock s = new Stock(id, sc.next(), sc.next(), sc.nextInt(), validateDate(sc.next()) , sc.nextInt());
						stocks.put(s.getStockId(), s);
						System.out.println("stock added sucessfully!!");
						break;

					case 2:
						for(Stock s1 : stocks.values())
							System.out.println(s1);
							
						
						break;

					case 3:
						System.out.println("Enter the Stock id and Quantity");
						id = sc.next();
						int qty = sc.nextInt();
						if(stocks.containsKey(id)) {
						s = stocks.get(id);
						if(s.getQuantity()>qty)
						s.setQuantity(s.getQuantity()-qty);
						else
							throw new StockTradingExceptions("Invalid Id!!");
						}else
							throw new StockTradingExceptions("Insufficient quantity!!");
								
						}
						break;

					case 4:

						break;

					case 5:

						break;

					case 0:
						exit = true;
						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}

		}

	}

}
