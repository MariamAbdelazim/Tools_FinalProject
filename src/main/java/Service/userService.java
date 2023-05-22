package Service;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import Entities.UserEntity;


public class userService {
    @PersistenceContext
    EntityManager em;
    @Path("signUp")
    @POST
    public void signUp_user(UserEntity user) {
        // validate user input
        em.persist(user);
    }
    @Path("login")
    @POST
    public UserEntity login_user(String name, String password) {
        return login(name, password);
        // check user credentials and return user object
    }
}
