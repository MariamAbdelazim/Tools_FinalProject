package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Resturant.Restaurant;

@Entity
public class MealEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private static int quantity;
	private static int Meal_id;
	private static String Meal_name;
	private static Double Price;
	private int fk_restaurantId;
	
    public static int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@ManyToOne
    private Restaurant restaurant;
	public static int getMeal_id() {
		return Meal_id;
	}
	public void setMeal_id(int meal_id) {
		Meal_id = meal_id;
	}
	public static String getMeal_name() {
		return Meal_name;
	}
	public void setMeal_name(String meal_name) {
		Meal_name = meal_name;
	}
	public static Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public int getFk_restaurantId() {
		return fk_restaurantId;
	}
	public void setFk_restaurantId(int fk_restaurantId) {
		this.fk_restaurantId = fk_restaurantId;
	}

}
