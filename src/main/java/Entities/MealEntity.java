package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MealEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Meal_id;
	private String Meal_name;
	private int Price;
	private int fk_restaurantId;

	public int getMeal_id() {
		return Meal_id;
	}
	public void setMeal_id(int meal_id) {
		Meal_id = meal_id;
	}
	public String getMeal_name() {
		return Meal_name;
	}
	public void setMeal_name(String meal_name) {
		Meal_name = meal_name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getFk_restaurantId() {
		return fk_restaurantId;
	}
	public void setFk_restaurantId(int fk_restaurantId) {
		this.fk_restaurantId = fk_restaurantId;
	}

}
