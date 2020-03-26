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
     * @param email
     * @param password
     * @return UserMapper.login( email, password )
     * @throws LoginSampleException
     */
    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }

    /**
     *
     * @param email
     * @param phone
     * @param password
     * @return user
     * @throws LoginSampleException
     */
    public static User createUser(String email, int phone, String password) throws LoginSampleException {
        User user = new User(email, phone, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    /**
     *
     * @param email
     * @throws LoginSampleException
     */
    public static void deleteUser(String email) throws LoginSampleException {
        UserMapper.deleteUser( email );
    }

    /**
     *
     * @param email
     * @param credit
     * @throws LoginSampleException
     */
    public static void updateCredit(String email, String credit) throws LoginSampleException {
        UserMapper.updateCredit(email,credit);
    }

    /**
     *
     * @return UserMapper.viewCustomer()
     * @throws SQLException
     */
    public static List<User> viewCustomer() throws SQLException {
        return UserMapper.viewCustomer();
    }

    /**
     *
     * @param id
     * @param newCode
     * @throws LoginSampleException
     */
    public static void resetCode(int id, String newCode) throws LoginSampleException {
        UserMapper.resetCode(id,newCode);
    }

    /**
     *
     * @return CupCakeMapper.getBottoms()
     * @throws SQLException
     */
    public static List<Bottom> getBottoms() throws SQLException {
        return CupCakeMapper.getBottoms();
    }

    /**
     *
     * @return CupCakeMapper.getToppings()
     * @throws SQLException
     */
    public static List<Topping> getToppings() throws SQLException {
        return CupCakeMapper.getToppings();
    }

    /**
     *
     * @param userId
     * @return OrderMapper.createOrder(userId)
     * @throws LoginSampleException
     */
    public static int createOrder(int userId) throws LoginSampleException {
        return OrderMapper.createOrder(userId);
    }

    /**
     *
     * @param orderId
     * @param quantity
     * @param totalPrice
     * @param toppingId
     * @param bottomId
     * @throws LoginSampleException
     */
    public static void createOrderline(int orderId, int quantity, double totalPrice, int toppingId, int bottomId) throws LoginSampleException {
        OrderMapper.createOrderLine(orderId,quantity,totalPrice,toppingId,bottomId);
    }

    /**
     *
     * @param userId
     * @param sumTotal
     * @throws LoginSampleException
     */
    public static void updateUserCredit(int userId, double sumTotal) throws LoginSampleException {
        OrderMapper.updateUserCredit(userId,sumTotal);
    }

    /**
     *
     * @param userId
     * @return OrderMapper.getOldOrders(userId)
     * @throws SQLException
     */
    public static List<Orders> getOldOrders(int userId) throws SQLException {
        return OrderMapper.getOldOrders(userId);
    }

    /**
     *
     * @param ordersId
     * @return OrderMapper.getOldOrderlines(ordersId)
     * @throws SQLException
     */
    public static List<Orderline> getOldOrderlines(int ordersId) throws SQLException {
        return  OrderMapper.getOldOrderlines(ordersId);
    }

    /**
     *
     * @param userId
     * @return OrderMapper.getPreviousOrders(userId)
     * @throws SQLException
     */
    public static List<PreviousOrders> getPreviousOrders(int userId) throws SQLException {
        return OrderMapper.getPreviousOrders(userId);
    }

    /**
     *
     * @return OrderMapper.getAllOrders()
     * @throws SQLException
     */
    public static List<Orders> getAllOrders() throws SQLException {
        return OrderMapper.getAllOrders();
    }

    /**
     *
     * @return OrderMapper.getOrderlines()
     * @throws SQLException
     */
    public static List<Orderline> getOrderlines() throws SQLException {
        return OrderMapper.getOrderlines();
    }

    /**
     *
     * @param orderID
     * @throws LoginSampleException
     * @throws SQLException
     */
    public static void deleteOrder(int orderID) throws LoginSampleException, SQLException {
        OrderMapper.deleteOrder(orderID);
    }

    /**
     *
     * @param orderID
     * @param status
     * @throws LoginSampleException
     */
    public static void updateStatus(int orderID, String status) throws LoginSampleException {
        OrderMapper.updateStatus(orderID, status);
    }

}