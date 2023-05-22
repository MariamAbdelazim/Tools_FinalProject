

package Resturant;

import static org.mockito.Mockito.reset;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import Entities.MealEntity;
import Entities.OrderEntity;
import Entities.ResturantEntity;
import Entities.RunnerEntity;
@Stateless

public class userController<Item> {
    
    private static final Double Item = null;
    private static final String Order = null;
    @PersistenceContext
    private EntityManager em;
    @Path("creatUser")
    @POST
    public void createUser(userController user) {
        em.persist(user);
    }
    @GET
    public userController getUserById(Long userId) {
        return em.find(userController.class, userId);
    }
    /**
     * @param customerId
     * @param restaurantId
     * @param items
     */
    @Path("creatOrder")
    @POST
    public void createOrder(int customerId, int restaurantId) { // find a random available runner List<Runner> runners = em.createQuery("SELECT r FROM Runner r WHERE r.status = 'available'", Runner.class).getResultList(); Runner runner = runners.get((int) (Math.random() * runners.size())); runner.setStatus("busy"); em.merge(runner);
    // create the order
       OrderEntity order =  new OrderEntity<Order>();
      double total_price = 0;
         total_price += MealEntity.getPrice() * MealEntity.getQuantity();
      total_price += RunnerEntity.getDelivery_fees();
      OrderEntity.setTotal_price(total_price);
      RunnerEntity.setRunner();
      ResturantEntity.setRestaurant(em.find(Restaurant.class, restaurantId));
      OrderEntity.setOrder_status("preparing");
      em.persist(order);
      // add the order to the customer's list of orders
      userController customer = em.find(userController.class, customerId);
      //OrderEntity.getOrder_id().add(Order);
      em.merge(customer);
    }
    @PUT
    public void editOrder(int orderId, List<Item> items) 
    { Order order = em.find(Order.class, orderId);
         if (OrderEntity.getOrder_status().equals("canceled"))
          { throw new RuntimeException("Cannot edit a canceled order."); } 
          if (!OrderEntity.getOrder_status().equals("preparing"))
           { throw new RuntimeException("Cannot edit an order that is not in the preparing state."); } 
           MealEntity.getMeal_name(); double total_price = 0; 
           for (Item item : items)
            { total_price += MealEntity.getPrice() * MealEntity.getQuantity(); } 
            total_price += RunnerEntity.getDelivery_fees(); 
            OrderEntity.setTotal_price(total_price); em.merge(order); }
    
    @GET
    public List<Restaurant> listRestaurants() 
    { return em.createQuery("SELECT r FROM Restaurant r", Restaurant.class).getResultList(); }
  

}


