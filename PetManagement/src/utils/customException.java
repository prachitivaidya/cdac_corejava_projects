package utils;
import java.util.HashMap;

import core.*;
import exceptions.invalidInputArgument;
public class customException {
	public static boolean authenticateCustomer(String username, String password) {
		if(username.equalsIgnoreCase("c1") && password.equalsIgnoreCase("c1")) {
			return true;
		}
		return false;
	}
	
	public static boolean authenticateAdmin(String username, String password){
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			return true;
		}
		return false;
	}
	
	public static void checkPetId(Integer id, HashMap<Integer, Pet> pets) throws invalidInputArgument{
		if(pets.containsKey(id)) {
			System.out.println("Pet Id authenticated...");
			return;
		}
		throw new invalidInputArgument("No pet Id detected...");
	}
	
	public static Order checkOrderId(Integer id, HashMap<Integer, Order> orders) throws invalidInputArgument{
		if(orders.get(id)==null)
			throw new invalidInputArgument("No order Id detected...");
		return orders.get(id);
	}
	
	public static boolean checkPetStock(int id, int quantity, HashMap<Integer, Pet> pets) throws invalidInputArgument{
		Pet p = pets.get(id);
		if(p.getStocks()<quantity)
			throw new invalidInputArgument("Pet out of stock...");
		return true;
			
	}
	
	public static void updatePetStock(int id, int quantity,HashMap<Integer, Pet>pets) {
		Pet p = pets.get(id);
		p.setStocks(p.getStocks()-quantity);
	}
	
	public static HashMap<Integer, Pet> populateMap(){
		HashMap<Integer, Pet> pets = new HashMap<Integer, Pet>();
		Pet p1 = new Pet(101,"BullDog",Category.DOG,1000,50);
		Pet p2 = new Pet(102,"SiameseCat",Category.CAT,600,60);
		Pet p3 = new Pet(103,"HollandLop",Category.RABBIT,800,75);
		Pet p4 = new Pet(104,"GoldFish",Category.FISH,200,200);
		pets.put(p1.getPetId(), p1);
		pets.put(p2.getPetId(), p2);
		pets.put(p3.getPetId(), p3);
		pets.put(p4.getPetId(), p4);
		return pets;
	}
}