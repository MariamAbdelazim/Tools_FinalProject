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
    public runnerService runner_signUp(int runner_id,String runner_name, String runner_password) {
        // validate runner input
        return runner_signUp(runner_id,runner_name,runner_password);
    }
 
    @Path("login")
    @POST
    public String runner_login(String runner_name, String runner_password) {
        
        // check runner credentials and return runner object
        return login_runner(runner_name, runner_password);
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
        return 0;
    }

}
