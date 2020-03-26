package FunctionLayer;

import DBAccess.CupCakeMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * front facing interface, masking more complex code.
 * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
 */
public class LogicFacade {

    /**
     *
     * @param email User email
     * @param password User password
     * @return UserMapper.login( email, password )
     * @throws LoginSampleException Exception for login
     */
    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }

    /**
     *
     * @param email User email
     * @param phone User phone
     * @param password User password
     * @return user
     * @throws LoginSampleException Exception for login
     */
    public static User createUser(String email, int phone, String password) throws LoginSampleException {
        User user = new User(email, phone, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    /**
     *
     * @param email User email
     * @throws LoginSampleException Exception for login
     */
    public static void deleteUser(String email) throws LoginSampleException {
        UserMapper.deleteUser( email );
    }

    /**
     *
     * @param email User email
     * @param credit User credit
     * @throws LoginSampleException Exception for login
     */
    public static void updateCredit(String email, String credit) throws LoginSampleException {
        UserMapper.updateCredit(email,credit);
    }

    /**
     *
     * @return UserMapper.viewCustomer()
     * @throws SQLException Exception for SQL
     */
    public static List<User> viewCustomer() throws SQLException {
        return UserMapper.viewCustomer();
    }

    /**
     *
     * @param id User ID
     * @param newCode New password
     * @throws LoginSampleException Exception for login
     */
    public static void resetCode(int id, String newCode) throws LoginSampleException {
        UserMapper.resetCode(id,newCode);
    }

    /**
     *
     * @return CupCakeMapper.getBottoms()
     * @throws SQLException Exception for SQL
     */
    public static List<Bottom> getBottoms() throws SQLException {
        return CupCakeMapper.getBottoms();
    }

    /**
     *
     * @return CupCakeMapper.getToppings()
     * @throws SQLException Exception for SQL
     */
    public static List<Topping> getToppings() throws SQLException {
        return CupCakeMapper.getToppings();
    }

    /**
     *
     * @param userId User ID
     * @return OrderMapper.createOrder(userId)
     * @throws LoginSampleException Exception for login
     */
    public static int createOrder(int userId) throws LoginSampleException {
        return OrderMapper.createOrder(userId);
    }

    /**
     *
     * @param orderId Order ID
     * @param quantity Quantity for cupcake
     * @param totalPrice Total price for orderline
     * @param toppingId Topping ID
     * @param bottomId Bottom ID
     * @throws LoginSampleException Exception for login
     */
    public static void createOrderline(int orderId, int quantity, double totalPrice, int toppingId, int bottomId) throws LoginSampleException {
        OrderMapper.createOrderLine(orderId,quantity,totalPrice,toppingId,bottomId);
    }

    /**
     *
     * @param userId User ID
     * @param sumTotal Amount of credit user is paying
     * @throws LoginSampleException Exception for login
     */
    public static void updateUserCredit(int userId, double sumTotal) throws LoginSampleException {
        OrderMapper.updateUserCredit(userId,sumTotal);
    }

    /**
     *
     * @param userId User ID
     * @return OrderMapper.getOldOrders(userId)
     * @throws SQLException Evception for SQL
     */
    public static List<Orders> getOldOrders(int userId) throws SQLException {
        return OrderMapper.getOldOrders(userId);
    }

    /**
     *
     * @param ordersId Order ID
     * @return OrderMapper.getOldOrderlines(ordersId)
     * @throws SQLException Exception for SQL
     */
    public static List<Orderline> getOldOrderlines(int ordersId) throws SQLException {
        return  OrderMapper.getOldOrderlines(ordersId);
    }

    /**
     *
     * @param userId User ID
     * @return OrderMapper.getPreviousOrders(userId)
     * @throws SQLException Exception for SQL
     */
    public static List<PreviousOrders> getPreviousOrders(int userId) throws SQLException {
        return OrderMapper.getPreviousOrders(userId);
    }

    /**
     *
     * @return OrderMapper.getAllOrders()
     * @throws SQLException Exception for SQL
     */
    public static List<Orders> getAllOrders() throws SQLException {
        return OrderMapper.getAllOrders();
    }

    /**
     *
     * @return OrderMapper.getOrderlines()
     * @throws SQLException exception for SQL
     */
    public static List<Orderline> getOrderlines() throws SQLException {
        return OrderMapper.getOrderlines();
    }

    /**
     *
     * @param orderID Order ID
     * @throws LoginSampleException Exception for login
     * @throws SQLException Exception for SQL
     */
    public static void deleteOrder(int orderID) throws LoginSampleException, SQLException {
        OrderMapper.deleteOrder(orderID);
    }

    /**
     *
     * @param orderID Order ID
     * @param status Order status
     * @throws LoginSampleException Exception for login
     */
    public static void updateStatus(int orderID, String status) throws LoginSampleException {
        OrderMapper.updateStatus(orderID, status);
    }

}