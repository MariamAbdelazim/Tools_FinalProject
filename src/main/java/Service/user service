@Stateless
public class UserService {
    @PersistenceContext
    EntityManager em;
    @Path("signUp")
    @post
    public void signUp(User user) {
        // validate user input
        em.persist(user);
    }
    @Path("login")
    @post
    public User login(String name, String password) {
        // check user credentials and return user object
    }
}
