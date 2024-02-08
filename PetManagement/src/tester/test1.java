package tester;
import static utils.customException.authenticateAdmin;
import static utils.customException.authenticateCustomer;
import static utils.customException.checkOrderId;
import static utils.customException.checkPetId;
import static utils.customException.checkPetStock;
import static utils.customException.updatePetStock;
import static utils.customException.populateMap;
import java.util.HashMap;
import java.util.Scanner;

import core.Category;
import core.Order;
import core.Pet;
import core.Status;
import exceptions.authenticationException;
import exceptions.authorizationError;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		boolean customerAuthenticated = false;
		boolean adminAuthenticated = false;
		HashMap<Integer, Pet> pets = populateMap();
		HashMap<Integer, Order> orders = new HashMap<>();
		
		while(!exit) {
			try {
				System.out.println("1. Login\r\n"
						+ "2. Add new Pet \r\n"
						+ "3. Update Pet details \r\n"
						+ "4. Display all available pets\r\n"
						+ "5. Order a Pet\r\n"
						+ "6. Check order status by Order Id\r\n"
						+ "7. Update order status \r\n"
						+ "8. Exit");
				System.out.println("Select option: ");
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter username and password: ");
					String username = sc.next();
					String password = sc.next();
					customerAuthenticated = authenticateCustomer(username, password);
					adminAuthenticated = authenticateAdmin(username, password);
					if(customerAuthenticated || adminAuthenticated)
						System.out.println("Login successful...");
					else
						throw new authenticationException("Auhtentication failed...");
					break;
				case 2:
					if(adminAuthenticated == true) {
						System.out.println("Enter PetId, Enter name, Category, UnitPrice, Stock");
						Pet p = new Pet(sc.nextInt(),sc.next(), Category.valueOf(sc.next()), sc.nextInt(),sc.nextInt());
						pets.put(p.getPetId(), p);
						System.out.println("Pet added successfully...");
					}
					else {
						throw new authorizationError("Admin functionality only...");
					}
					break;
				case 3:
					if(adminAuthenticated == true) {
						System.out.println("Enter pet id whose details are to be updated: ");
						int id = sc.nextInt();
						checkPetId(id, pets);
						System.out.println("Enter stock to be updated: ");
						int st = sc.nextInt();
						System.out.println("Enter unit price to be updated: ");
						int unitPrice = sc.nextInt();
						Pet p = pets.get(id);
						p.setStocks(st);
						p.setUnitPrice(unitPrice);	
					}
					else {
						throw new authorizationError("Admin functionality only...");
					}
					break;
				case 4:
					if(customerAuthenticated || adminAuthenticated) {
						System.out.println("All pet details are: ");
						pets.values().stream().forEach(pet->System.out.println(pet));
					}
					else
						throw new authenticationException("Authentication failed...");
					break;
				case 5:
					if(customerAuthenticated || adminAuthenticated) {
						System.out.println("Enter following details for order: (petId, quantity)");
						int petId = sc.nextInt();
						int quantity = sc.nextInt();
						checkPetId(petId, pets);
						checkPetStock(petId, quantity, pets);
						Order o = new Order(petId,quantity,Status.PLACED);
						orders.put(o.getOrderId(), o);
						updatePetStock(petId, quantity, pets);
						System.out.println("Order added successfully...");
						System.out.println("Your order id is " + o.getOrderId());
					}
					else
						throw new authenticationException("Authentication failed...");
					break;
				case 6:
					if(customerAuthenticated || adminAuthenticated) {
						System.out.println("Enter orderid: ");
						int id = sc.nextInt();
						Order o = checkOrderId(id, orders);	
						System.out.println(o.getStatus());
					}
					else
						throw new authenticationException("Authentication failed...");
					break;
				case 7:
					if(adminAuthenticated == true) {
						System.out.println("Enter order id: ");
						int id1 = sc.nextInt();
						Order o1 = checkOrderId(id1, orders);
						o1.setStatus(Status.COMPLETED);
					}
					else
						throw new authorizationError("Admin functionality only...");
					break;
				case 8:
					exit = true;
					System.out.println("Bye...");
					break;
				}
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		sc.close();
	}
}
