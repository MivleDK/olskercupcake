package FunctionLayer;

import DBAccess.UserMapper;

import java.sql.SQLException;
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
}
