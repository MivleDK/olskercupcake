package FunctionLayer;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    /**
     * delete user
     */
    public User(String email) {
        this.email = email;
    }

    /**
     * Login
     */
    public User(String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Create user
     */
    public User(String email, int phone, String password, String role ) {
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private int phone;
    private String password; // Should be hashed and secured
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setPhone(int phone) { this.phone = phone; }

    public int getPhone() { return phone; }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

}
