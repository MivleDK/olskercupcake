package FunctionLayer;

import DBAccess.CupCakeMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser(String email, int phone, String password) throws LoginSampleException {
        User user = new User(email, phone, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static void deleteUser(String email) throws LoginSampleException {
        UserMapper.deleteUser( email );
    }

    public static void updateCredit(String email, String credit) throws LoginSampleException {
        UserMapper.updateCredit(email,credit);
    }

    public static List<User> viewCustomer() throws SQLException {
        return UserMapper.viewCustomer();
    }

    public static void resetCode(int id, String newCode) throws LoginSampleException {
        UserMapper.resetCode(id,newCode);
    }

    public static List<Bottom> getBottoms() throws SQLException {
        return CupCakeMapper.getBottoms();
    }

    public static List<Topping> getToppings() throws SQLException {
        return CupCakeMapper.getToppings();
    }

    public static int createOrder(int userId) throws LoginSampleException {
        return OrderMapper.createOrder(userId);
    }

    public static void createOrderline(int orderId, int quantity, double totalPrice, int toppingId, int bottomId) throws LoginSampleException {
        OrderMapper.createOrderLine(orderId,quantity,totalPrice,toppingId,bottomId);
    }

    public static void updateUserCredit(int userId, double sumTotal) throws LoginSampleException {
        OrderMapper.updateUserCredit(userId,sumTotal);
    }

    public static List<Orders> getOldOrders(int userId) throws SQLException {
        return OrderMapper.getOldOrders(userId);
    }

    public static List<Orderline> getOldOrderlines(int ordersId) throws SQLException {
        return  OrderMapper.getOldOrderlines(ordersId);
    }

    public static List<PreviousOrders> getPreviousOrders(int userId) throws SQLException {
        return OrderMapper.getPreviousOrders(userId);
    }

    public static List<Orders> getAllOrders() throws SQLException {
        return OrderMapper.getAllOrders();
    }
}