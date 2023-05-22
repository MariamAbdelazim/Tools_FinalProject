package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/*
	 * @OneToMany
     private UserController customer;

    @ManyToOne
     private Restaurant restaurant;

    @OneToOne
     private Runner driver;

	 */
	
	private static int Order_id;
	private int Total_price;
	private int fk_runnerId;
	private static String Order_status;
	private int Resturant_id;
	private List<String> listOfMeals;
	public static int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	public int getTotal_price() {
		return Total_price;
	}
	public void setTotal_price(int total_price) {
		Total_price = total_price;
	}
	public int getFk_runnerId() {
		return fk_runnerId;
	}
	public void setFk_runnerId(int fk_runnerId) {
		this.fk_runnerId = fk_runnerId;
	}
	public String getOrder_status() {
		return Order_status;
	}
	public static void setOrder_status(String order_status) {
		Order_status = order_status;
	}
	public int getResturant_id() {
		return Resturant_id;
	}
	public void setResturant_id(int resturant_id) {
		Resturant_id = resturant_id;
	}
	public List<String> getListOfMeals() {
		return listOfMeals;
	}
	public void setListOfMeals(List<String> listOfMeals) {
		this.listOfMeals = listOfMeals;
	}
    public static int getDelivery_fees() {
        return 0;
    }

}
