package Resturant;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.concurrent.GuardedBy;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;

import Entities.MealEntity;
import Entities.ResturantEntity;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/")
public class Restaurant {
    @Inject
    private Map<String, Double> menu;
    private Map<String, Double> earnings;
    private int completedOrders;
    private int canceledOrders;
    
    public Restaurant() {
        this.menu = new HashMap<>();
        this.earnings = new HashMap<>();
        this.completedOrders = 0;
        this.canceledOrders = 0;
    }
    @Path("addToMenu")
    @POST
    public void addToMenu(String meal, double price) {
        menu.put(MealEntity.getMeal_name(), MealEntity.getPrice());
    }
    @PUT
    public void editMenu(String meal, double price) {
        if (menu.containsKey(MealEntity.getMeal_name())) {
            menu.put(MealEntity.getMeal_name(), MealEntity.getPrice());
        }
    }
    @Path("addOrder")
    @POST
    public void addOrder(String meal, int quantity, boolean isCanceled) {
        if (menu.containsKey(MealEntity.getMeal_name())) {
            double price = menu.get(MealEntity.getMeal_name());
            double total = MealEntity.getPrice() * quantity;
            if (isCanceled) {
                canceledOrders++;
            } else {
                completedOrders++;
                if (earnings.containsKey(MealEntity.getMeal_name())) {
                    total += earnings.get(MealEntity.getMeal_name());
                }
                earnings.put(MealEntity.getMeal_name(), total);
            }
        }
    }
    @GET
    public Map<String, Double> getMenu() {
        return menu;
    }
    @GET
    public Map<String, Double> getEarnings() {
        return earnings;
    }
    @GET
    public int getCompletedOrders() {
        return completedOrders;
    }
    @GET
    public int getCanceledOrders() {
        return canceledOrders;
    }
    @GET
    public double getTotalEarnings() {
        double total = 0;
        for (double value : earnings.values()) {
            total += value;
        }
        return total;
    }
}
