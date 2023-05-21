package Resturant;
import java.util.HashMap;
import java.util.Map;

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
    @post
    public void addToMenu(String meal, double price) {
        menu.put(MealEntity.getMeal_name, MealEntity.getPrice);
    }
    @put
    public void editMenu(String meal, double price) {
        if (menu.containsKey(MealEntity.getMeal_name)) {
            menu.put(MealEntity.getMeal_name, MealEntity.getPrice);
        }
    }
    @Path("addOrder")
    @post
    public void addOrder(String meal, int quantity, boolean isCanceled) {
        if (menu.containsKey(MealEntity.getMeal_name)) {
            double price = menu.get(MealEntity.getMeal_name);
            double total = MealEntity.getPrice * quantity;
            if (isCanceled) {
                canceledOrders++;
            } else {
                completedOrders++;
                if (earnings.containsKey(MealEntity.getMeal_name)) {
                    total += earnings.get(MealEntity.getMeal_name);
                }
                earnings.put(MealEntity.getMeal_name, total);
            }
        }
    }
    @Get
    public Map<String, Double> getMenu() {
        return menu;
    }
    @Get
    public Map<String, Double> getEarnings() {
        return earnings;
    }
    @Get
    public int getCompletedOrders() {
        return completedOrders;
    }
    @Get
    public int getCanceledOrders() {
        return canceledOrders;
    }
    @Get
    public double getTotalEarnings() {
        double total = 0;
        for (double value : earnings.values()) {
            total += value;
        }
        return total;
    }
}
