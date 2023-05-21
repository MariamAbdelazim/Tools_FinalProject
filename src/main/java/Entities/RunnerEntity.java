package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RunnerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Runner_id;
	private String Runner_name;
	private String Runner_status;
	private int Delivery_fees;

	public int getRunner_id() {
		return Runner_id;
	}
	public void setRunner_id(int runner_id) {
		Runner_id = runner_id;
	}
	public String getRunner_name() {
		return Runner_name;
	}
	public void setRunner_name(String runner_name) {
		Runner_name = runner_name;
	}
	public String getRunner_status() {
		return Runner_status;
	}
	public void setRunner_status(String runner_status) {
		Runner_status = runner_status;
	}
	public int getDelivery_fees() {
		return Delivery_fees;
	}
	public void setDelivery_fees(int delivery_fees) {
		Delivery_fees = delivery_fees;
	}

}
