package FunctionLayer;

/**
 * The purpose of LoginSampleException is to give an error on failed login
 * @author kasper
 */
public class LoginSampleException extends Exception {

    /**
     *
     * @param msg Message for login exception
     */
    public LoginSampleException(String msg) {
        super(msg);
    }
    

}
