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

    public static User createUser( String email, String password, int phone ) throws LoginSampleException {
        User user = new User(email, password, "customer", phone);
        UserMapper.createUser( user );
        return user;
    }
    public static User createUser( String email, String password, String role, int phone ) throws LoginSampleException {
        User user = new User(email, password, role, phone);
        UserMapper.createUser( user );
        return user;
    }
    public static User Slet( String email)  {
        User user = new User(email);
        UserMapper.Slet( user );
        return user;
    }
    public static User Opdater( String password, String email,int phone)  {
        User user = new User(password, email, phone);
        UserMapper.Opdater( user );
        return user;
    }
    public static User Nulstil(String email)  {
        User user = new User(email);
        UserMapper.Nulstil( user );
        return user;
    }

}
