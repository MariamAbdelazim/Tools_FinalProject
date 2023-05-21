@Stateless
public class RunnerService {
    @PersistenceContext
    EntityManager em;
    @Path("signUp")
    @post
    public void signUp(Runner runner) {
        // validate runner input
        em.persist(runner);
    }
    @Path("login")
    @post
    public Runner login(String name, String password) {
        // check runner credentials and return runner object
    }
    @put
    public double calculateOrderTotal(Order order) {
        // calculate order total based on delivery fees and item prices
        return order.getItems().stream().mapToDouble(Item::getPrice).sum() + order.getRunner().getDelivery_fees();
    }
}
