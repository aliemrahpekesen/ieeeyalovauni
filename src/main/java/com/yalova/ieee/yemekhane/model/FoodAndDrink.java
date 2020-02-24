package com.yalova.ieee.yemekhane.model;

import lombok.Data;

@Data
public class FoodAndDrink {
	private int id;
	private ElementType type;
	private Category category;
	private String name;
	private double weight;
	private WeightUnit weightUnit;
	private double price;
	private String photo;
}
