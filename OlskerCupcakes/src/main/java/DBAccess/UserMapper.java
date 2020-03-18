package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            String SQL = "INSERT INTO Users (email, phone, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setInt(2,user.getPhone());
            ps.setString( 3, user.getPassword() );
            ps.setString( 4, user.getRole() );
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
            String SQL = "SELECT users_id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "users_id" );
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

    public static void deleteUser( String email ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static void updateCredit(String email, String credit) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE users SET credit = credit + ? WHERE email = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, credit );
            ps.setString(2, email);
            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static List<User> viewCustomer() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT users_id,email,phone,credit FROM users WHERE role = 'customer' ORDER BY users_id";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt( "users_id" );
                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                double credit = rs.getDouble("credit");
                User user = new User( id, email, phone, credit );
                allUsers.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex ) {
            throw new SQLException(ex.getMessage());
        }

        return allUsers;
    }

    public static void resetCode(int id, String newCode) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE Users SET password = ? WHERE users_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newCode);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}
