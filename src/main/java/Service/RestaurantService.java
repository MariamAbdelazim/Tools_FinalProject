package Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.dom4j.io.DOMWriter;

import Entities.MealEntity;
import Entities.ResturantEntity;
import Entities.UserEntity;
import Resturant.Restaurant;

@Stateless
//@RolesAllowed({"admin, qa"})
public class resturantService {
    @PersistenceContext
    //@Resource
    private EntityManager em;
    
    @Path("signUp")
    @POST
    public resturantService signUp_resturant(int resturant_id,String resturan_name, String resturant_password) {
        // validate restaurant input
        return Resturant_signUp(resturant_id,resturan_name,resturant_password);
    }
    @Path("login")
    @POST
    public Restaurant login_resturant(String resturan_name, String resturant_password) {
        return Resturant_login(resturan_name,resturant_password);
    }
    @GET
    public List<MealEntity> getMeals(int restaurantId) {
        return getMeals(restaurantId);
        // return list of meals for given restaurantId
    }
}
