package Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import Entities.MealEntity;
import Resturant.Restaurant;

@Stateless
public class resturantService {
    @PersistenceContext
    private EntityManager em;
    @Path("signUp")
    @POST
    public void signUp(Restaurant restaurant) {
        // validate restaurant input
        em.persist(restaurant);
    }
    @Path("login")
    @POST
    public Restaurant login(String name, String password) {
        return login(name, password);
    }
    @GET
    public List<MealEntity> getMeals(int restaurantId) {
        return getMeals(restaurantId);
        // return list of meals for given restaurantId
    }
}
