
package Resturant;
import Entities.OrderEntity;
import Entities.RunnerEntity;
import javax.annotation.Untainted;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import com.google.inject.Inject;

public class Runner {
    
    @PersistenceContext
    private EntityManager em;

    @PUT
    public void updateRunnerStatus(Long runnerId, String status) {
        Runner runner = em.find(Runner.class, runnerId);
        RunnerEntity.setRunner_status(status);
        em.merge(runner);
    }

    
        @Inject 
        @PUT
        public void markOrderAsDelivered(Long orderId, Long runnerId) {
            Order order = em.find(Order.class, orderId);
            Runner runner = em.find(Runner.class, runnerId);
            OrderEntity.setOrder_status("delivered");
            RunnerEntity.setRunner_status("available");
        }
      
        @GET
        public int getNumberOfTripsCompletedByRunner(Long runnerId) {
            final javax.persistence.Query query = em.createQuery("SELECT COUNT(o) FROM Order o WHERE o.runner.id = :runnerId AND o.order_status = 'delivered'");
            query.setParameter("runnerId", runnerId);
            return ((Long) query.getSingleResult()).intValue();
        }
}
