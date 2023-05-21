@Stateless
public class RestaurantService {
    @PersistenceContext
    EntityManager em;
    @Path("signUp")
    @post
    public void signUp(Restaurant restaurant) {
        // validate restaurant input
        em.persist(restaurant);
    }
    @Path("login")
    @post
    public Restaurant login(String name, String password) {
        // check restaurant credentials and return restaurant object
    }
    @Get
    public List<Meal> getMeals(int restaurantId) {
        // return list of meals for given restaurantId
    }
}
