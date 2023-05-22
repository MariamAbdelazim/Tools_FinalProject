package Service;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.jaxen.function.SumFunction;

import Entities.OrderEntity;
import Resturant.Runner;

import javax.ejb.Stateless;

@Stateless
public class runnerService {
    private static final String Item = null;
    @PersistenceContext
    private EntityManager em;
    @Path("signUp")
    @POST
    public void signUp(Runner runner) {
        // validate runner input
        em.persist(runner);
    }
 
    @Path("login")
    @POST
    public String login(String name, String password) {
        
        // check runner credentials and return runner object
        return login(name, password);
    }
    /**
     * @param order
     * @return
     */
    @PUT
    public double calculateOrderTotal(Order order) {
        // calculate order total based on delivery fees and item prices
        // return OrderEntity.getOrder_id().stream().mapToDouble(Item::getPrice).sum() + ((Object) order).getRunner().getDelivery_fees();
      return SumFunction(OrderEntity.getOrder_id()+OrderEntity.getDelivery_fees());
    }

    private double SumFunction(int i) {
        return 0;
    }

}
