package com.app.core;

import java.time.LocalDate;

public class Stock {
//stock id (unique : string), stock name (string), company name(string) , price (double), closing date (Date) , quantity (int)
private String stockId;
private String name;
private String companyName;
private double price;
private LocalDate closingDate;
private int quantity;




public Stock(String stockId, String name, String companyName, double price, LocalDate closingDate, int quantity) {
	super();
	this.stockId = stockId;
	this.name = name;
	this.companyName = companyName;
	this.price = price;
	this.closingDate = closingDate;
	this.quantity = quantity;
}



@Override
public String toString() {
	return "Stock [stockId=" + stockId + ", name=" + name + ", companyName=" + companyName + ", price=" + price
			+ ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
}



public String getStockId() {
	return stockId;
}
public void setStockId(String stockId) {
	this.stockId = stockId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public LocalDate getClosingDate() {
	return closingDate;
}
public void setClosingDate(LocalDate closingDate) {
	this.closingDate = closingDate;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}



}
