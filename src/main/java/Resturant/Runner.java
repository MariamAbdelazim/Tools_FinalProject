
@Stateless
public class RunnerController {
    @PersistenceContext
    private EntityManager em;
    
    @put
    public void updateRunnerStatus(Long runnerId, String status) {
        Runner runner = em.find(Runner.class, runnerId);
        runner.setStatus(status);
        em.merge(runner);
    }
    @Get
    public void delivered { 
        @Inject private EntityManager em;
        public void markOrderAsDelivered(Long orderId, Long runnerId) {
            Order order = em.find(Order.class, orderId);
            Runner runner = em.find(Runner.class, runnerId);
            order.setOrder_status("delivered");
            runner.setStatus("available");
        }
        @Get
        public int getNumberOfTripsCompletedByRunner(Long runnerId) {
            Query query = em.createQuery("SELECT COUNT(o) FROM Order o WHERE o.runner.id = :runnerId AND o.order_status = 'delivered'");
            query.setParameter("runnerId", runnerId);
            return ((Long) query.getSingleResult()).intValue();
        }
    }
}
