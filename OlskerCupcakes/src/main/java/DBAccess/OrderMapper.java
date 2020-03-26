package DBAccess;

import FunctionLayer.*;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

    /**
    * Alt SQL til ordrehåndtering
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class OrderMapper {

        /**
         *
         * @param userId userID for den enkelte user
         * @return orderId
         * @throws LoginSampleException An error given when the login is faulty
         */
    public static int createOrder(int userId) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (users_id) VALUES (?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int orderId = ids.getInt(1);
            return orderId;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

        /**
         *
         * @param orderId ID for the specific order
         * @param quantity Amount of the specific cupcake
         * @param totalPrice Total price of the order
         * @param toppingId ID number for the specific topping
         * @param bottomId ID number for the specific bottom
         * @throws LoginSampleException Exception for login
         */
    public static void createOrderLine(int orderId, int quantity, double totalPrice, int toppingId, int bottomId) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orderline (orders_id,quantity,sum,topping_id,bottom_id) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ps.setInt(2, quantity);
            ps.setDouble(3, totalPrice);
            ps.setInt(4, toppingId);
            ps.setInt(5, bottomId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

        /**
         *
         * @param userId user id for the specific user
         * @param sumTotal the amount of money the users wallet is updated with
         * @throws LoginSampleException Exception for login
         */
    public static void updateUserCredit(int userId, double sumTotal) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE users SET credit = credit - ? WHERE users_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, sumTotal);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

        /**
         *
         * @param userId user id for the specific user
         * @return list of oldOrders
         * @throws SQLException An exception that provides information on a database access error or other errors
         */
    public static List<Orders> getOldOrders(int userId) throws SQLException {
        List<Orders> oldOrders = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE status = 'Afsluttet' AND users_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int oId = rs.getInt("orders_id");
                int uId = rs.getInt("users_id");
                String orderDate = rs.getString("order_date");
                String status = rs.getString("status");

                DateFormat iFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat oFormatter = new SimpleDateFormat("dd-MM-yyyy");
                String strDateTime = oFormatter.format(iFormatter.parse(orderDate));
                Orders orders = new Orders(oId, uId, strDateTime, status);
                oldOrders.add(orders);
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            throw new SQLException(ex.getMessage());
        }
        return oldOrders;
    }

    // Bliver ikke brugt??
    public static List<Orderline> getOldOrderlines(int ordersId) throws SQLException {
        List<Orderline> oldOrderLine = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT ol.orderline_id,o.orders_id,b.name as bottom, t.name as topping, ol.quantity, ol.sum  FROM users u\n" +
                    "INNER JOIN orders o on u.users_id = o.users_id\n" +
                    "INNER JOIN orderline ol on o.orders_id = ol.orders_id\n" +
                    "INNER JOIN topping t on ol.topping_id = t.topping_id\n" +
                    "INNER JOIN bottom b on ol.bottom_id = b.bottom_id\n" +
                    "WHERE o.status = 'Afsluttet' AND o.orders_id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, ordersId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int oId = rs.getInt("orders_id");
                int olId = rs.getInt("orderline_id");
                String bottom = rs.getString("order_date");
                String topping = rs.getString("order_date");
                int quantity = rs.getInt("quantity");
                double sum = rs.getDouble("sum");
                Orderline orderline = new Orderline(olId, oId, quantity, sum, bottom, topping);
                oldOrderLine.add(orderline);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return oldOrderLine;
    }

        /**
         *
         * @param userId user id for the specific user
         * @return list of getPreviousOrders
         * @throws SQLException An exception that provides information on a database access error or other errors
         */
    public static List<PreviousOrders> getPreviousOrders(int userId) throws SQLException {
        List<PreviousOrders> getPreviousOrders = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT o.orders_id, o.order_date, b.name as bottom, t.name as topping, ol.quantity, ol.sum  \n" +
                    "FROM users u\n" +
                    "INNER JOIN orders o on u.users_id = o.users_id\n" +
                    "INNER JOIN orderline ol on o.orders_id = ol.orders_id\n" +
                    "INNER JOIN topping t on ol.topping_id = t.topping_id\n" +
                    "INNER JOIN bottom b on ol.bottom_id = b.bottom_id\n" +
                    "WHERE o.status = 'Afsluttet' AND u.users_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int oId = rs.getInt("orders_id");
                String orderDate = rs.getString("order_date");
                String bottom = rs.getString("bottom");
                String topping = rs.getString("topping");
                int quantity = rs.getInt("quantity");
                double sum = rs.getDouble("sum");

                DateFormat iFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat oFormatter = new SimpleDateFormat("dd-MM-yyyy");
                String strDateTime = oFormatter.format(iFormatter.parse(orderDate));
                PreviousOrders previousOrders = new PreviousOrders(oId, strDateTime, bottom, topping, quantity, sum);
                getPreviousOrders.add(previousOrders);
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            throw new SQLException(ex.getMessage());
        }
        return getPreviousOrders;
    }

        /**
         *
         * @return list of getAllOrders
         * @throws SQLException An exception that provides information on a database access error or other errors
         */
    public static List<Orders> getAllOrders() throws SQLException {
        List<Orders> allOrders = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT o.orders_id, o.order_date, o.status, u.email, sum(ol.quantity) as quantity, sum(ol.sum) as total  FROM users u\n" +
                    "INNER JOIN orders o on u.users_id = o.users_id\n" +
                    "INNER JOIN orderline ol on o.orders_id = ol.orders_id\n" +
                    "GROUP BY o.orders_id\n" +
                    "ORDER BY o.status DESC, o.order_date DESC;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int oId = rs.getInt("orders_id");
                String orderDate = rs.getString("order_date");
                String status = rs.getString("status");
                String email = rs.getString("email");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");

                DateFormat iFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat oFormatter = new SimpleDateFormat("dd-MM-yyyy");
                String strDateTime = null;
                strDateTime = oFormatter.format(iFormatter.parse(orderDate));
                Orders allOrder = new Orders(oId, strDateTime, status, email, quantity, total);
                allOrders.add(allOrder);
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            throw new SQLException(ex.getMessage());
        }
        return allOrders;
    }

        /**
         *
         * @return list of GetOrderlines
         * @throws SQLException An exception that provides information on a database access error or other errors
         */
    public static List<Orderline> getOrderlines() throws SQLException {
        List<Orderline> AllOrderlines = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT o.orders_id,b.name as bottom, t.name as topping, ol.quantity, ol.sum  FROM users u\n" +
                    "INNER JOIN orders o on u.users_id = o.users_id\n" +
                    "INNER JOIN orderline ol on o.orders_id = ol.orders_id\n" +
                    "INNER JOIN topping t on ol.topping_id = t.topping_id\n" +
                    "INNER JOIN bottom b on ol.bottom_id = b.bottom_id";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int paramOrderID = rs.getInt("orders_id");
                String bottom = rs.getString("bottom");
                String topping = rs.getString("topping");
                int quantity = rs.getInt("quantity");
                double sum = rs.getDouble("sum");

                Orderline orderline = new Orderline(paramOrderID, bottom, topping, quantity, sum);
                AllOrderlines.add(orderline);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return AllOrderlines;
    }

        /**
         *
         * @param orderID ID for the specific order
         * @throws LoginSampleException An exception that provides information on a login error
         * @throws SQLException An exception that provides information on a database access error or other errors
         */
    public static void deleteOrder(int orderID) throws LoginSampleException, SQLException {
        try{
            Connection con = Connector.connection();
            String SQL = "DELETE FROM orders WHERE orders_id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex ) {
            throw new SQLException( ex.getMessage() );
        }
    }

        /**
         *
         * @param orderID  ID for the specific order
         * @param status the status of the order
         * @throws LoginSampleException An exception that provides information on a login error
         */
    public static void updateStatus(int orderID, String status) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET status = ? WHERE orders_id = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString(1, status);
            ps.setInt(2, orderID);
            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}