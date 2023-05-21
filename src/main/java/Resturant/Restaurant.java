package Resturant;
import java.util.HashMap;
import java.util.Map;

import Entities.ResturantEntity;
public class Restaurant {
   
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
    public void addToMenu(String meal, double price) {
        menu.put(meal, price);
    }
    public void editMenu(String meal, double price) {
        if (menu.containsKey(meal)) {
            menu.put(meal, price);
        }
    }
    public void addOrder(String meal, int quantity, boolean isCanceled) {
        if (menu.containsKey(meal)) {
            double price = menu.get(meal);
            double total = price * quantity;
            if (isCanceled) {
                canceledOrders++;
            } else {
                completedOrders++;
                if (earnings.containsKey(meal)) {
                    total += earnings.get(meal);
                }
                earnings.put(meal, total);
            }
        }
    }

    public Map<String, Double> getMenu() {
        return menu;
    }
    public Map<String, Double> getEarnings() {
        return earnings;
    }
    public int getCompletedOrders() {
        return completedOrders;
    }
    public int getCanceledOrders() {
        return canceledOrders;
    }
    public double getTotalEarnings() {
        double total = 0;
        for (double value : earnings.values()) {
            total += value;
        }
        return total;
    }
}