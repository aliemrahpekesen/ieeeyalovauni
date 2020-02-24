package com.yalova.ieee.yemekhane.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yalova.ieee.yemekhane.model.FoodAndDrink;
import com.yalova.ieee.yemekhane.service.FoodAndDrinkService;

@RestController
@RequestMapping("/foodAndDrink")
public class FoodAndDrinkController {

	@Autowired
	private FoodAndDrinkService foodAndDrinkService;

	@PostMapping
	public FoodAndDrink addFoodAndDrink(@RequestBody FoodAndDrink newFoodAndDrink) {
		return this.foodAndDrinkService.CreateFoodAndDrink(newFoodAndDrink);
	}

	@GetMapping
	public ArrayList<FoodAndDrink> getAllFoodAndDrinks() {
		return this.foodAndDrinkService.RetrieveAll();
	}

	@GetMapping("/{foodAndDrinkId}")
	public FoodAndDrink getFoodAndDrinkById(@PathVariable String foodAndDrinkId) throws Exception {
		int idToBeFind = Integer.valueOf(foodAndDrinkId);
		FoodAndDrink foundFoodAndDrink = this.foodAndDrinkService.RetrieveFoodAndDrinkById(idToBeFind);
		if (foundFoodAndDrink == null) {
			throw new Exception("Resource Not Found!");
		}
		return foundFoodAndDrink;
	}
	
	@PutMapping("/{foodAndDrinkId}")
	public FoodAndDrink updateFoodAndDrink(@PathVariable String foodAndDrinkId,@RequestBody FoodAndDrink newFoodAndDrink ) {
		int idToBeUpdated = Integer.valueOf(foodAndDrinkId);
		FoodAndDrink updatedFoodAndDrink = this.foodAndDrinkService.UpdateFoodAndDrink(idToBeUpdated, newFoodAndDrink);
		return updatedFoodAndDrink;
	}

	@DeleteMapping("/{foodAndDrinkId}")
	public String deleteFoodAndDrinkById(@PathVariable String foodAndDrinkId) throws Exception {
		int idToBeDeleted = Integer.valueOf(foodAndDrinkId);
		this.foodAndDrinkService.DeleteFoodAndDrink(idToBeDeleted);
		return "FoodAndDrink is deleted by given Id";
	}

}
