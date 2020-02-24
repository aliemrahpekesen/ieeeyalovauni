package com.yalova.ieee.yemekhane.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yalova.ieee.yemekhane.model.FoodAndDrink;

@Service
public class FoodAndDrinkService {

	ArrayList<FoodAndDrink> foodAndDrinkList = new ArrayList<FoodAndDrink>();

	public FoodAndDrink CreateFoodAndDrink(FoodAndDrink foodAndDrinkObject) {
		this.foodAndDrinkList.add(foodAndDrinkObject);
		return foodAndDrinkObject;
	}

	public FoodAndDrink RetrieveFoodAndDrinkById(int id) {
		FoodAndDrink foundFoodAndDrink = null;
		for (FoodAndDrink foodAndDrink : foodAndDrinkList) {
			if (foodAndDrink.getId() == id) {
				foundFoodAndDrink = foodAndDrink;
				break;
			}
		}

		return foundFoodAndDrink;
	}

	public ArrayList<FoodAndDrink> RetrieveAll() {
		return this.foodAndDrinkList;
	}

	public FoodAndDrink UpdateFoodAndDrink(int idToBeUpdated,FoodAndDrink newFoodAndDrink) {
		int elementCount = this.foodAndDrinkList.size();
		FoodAndDrink updatedFoodAndDrink=null;
		for(int i=0; i<elementCount;i++) {
			if(this.foodAndDrinkList.get(i).getId()==idToBeUpdated) {
				updateAnItemInTheList(i, newFoodAndDrink);
				break;
			}
		}
		return updatedFoodAndDrink;
	}

	public void DeleteFoodAndDrink(int id) {
		FoodAndDrink foodAndDrinkToBeDeleted = RetrieveFoodAndDrinkById(id);
		this.foodAndDrinkList.remove(foodAndDrinkToBeDeleted);
	}
	
	private FoodAndDrink updateAnItemInTheList(int index,FoodAndDrink newObject) {
		this.foodAndDrinkList.get(index).setType(newObject.getType());
		this.foodAndDrinkList.get(index).setCategory(newObject.getCategory());
		this.foodAndDrinkList.get(index).setName(newObject.getName());
		this.foodAndDrinkList.get(index).setWeight(newObject.getWeight());
		this.foodAndDrinkList.get(index).setWeightUnit(newObject.getWeightUnit());
		this.foodAndDrinkList.get(index).setPrice(newObject.getPrice());
		this.foodAndDrinkList.get(index).setPhoto(newObject.getPhoto());
		return this.foodAndDrinkList.get(index);
	}

}
