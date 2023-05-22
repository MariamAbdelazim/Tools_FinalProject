package Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import Entities.UserEntity;

@Stateless
public class userService {
    @PersistenceContext
    EntityManager em;
    private static userService findById(int user_id) {
        return null;
    }
    @Path("signUp_user")
    @POST
    public boolean signUp_user(String name,String role, Long userId) {
        userService storedUser = userService.findById(UserEntity.getUser_id());
        if (storedUser == null) {
            return true;
        } else {
            return false;
        }
    }
    @Path("login_user")
    @POST
    public boolean isFirstTimeLogin(String role, Long userId) {
        // assuming you have a database table named "users" with columns "id", "role" and "first_login"
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isFirstTimeLogin = true;
        try {
            // connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            // prepare the SQL query to check if the user is logging in for the first time
            String sql = "SELECT first_login FROM users WHERE id = ? AND role = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, userId);
            stmt.setString(2, role);
            rs = stmt.executeQuery();
            // if the user is found in the database, check if it's their first time logging in
            if (rs.next()) {
                isFirstTimeLogin = rs.getBoolean("first_login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // close all database resources
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isFirstTimeLogin;
    }
}
