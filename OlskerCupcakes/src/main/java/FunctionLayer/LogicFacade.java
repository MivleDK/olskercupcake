package FunctionLayer;

import DBAccess.UserMapper;

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

    public static User deleteUser(String email) {
        User user = new User(email);
        UserMapper.deleteUser( user );
        return user;
    }

    public static void updateCredit(String email, String credit) {
        UserMapper.updateCredit(email,credit);
    }
}
