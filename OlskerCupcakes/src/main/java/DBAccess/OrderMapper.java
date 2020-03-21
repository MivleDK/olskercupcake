package DBAccess;

import FunctionLayer.LoginSampleException;

import java.sql.*;

public class OrderMapper {

    public static int createOrder(int userId) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (users_id) VALUES (?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1,userId);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int orderId = ids.getInt( 1 );
            return orderId;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage());
        }
    }

    public static void createOrderLine(int orderId, int quantity, double totalPrice, int toppingId, int bottomId) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orderline (orders_id,quantity,sum,topping_id,bottom_id) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1,orderId);
            ps.setInt(2,quantity);
            ps.setDouble(3,totalPrice);
            ps.setInt(4,toppingId);
            ps.setInt(5,bottomId);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage());
        }
    }

    public static void updateUserCredit(int userId, double sumTotal) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE users SET credit = credit - ? WHERE users_id = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setDouble( 1, sumTotal );
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}
