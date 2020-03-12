package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, "customer" );
            ps.setInt( 4, user.getPhone() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static List<User> showUsers() throws SQLException {

        List<User> allUsers = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM users WHERE role = 'customer'";

            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt( "id" );
                String email = rs.getString("email");
                String password = rs.getString("password");
                int phone = rs.getInt("phone");
                User user = new User( id, email, password, phone );
                allUsers.add(user);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new SQLException(ex.getMessage());
        }

        return allUsers;

    }
    public static void Slet( User user ) {
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, user.getEmail() );
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void Opdater( User user ) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE users SET password =? , phone=? WHERE email=?";
            PreparedStatement ps = con.prepareStatement( SQL);
            ps.setString( 1, user.getPassword() );
            ps.setInt( 2, user.getPhone() );
            ps.setString( 3, user.getEmail() );

            ps.executeUpdate();
            System.out.println(user.getPassword());
            System.out.println(user.getPhone());


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Nulstil( User user ) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE users SET password ='1234' WHERE email=?";
            PreparedStatement ps = con.prepareStatement( SQL);
            ps.setString( 1, user.getEmail() );
            ps.executeUpdate();
            System.out.println(user.getEmail());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
