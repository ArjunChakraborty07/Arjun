package com.inventory.model;

public class Inventory {
	
	String name;
	double weight;
	double price;
	public Inventory(String name, double weight, double price) {
		super();
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	public Inventory() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
