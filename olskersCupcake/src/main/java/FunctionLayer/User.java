package FunctionLayer;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User( String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int id, String email, String password, String role ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User( String email) {
        this.email = email;

    }
    public User( String password, String email,int phone) {
        this.password = password;
        this.email = email;
        this.phone = phone;


    }
    public User( int id, String email, String password, int phone ) {
        this.id = id;
        this.email = email;
        this.password = password;

        this.phone = phone;
    }
    public User(String email, String password, String role, int phone ) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
    }


    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private int phone;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

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

    public Integer getPhone() { return phone;    }

}
