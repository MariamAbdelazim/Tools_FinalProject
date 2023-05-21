@Stateless
public class UserController {
    @PersistenceContext
    private EntityManager em;
    @Path("creatUser")
    @post
    public void createUser(User user) {
        em.persist(user);
    }
    @Get
    public User getUserById(Long userId) {
        return em.find(User.class, userId);
    }
    @Path("creatOrder")
    @post
    public void createOrder(int customerId, int restaurantId, List<Item> items) { // find a random available runner List<Runner> runners = em.createQuery("SELECT r FROM Runner r WHERE r.status = 'available'", Runner.class).getResultList(); Runner runner = runners.get((int) (Math.random() * runners.size())); runner.setStatus("busy"); em.merge(runner);
    // create the order
      Order order = new Order();
      order.setItems(items);
      double total_price = 0;
      for (Item item : items) {
         total_price += item.getMeal().getPrice() * item.getQuantity();
      }
      total_price += runner.getDeliveryFees();
      order.setTotalPrice(total_price);
      order.setRunner(runner);
      order.setRestaurant(em.find(Restaurant.class, restaurantId));
      order.setOrderStatus("preparing");
      em.persist(order);
      // add the order to the customer's list of orders
      User customer = em.find(User.class, customerId);
      customer.getOrders().add(order);
      em.merge(customer);
    }
    @put
    public void editOrder(int orderId, List<Item> items) 
    { Order order = em.find(Order.class, orderId);
         if (order.getOrderStatus().equals("canceled"))
          { throw new RuntimeException("Cannot edit a canceled order."); } 
          if (!order.getOrderStatus().equals("preparing"))
           { throw new RuntimeException("Cannot edit an order that is not in the preparing state."); } 
           order.setItems(items); double total_price = 0; 
           for (Item item : items)
            { total_price += item.getMeal().getPrice() * item.getQuantity(); } 
            total_price += order.getRunner().getDeliveryFees(); 
            order.setTotalPrice(total_price); em.merge(order); }
    
    @Get
    public List<Restaurant> listRestaurants() 
    { return em.createQuery("SELECT r FROM Restaurant r", Restaurant.class).getResultList(); }
    // ... }

}


