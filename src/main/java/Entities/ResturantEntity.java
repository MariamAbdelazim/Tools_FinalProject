package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResturantEntity {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)


	private String Order_status;
	private int Resturant_id;
	private String Resturant_name;
	private int OwnerId;
	private List<String> listOfMeals;
	
	
	

	public int getResturant_id() {
		return Resturant_id;
	}
	public void setResturant_id(int resturant_id) {
		Resturant_id = resturant_id;
	}
	public String getResturant_name() {
		return Resturant_name;
	}
	public void setResturant_name(String resturant_name) {
		Resturant_name = resturant_name;
	}
	public List<String> getListOfMeals() {
		return listOfMeals;
	}
	public void setListOfMeals(List<String> listOfMeals) {
		this.listOfMeals = listOfMeals;
	}
	public int getOwnerId() {
		return OwnerId;
	}
	public void setOwnerId(int ownerId) {
		OwnerId = ownerId;
	}
	public String getOrder_status() {
		return Order_status;
	}
	public void setOrder_status(String order_status) {
		Order_status = order_status;
	}
	
	
	
	 
	
	

}
