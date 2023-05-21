@Stateless
package Service;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
//import EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.PersistenceContext;

public class runnerService {
    @PersistenceContext
    private EntityManager em;
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
